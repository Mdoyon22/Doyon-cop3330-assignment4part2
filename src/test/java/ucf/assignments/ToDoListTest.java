/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.CheckBox;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


class ToDoListTest
{
    //Global declaration of ToDoList object
    private ToDoList list;

    //Create a panel for testing the list and item object
    //since used CheckBox (javafx) object by Item class
    private JFXPanel panel = new JFXPanel();

    @Test
    void addItem_test()
    {
        //Test addItem()
        //Initialize ToDoList object
        list = new ToDoList();

        //Create an expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Creating dummy data of item's objects
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy data into ToDoList object using addItem() method
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        //Add dummy data into expected ArrayList
        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);

        //Compare both by converting to arrays and check if they are equal
        assertArrayEquals(expectedItems.toArray(), list.getAllItems().toArray());
    }


    @Test
    void removeItem_test()
    {
        //Test removeItem()
        //Initialize ToDoList object
        list = new ToDoList();

        //Also create an expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Create dummy data of item's objects
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy data into ToDoList object using addItem() method
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        //Also add into the expected ArrayList
        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);

        //Call removeItem() on dummy item
        list.removeItem(item3);

        //Call remove on expected ArrayList on the same dummy item
        expectedItems.remove(item3);

        //Check if both ArrayList are equal by converting to arrays
        assertArrayEquals(expectedItems.toArray(), list.getAllItems().toArray());
    }


    @Test
    void removeItem_Test_False()
    {
        //Check if removeItem() works

        //Initialize ToDoList object
        list = new ToDoList();

        //Create an expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Create dummy data of item's objects
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy items into ToDoList object
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        //Also add into expected ArrayList
        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);


        //Remove a random item from dummy data
        list.removeItem(item1);

        //Remove a different item
        expectedItems.remove(item3);


        //Should be false, since they both removed a different item
        Boolean check = (list.getAllItems().equals(expectedItems));

        //Check if it is false
        assertFalse(check);
    }


    @Test
    void clearAll_Test()
    {
        //clearAll()
        //Initialize ToDoList object
        list = new ToDoList();

        //Create an expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Create dummy data of items' objects
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy items to list object and expected ArrayList
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);

        //Call list's clearAll() method
        list.clearAll();

        //Also clear the expected ArrayList
        expectedItems.clear();

        //Since both are cleared, they are supposed to be equal
        //compare by converting to arrays
        assertArrayEquals(expectedItems.toArray(), list.getAllItems().toArray());
    }


    @Test
    void updateItem_Description_Test()
    {
        //updateItem() -> Description
        //Initialize ToDoList object
        list = new ToDoList();

        //Create dummy data of item object
        Item item = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy item object into ToDoList object
        list.addItem(item);

        //Update the item's description
        list.updateItem(item, "OOP GUI Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Check if the item's description has been updated
        assertEquals(item.getDescription(), "OOP GUI Assignment");
    }


    @Test
    void updateItem_DueDate_Test()
    {
        //updateItem() -> DueDate
        //Initialize ToDoList object
        list = new ToDoList();

        //Create dummy data of item object
        Item item = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy item object into ToDoList object
        list.addItem(item);

        //Update the item's due date
        list.updateItem(item, "OOP GUI Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Check if the item's due date has been updated
        assertEquals(item.getDueDate(), LocalDate.of(2021, Month.NOVEMBER, 15));
    }


    @Test
    void markComplete_True_Test()
    {
        //setComplete() -> item's setter
        //Check if complete is set to checked
        //Initialize ToDoList object
        list = new ToDoList();

        //Create dummy data for item object
        Item item = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Create a temp CheckBox and assign it to true
        CheckBox testComplete = new CheckBox();
        testComplete.setSelected(true);

        //Add the temp CheckBox to the dummy item
        item.setComplete(testComplete);

        //Check if the item is set to true
        assertTrue(item.getComplete().isSelected());
    }


    @Test
    void markComplete_False_Test()
    {
        //setComplete() -> item's setter
        //Check if complete is set to unchecked
        //Initialize ToDoList object
        list = new ToDoList();

        //Create dummy data for item object
        Item item = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Create a temp CheckBox and assign it to false
        CheckBox testComplete = new CheckBox();
        testComplete.setSelected(false);

        //Add the temp CheckBox to the dummy item
        item.setComplete(testComplete);

        //Check if the item is set to false
        assertFalse(item.getComplete().isSelected());
    }


    @Test
    void getAllItems_Test()
    {
        //getAllItems()
        //Initialize ToDoList object
        list = new ToDoList();

        //Create expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Create dummy data of item's object
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy items to list object and expected ArrayList
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        expectedItems.add(item1);
        expectedItems.add(item2);
        expectedItems.add(item3);

        //Call getItems() and set to new actualItems ArrayList
        ArrayList<Item> actualItems = list.getAllItems();

        //Compare both ArrayLists to see if they are the same, then convert to array
        assertArrayEquals(expectedItems.toArray(), actualItems.toArray());
    }


    @Test
    void completeItems_Test()
    {
        //completeItems()
        //Initialize ToDoList object
        list = new ToDoList();

        //Also create expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Create dummy data of item's object
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));
        Item item4 = new Item("CS1 Assignment", LocalDate.of(2021, Month.NOVEMBER, 14));

        //Add the dummy data into ToDoList object and expected ArrayList
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);
        list.addItem(item4);

        //Create temp CheckBox and set it to true
        CheckBox temp = new CheckBox();
        temp.setSelected(true);

        //Set the true CheckBox to 2 of the 4 dummy item's using setComplete()
        item2.setComplete(temp);
        item4.setComplete(temp);

        //Add only the true items into the expected ArrayList
        expectedItems.add(item2);
        expectedItems.add(item4);

        //Call completeItems() and set to new actualItems ArrayList
        ArrayList<Item> actualItems = list.completeItems();

        //Compare both ArrayLists to see if they are the same, convert to array
        assertArrayEquals(expectedItems.toArray(), actualItems.toArray());
    }


    @Test
    void inCompleteItems_Test()
    {
        //inCompleteItems()
        //Initialize ToDoList object
        list = new ToDoList();

        //Create expected ArrayList for comparing
        ArrayList<Item> expectedItems = new ArrayList<>();

        //Create dummy data of item's object
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));
        Item item4 = new Item("CS1 Assignment", LocalDate.of(2021, Month.NOVEMBER, 14));

        //Add the dummy data into ToDoList object and expected ArrayList
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);
        list.addItem(item4);

        //Create temp CheckBox and set to true
        CheckBox temp = new CheckBox();
        temp.setSelected(true);

        //Set the true CheckBox to 2 of the 4 dummy item's using setComplete()
        item2.setComplete(temp);
        item4.setComplete(temp);

        //Add only the false items into the expected ArrayList
        expectedItems.add(item1);
        expectedItems.add(item3);

        //Call inCompleteItems() and set it to new actualItems ArrayList
        ArrayList<Item> actualItems = list.inCompleteItems();

        //Compare both ArrayLists to see if they are the same, convert to array
        assertArrayEquals(expectedItems.toArray(), actualItems.toArray());
    }


    @Test
    void save_Test()
    {
        //save()
        //Initialize ToDoList object
        list = new ToDoList();

        //Create dummy data of Item's object
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy items into ToDoList object
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        //Create a temp CheckBox and set 1 item to true
        CheckBox temp = new CheckBox();
        temp.setSelected(true);
        item2.setComplete(temp);

        //Create a File with a directory
        File file = new File("/Users/Michael/Desktop/ToDo_Doyon/Testing.csv");
        //Call list's save() method with File
        list.save(file);

        //For comparing create a string and read the file
        String actual = "";

        try
        {
            //Read the file
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = "";

            while ((line = br.readLine()) != null)
            {
                //Add the file values into the actual string
                actual += line + "\n";
            }
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Create an expected string with dummy item's value
        String expected = """
                Description,DueDate,Completed
                Cook,2021-11-12,no
                Go to gym,2021-11-18,yes
                OOP Assignment,2021-11-15,no
                """;

        //Compare expected string with actual string from reading the saved file
        assertEquals(expected, actual);
    }


    @Test
    void load_Test()
    {
        //load()
        //Initialize ToDoList object
        list = new ToDoList();

        //Create a dummy data of item's object
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 12));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Create a temp CheckBox and set it to true
        //Add to the item
        CheckBox temp = new CheckBox();
        temp.setSelected(true);
        item2.setComplete(temp);

        //Add the dummy item to ToDoList object
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        //Create a new File and save it
        File file = new File("/Users/Michael/Desktop/ToDo_Doyon/Testing.csv");
        list.save(file);

        //Call load() method and assign the return value to actual ArrayList
        ArrayList<Item> actual = list.load(file);

        //Convert the ArrayList of items to string, same format as expected
        //convertToString()
        String actualString = convertToString(actual);

        //Create and expectedString from dummy item's values
        String expectedString = """
                Description,DueDate,Completed
                Cook,2021-11-12,no
                Go to gym,2021-11-18,yes
                OOP Assignment,2021-11-15,no
                """;

        //Compare expected string with actual string from loading the saved file
        assertEquals(expectedString, actualString);
    }


    public String convertToString(ArrayList<Item> list)
    {
        //Converts the ArrayList of items to string data
        //Same format as expected string
        String ret = "Description,DueDate,Completed\n";

        for (Item item : list)
        {
            //Get description and due date
            //Add to the return string
            ret += item.getDescription() + ",";
            ret += item.getDueDate().toString() + ",";

            if (item.getComplete().isSelected())
            {
                ret += "yes\n";
            }

            else
            {
                ret += "no\n";
            }
        }

        //Return the built string from ArrayList
        return ret;
    }
}