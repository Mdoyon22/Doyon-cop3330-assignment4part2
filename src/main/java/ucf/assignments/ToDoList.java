


package ucf.assignments;
import java.util.ArrayList;

public class ToDoList
{
    //Private string variable for title
    //Private List<Item> for items in list


    //constructor
    public ToDoList(String title)
    {
        //set this title to the given function parameter
    }

    public void editTitle(String title)
    {
        //updates this title to the new title of the function parameter
    }

    public void addItem(Item item)
    {
        //gets a new created Item object
        //add that Item object (function parameter) to list of items
    }

    public void removeItem(Item item)
    {
        //finds the item in list
        //deletes item from the list
    }

    public String getTitle()
    {
        //Returns the title value of the list
        return null; //setting null for now
    }

    public ArrayList<Item> getAllItems(ToDoList list)
    {
        //declare a new arraylist of Item objects - allItems
        //loop through ToDoList 'list' function parameter and inside that loop through 'items'
        //add each item to the allItems arraylist
        //return the ArrayList<Item> 'allItems'
        return null; //setting null for now
    }

    public ArrayList<Item> inCompleteItems(ToDoList list)
    {
        //declare a new arraylist of Item objects - inCompleteItems
        //loop through ToDoList 'list' function parameter and inside that loop through 'items'
        //check whether that item is finished by calling Item's checkFinished() method
        //if they are not, add that item to inComplete items
        //return the inCompleteItems
        return null; //setting null for now
    }

    public ArrayList<Item> completeItems(ToDoList list)
    {
        //declare a new arraylist of Item objects - completeItems
        //loop through arraylist 'list' function parameter and inside that loop through 'items'
        //check whether that item is finished by calling Item's checkFinished() method
        //if they are, add that item to completeItems
        //return the completeItems
        return null; //setting null for now
    }
}
