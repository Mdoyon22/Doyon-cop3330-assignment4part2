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
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 11));
        Item item2 = new Item("Go to gym", LocalDate.of(2021, Month.NOVEMBER, 18));
        Item item3 = new Item("OOP Assignment", LocalDate.of(2021, Month.NOVEMBER, 15));

        //Add the dummy data into ToDoList object using addItem() method
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

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
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 11));
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
        Item item1 = new Item("Cook", LocalDate.of(2021, Month.NOVEMBER, 11));
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
}