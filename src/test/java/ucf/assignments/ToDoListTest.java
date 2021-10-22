/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ToDoListTest
{
    //Test whether editTitle of list works
    @Test
    void editTitle_Test()
    {
        //Create a temp ToDoList object
        //Call editTitle() with 'newTitle' parameter

        //To check whether the title was updated
        //Call getTitle() of the temp ToDoList object

        //assert whether 'newTitle' is same as the return value from getTitle()
    }


    //Test whether add a new item to list works
    @Test
    void addItem_Test()
    {
        //Create a temp ToDoList object - 'list'
        //Also create a new temp Item object - 'item'
        //Call addItem() with 'item' as parameter on temp 'list'

        //Call getAllItems() on temp 'list'
        //Initialize the return arraylist of item from getAllItems() - 'allItems'

        //Check whether the item has been added
        //assert whether the new temp Item 'item' is in the 'allItems'
    }


    //Test whether remove an item from list works
    @Test
    void removeItem_Test()
    {
        //Create a temp ToDoList object - 'list'
        //Create a new temp Item object - 'item'
        //Call addItem() with 'item' as parameter on temp 'list'
        //Call removeItem() with 'item' as parameter

        //Call getAllItems() on temp 'list'
        //Initialize the return arraylist of item from getAllItems() - 'allItems'

        //Check whether the item has been removed
        //assert whether the new temp Item 'item' is not in the 'allItems'
    }


    //Display options testing

    //Test whether display (or return) of all items works
    @Test
    void getAllItems_Test()
    {
        //Create a temp ToDoList object - 'list'
        //Create several Item objects - ArrayList<Item> 'items' (regardless of complete/incomplete)
        //Loop through 'items' and call addItem() with each item as parameter on temp 'list'


        //Check whether the get all item works
        //Call getAllItems() on temp 'list'
        //Initialize the return arraylist of item from getAllItems() - 'allItems'
        //assert whether the 'items' arraylist is same as the 'allItems' arraylist
    }


    //Test whether display (or return) of all incomplete items works
    @Test
    void inCompleteItems_Test()
    {
        //Create a temp ToDoList object - 'list'
        //Create several Item objects - ArrayList<Item> 'items'
        //Create some complete items and other incomplete items using Item's editFinished()
        //Add the incomplete items to arraylist - 'tempIncomplete'
        //Loop through 'items' and call addItem() with each item as parameter on temp 'list'

        //Check whether the get all incomplete items works
        //Call inCompleteItems() on temp 'list'
        //Initialize the return arraylist of item from inCompleteItems() - 'incomplete'
        //assert whether the 'tempIncomplete' arraylist is same as the 'incomplete' arraylist
    }


    //Test whether display (or return) of all complete items works
    @Test
    void completeItems_Test()
    {
        //Create a temp ToDoList objects - 'list'
        //Create several Item objects - ArrayList<Item> 'items'
        //Create some complete items and other incomplete items using Item's editFinished()
        //Add the complete items to arraylist - 'tempComplete'
        //Loop through 'items' and call addItem() with each item as parameter on temp 'list'

        //Check whether the get all complete items works
        //Call completeItems() on temp 'list'
        //Initialize the return arraylist of item from completeItems() - 'complete'
        //assert whether the 'tempComplete' arraylist is same as the 'complete' array
    }
}