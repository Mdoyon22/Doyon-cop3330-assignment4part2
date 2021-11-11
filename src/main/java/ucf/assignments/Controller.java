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
}
