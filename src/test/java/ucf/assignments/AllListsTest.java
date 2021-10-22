/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AllListsTest
{
    //Testing


    //Test whether new ToDoList list object is added into all lists arraylist
    @Test
    void addToDoList_Test()
    {
        //Create a temp ToDoList object
        //Call addToDoList() by passing the temp ToDoList object

        //Check whether the list has been added to all of the lists
        //Call listExists()

        //assertTrue the boolean value from listExists()
    }


    //Test whether new ToDoList list object is removed from all lists arraylist
    @Test
    void removeToDoList_Test()
    {
        //Find a temp ToDoList object from all lists arraylist by rand
        //Call removeToDoList() by passing the temp ToDoList object

        //Check whether the list has been removed to all of the lists
        //Call listExists()

        //assertFalse the boolean value from listExists()
    }


    //Test whether all lists are saved to an external storage
    @Test
    void saveAll_test()
    {
        //Initialize few random lists and items object to 'lists' arrayList
        //call saveAll()

        //To check whether they are all saved call loadAll()
        //Initialize the return value from loadAll() to new arraylist of ToDoList objects 'newLists'

        //assert whether the 'lists' and 'newLists' are same
    }


    //Test whether all lists are loaded from an external storage
    @Test
    void loadAll_test()
    {
        //Initialize few random lists and items object to 'lists' arrayList
        //Call saveAll()
        //Then call loadAll()
        //Initialize the return value from loadAll() to new arrayList of ToDoList objects 'newLists'

        //To check whether they are all loaded
        //assert whether the 'lists' and 'newLists' are same
    }


    //Test whether a list is saved to an external storage
    @Test
    void save_Test()
    {
        //Initialize few random items object to 'list' arrayList
        //Call save() by passing 'list'

        //To check whether that list is saved call loadRecent()
        //Initialize the return value from loadRecent() to new ToDoList object 'newList'

        //assert whether the 'list' and 'newList' are same
    }


    //Test whether a list is loaded from an external storage
    @Test
    void loadRecent_Test()
    {
        //Initialize few random items object to 'list' arrayList
        //call save() by passing 'list'
        //Then call loadRecent()
        //Initialize the return value from loadRecent() to new ToDoList object 'newList'

        //To check whether that list is loaded
        //assert whether the 'list' and 'newList' are same
    }
}