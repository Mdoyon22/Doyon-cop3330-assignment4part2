/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import java.util.ArrayList;

public class AllLists
{
    //Public ArrayList<ToDoList> 'lists' for all the to-do lists
    //Private ToDoList latestSave object for latest saved list

    public void addToDoList(ToDoList list)
    {
        //Get a new created ToDoList object
        //Add that ToDoList object (parameter) to all the 'lists'
    }

    public void removeToDoList(ToDoList list)
    {
        //Loop through ArrayList<ToDoList> and find the given parameter object
        //Remove it from the arraylist
    }

    public void saveAll()
    {
        //Loop through all the lists and
        //save all the lists to external storage
        //Update the last saved list to latestSave
    }

    public ArrayList<ToDoList> loadAll()
    {
        //Create a new ArrayList for saved lists
        //Load all the lists to external storage into the new arraylist
        //Return the new arraylist of saved lists
        return null; //setting null for now
    }

    public void save(ToDoList list)
    {
        //Find the list through all lists ArrayList<ToDoList>
        //Save only that list
        //Update the latestSave object
    }

    public ToDoList loadRecent()
    {
        //Get list saved recently from latestSave object
        //Load that list from external storage
        //Return the latestSave object
        return null; //setting null for now
    }

    public Boolean listExists(ToDoList list)
    {
        //Checks whether the list exists in the AllLists arraylist of all lists
        //Return true if exists and found, else false
        return false; //setting false for now
    }

    public ArrayList<ToDoList> sort(ArrayList<ToDoList> lists)
    {
        //Declare and initialize new arraylist 'sortedLists'
        //Sort the passed parameter using Comparator on item's getDate() date object
        //Copy the contents of sort into sortedLists
        //Return the sortedLists arraylist
        return null; //setting null for now
    }
}
