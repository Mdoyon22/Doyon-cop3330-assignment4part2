/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import javafx.event.ActionEvent;
import java.util.ArrayList;

public class Controller
{
    //Declare and initialize AllLists arraylist by calling it
    //Utilize and interpret AllLists methods according to eventhandlers

    //event handlers code


    //Save and load options
    public void saveListClicked(ActionEvent actionEvent)
    {
        //Get that list that was clicked - saveList
        //Call AllLists listExists(), if true continue, else addToDoList() to AllLists arraylist
        //Call AllLists save(saveList) method by passing the saveList parameter
    }

    public void saveAllClicked(ActionEvent actionEvent)
    {
        //Call AllLists saveAll() method
    }

    public void loadRecentClicked(ActionEvent actionEvent)
    {
        //Get the ToDoList object LoadList from calling AllLists loadRecent() method
        //display() that ToDoList object LoadList
    }

    public void loadAllClicked(ActionEvent actionEvent)
    {
        //Declare new arraylist LoadAll
        //Initialize that arraylist LoadAll with return value from calling AllLists loadAll() method
        //Pass that new arraylist into display() method
    }

    //item options
    public void addItemClicked(ActionEvent actionEvent)
    {
        //Show up the anchorPane "item_Pane"
    }

    public void saveItemClicked(ActionEvent actionEvent)
    {
        //Get the list of the saved item
        //Call AllLists's listExists(), if true continue, else addToDoList() to AllLists arraylist
        //Get the description "item_des" and date "item_date" text fields
        //Create new Item object by calling the constructor
        //Add the new Item object into the existing list
        //Call ToDoList addItem() method
    }

    public void editItemClicked(ActionEvent actionEvent)
    {
        //Get the ToDoList list and Item item objects from which button clicked
        //Call AllLists's listExists(), if true continue, else addToDoList() to AllLists arraylist
        //If description edited, call the Item object's editDescription() method
        //If date edited, call the Item's object's editDate() method
    }

    public void deleteItemClicked(ActionEvent actionEvent)
    {
        //Get the ToDoList list and Item item objects from which button clicked
        //Call AllLists's listExists(), if true continue, else addToDoList() to AllLists arraylist
        //Remove the item from that ToDoList object's items list
    }

    public void itemFinishedSelected(ActionEvent actionEvent)
    {
        //Get the Item and ToDoList object from which the finished is selected
        //Call AllLists's listExists(), if true continue, else addToDoList() to AllLists arraylist
        //Check whether it is checked or not
        //If checked mark the boolean "check" as true, else as false
        //Update that item finished by calling editFinished() with passing in the boolean "check"
    }

    public void editListClicked(ActionEvent actionEvent)
    {
        //Get the ToDoList list object from which the edit is clicked
        //Call AllLists's listExists(), if true continue, else addToDoList() to AllLists arraylist
        //Find where the list is in (using the title) from AllLists arraylist
        //If title is edited, call the ToDoList object's editTitle() by passing new title
    }

    public void deleteListClicked(ActionEvent actionEvent)
    {
        //Get the ToDoList list object from which the edit is clicked
        //Call AllLists's listExists(), if true continue, else addToDoList() to AllLists arraylist
        //Find where the list is in (using the title) from AllLists arraylist
        //Remove that list from the AllLists arraylist
    }

    public void addListClicked(ActionEvent actionEvent)
    {
        //Show up the anchor pane "todoList_Pane"
    }

    //Display options selection
    public void allDisplaySelected(ActionEvent actionEvent)
    {
        //Get the ToDoList title from 'displayToDoList' text field for display options
        //Find the ToDoList by using getTitle() and listExists() and store it in new ToDoList object - displayList
        //Check whether allDisplay is marked or not
        //If it is, call the displayItems() method with the parameter of the
        //return value from ToDoLists's getAllItems() method by passing displayList
    }

    public void completeDisplaySelected(ActionEvent actionEvent)
    {
        //Get the ToDoList title from 'displayToDoList' text field for display options
        //Find the ToDoList by using getTitle() and listExists() and store it in new ToDoList object - displayList
        //Check whether completeDisplay is marked or not
        //If it is, call the displayItems() method with the parameter of the return value from ToDoLists's completeItems() method by passing displaylist
    }

    public void incompleteDisplaySelected(ActionEvent actionEvent)
    {
        //Get the ToDoList title from 'displayToDoList' text field for display options
        //Find the ToDoList by using getTitle() and listExists() and store it in new ToDoList object - displayList
        //Check whether inCompleteDisplay is marked or not
        //If it is, call the displayItems() method with the parameter of the return value from ToDoLists's inCompleteItems() method by passing displayList
    }

    public void displayItems(ArrayList<Item> items, ToDoList list)
    {
        //Find the 'list' and clear its display
        //Loop through 'items'
        //Display them on screen with the 'list'
    }

    public void displayLists(ArrayList<ToDoList> lists)
    {
        //First call the AllLists's sort() method
        //Then loop through the parameter of all lists
        //Display them on screen
    }
}
