/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.StringConverter;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.ResourceBundle;


public class Controller implements Initializable
{
    //Create a list object
    ToDoList list = new ToDoList();

    //Global observable list
    ObservableList<Item> obList = FXCollections.observableArrayList();

    //Label that shows file name when loaded
    @FXML private Label fileLabel;

    //Vertical box for "save" and "load" buttons
    @FXML private VBox fileBox;

    //Global fileChooser for "save" and "load"
    FileChooser fileChooser = new FileChooser();

    //Dropdown combobox for display options
    @FXML private ComboBox<String> displayOptionsBox;

    //Configuring table and table columns
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<Item, CheckBox> completedColumn;


    //Instance variables for text field and date picker
    @FXML private TextField descriptionTextField;
    @FXML private DatePicker dueDatePicker;


    //Runs when stage is launched
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //Sets cell value factory to Item's values
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("dueDate"));
        completedColumn.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("complete"));

        //Add options to display options
        displayOptionsBox.getItems().addAll("All Items", "Incomplete Items", "Completed Items");

        //Creates a folder in desktop for to-do lists
        String currentUser = System.getProperty("user.home");
        String directory = currentUser + File.separator + "Desktop";
        String newFolder = directory + File.separator + "ToDo_Doyon";
        File newDirectory = new File(newFolder);
        newDirectory.mkdirs();

        //Initialize the directory for file chooser
        fileChooser.setInitialDirectory(newDirectory);

        //Converts date picker format to YYYY-MM-DD
        dueDatePicker.setConverter(new StringConverter<LocalDate>()
        {
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            {
                dueDatePicker.setPromptText(pattern.toLowerCase());
            }


            @Override public String toString(LocalDate date)
            {
                if (date != null)
                {
                    return dateFormatter.format(date);
                }

                else
                {
                    return "";
                }
            }


            @Override public LocalDate fromString(String string)
            {
                if (string != null && !string.isEmpty())
                {
                    return LocalDate.parse(string, dateFormatter);
                }

                else
                {
                    return null;
                }
            }
        });


        //Initially set file label to null, nothing opened yet
        fileLabel.setText("");


        //Initializes and converts ArrayList to ObservableList for display
        obList = FXCollections.observableArrayList(list.getAllItems());
        //Sort method
        sortByDate();
        //Displays
        tableView.setItems(obList);

        //Allows to select one row at a time from the table for editing or deleting purposes
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


    //Save
    public void saveButtonClicked(ActionEvent actionEvent)
    {
        //Shows a new window for saving the file
        Window stage = fileBox.getScene().getWindow();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        fileChooser.setTitle("Save Dialog");
        fileChooser.setInitialFileName("ToDoList_" + date);

        //Only accepts CSV files
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV file", "*.csv"));

        try
        {
            File file = fileChooser.showSaveDialog(stage);
            //Sets a directory for future reference
            fileChooser.setInitialDirectory(file.getParentFile());

            if (file != null)
            {
                //Calls list's save method to write into that file
                list.save(file);
            }
        }

        catch (Exception ex)
        {
            System.out.println("An error occurred.");
        }
    }


    //Load
    public void loadButtonClicked(ActionEvent actionEvent)
    {
        //Shows a new window for opening an existing to-do
        Window stage = fileBox.getScene().getWindow();

        fileChooser.setTitle("Load Dialog");

        //Only accepts CSV files
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV file", "*.csv"));

        try
        {
            File file = fileChooser.showOpenDialog(stage);
            //Sets a directory for future reference
            fileChooser.setInitialDirectory(file.getParentFile());

            //Gets file name and shows in the to-do application
            fileLabel.setText(file.getName());

            if (file != null)
            {
                //Call list's load to get ArrayList of items
                //Convert to ObservableList and sort by date and display in the table
                obList = FXCollections.observableArrayList(list.load(file));
                sortByDate();
                tableView.setItems(obList);
            }
        }

        catch (Exception ex)
        {
            System.out.println("An error occurred.");
        }
    }


    //Display options
    public void displayOptionsAction(ActionEvent actionEvent)
    {
        //Get selected option from combobox
        String selectedOption = displayOptionsBox.getValue();

        //Check which option selected and call that method
        if (selectedOption.equalsIgnoreCase("all items"))
        {
            //Console message
            System.out.println("All items displaying...");
            displayAllItems();
        }

        else if (selectedOption.equalsIgnoreCase("incomplete items"))
        {
            //Console message
            System.out.println("Incomplete items displaying...");
            displayIncompleteItems();
        }

        else if (selectedOption.equalsIgnoreCase("completed items"))
        {
            //Console message
            System.out.println("Completed items displaying...");
            displayCompletedItems();
        }
    }


    public void displayAllItems()
    {
        //Call list's getAllItems()
        //Convert to ObservableList
        //Sort by date
        //Display on the table
        obList = FXCollections.observableArrayList(list.getAllItems());
        sortByDate();
        tableView.setItems(obList);
    }


    public void displayIncompleteItems()
    {
        //Console message
        System.out.println(list.inCompleteItems());

        //Calls list's inCompleteItems()
        //Convert to ObservableList
        //Sort by date
        //Display on the table
        obList = FXCollections.observableArrayList(list.inCompleteItems());
        sortByDate();
        tableView.setItems(obList);
    }


    public void displayCompletedItems()
    {
        //Console message
        System.out.println(list.completeItems());

        //Calls list's completeItems()
        //Convert to ObservableList
        //Sort by date
        //Display on the table
        obList = FXCollections.observableArrayList(list.completeItems());
        sortByDate();
        tableView.setItems(obList);
    }


    public void sortByDate()
    {
        //Sort the ObservableList using a comparator
        //Compares date objects and sorts

        FXCollections.sort(obList, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2)
            {
                return o1.getDueDate().compareTo(o2.getDueDate());
            }
        });
    }


    //Item options
    public void addItemClicked(ActionEvent actionEvent)
    {
        //Console message
        System.out.print("Adding item: ");
        System.out.print(descriptionTextField.getText() + " ");
        System.out.print(dueDatePicker.getValue() + "\n");

        //Check if the text field or date picker are left blank, if so show error
        if (descriptionTextField.getText().equals("") || dueDatePicker.getValue().equals(null))
        {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("The fields or date picker can't be left blank.");
            errorAlert.setContentText("Please enter valid description between 1 and 256 characters and valid date.");
            errorAlert.showAndWait();
        }

        else if (list.itemExists(descriptionTextField.getText()))
        {
            //Checks if the item already exists, if so show error
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Items exists already");
            errorAlert.setContentText("Please edit the existing item. Duplicate items are not supported.");
            errorAlert.showAndWait();
        }

        else
        {
            //If text field and date picker are not left blank nor item does not exist
            //create new Item object from information in text fields and date picker
            Item newItem = new Item(descriptionTextField.getText(), dueDatePicker.getValue());
            //Add to list
            list.addItem(newItem);

            //Add to the display
            tableView.getItems().add(newItem);
            //Sort by date
            sortByDate();
            //Refresh table
            tableView.refresh();

            //Clear the fields for adding next item
            clearField();
        }
    }


    public void removeItemClicked(ActionEvent actionEvent)
    {
        //Get selected row from the table
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();

        //Console message
        System.out.print("Removing item: ");
        System.out.println(selectedItem.getDescription() + " ");
        System.out.println(selectedItem.getDueDate() + "\n");

        //Display that item in the text field and date picker
        displayItem(selectedItem);

        //Call list's removeItem() method
        list.removeItem(selectedItem);
        //Remove it from the table
        tableView.getItems().remove(selectedItem);

        //Sort by date again
        sortByDate();
        //Refresh the table
        tableView.refresh();

        //Clear the text field and date picker
        clearField();
    }


    public void clearAllClicked()
    {
        //Console message
        System.out.println("Clearing all");

        //Call list's clearAll() method
        list.clearAll();

        //Also clear from the table display
        tableView.getItems().clear();
    }


    public void editItemClicked(ActionEvent actionEvent)
    {
        //Get the selected item from the table
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();

        //Console message
        System.out.print("Editing item: ");
        System.out.println(selectedItem.getDescription() + " ");
        System.out.println(selectedItem.getDueDate() + "\n");

        //Create new temp variables and assign with information from fields
        String newDescription = descriptionTextField.getText();
        LocalDate newDueDate = dueDatePicker.getValue();

        //Call list's updateItem() method by passing new temp variables
        list.updateItem(selectedItem, newDescription, newDueDate);
        //Sort by date again
        sortByDate();
        //Refresh the table
        tableView.refresh();

        //Clear the text field and date picker
        clearField();
    }


    public void helpButtonClicked(ActionEvent actionEvent) throws IOException
    {
        //Open a new separate window
        Parent helpScreenParent = FXMLLoader.load(getClass().getResource("HelpScreen.fxml"));

        //Scroll pane, makes the window scrollable
        ScrollPane sp = new ScrollPane();
        sp.setContent(helpScreenParent);

        //Sets stage and scene with width and height
        Stage helpStage = new Stage();
        helpStage.setTitle("Help");
        helpStage.setScene(new Scene(sp, 720, 500));
        //Displays
        helpStage.show();
    }


    //Gets selected row/item from the table and displays it
    public void selectedRow()
    {
        //Gets item
        Item selectedItem = tableView.getSelectionModel().getSelectedItem();
        //Display
        displayItem(selectedItem);
    }


    public void displayItem(Item item)
    {
        //Sets the fields and date picker to selected item's values
        descriptionTextField.setText(item.getDescription());
        dueDatePicker.setValue(item.getDueDate());
    }


    public void clearField()
    {
        //Clear text fields and date picker
        descriptionTextField.setText("");
        dueDatePicker.setValue(null);
    }
}
