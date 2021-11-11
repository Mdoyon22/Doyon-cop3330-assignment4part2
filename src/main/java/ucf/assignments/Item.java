/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
//Package for date object
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import java.time.LocalDate;


public class Item
{
    //Private string variable for description
    //SimpleStringProperty -> easier to output for javafx
    private SimpleStringProperty description;

    //Private String variable for date
    private LocalDate dueDate;

    //Private JavaFX CheckBox variable for whether the item is finished
    //instead of a boolean use checkbox for each item, easier for javafx
    private CheckBox complete;

    //Constructor
    public Item(String description, LocalDate dueDate)
    {
        //Takes in parameters for description and date
        //Assigns them accordingly
        this.description = new SimpleStringProperty(description);
        this.dueDate = dueDate;

        //Also initializes a new checkbox for an item
        this.complete = new CheckBox();
    }


    public LocalDate getDueDate()
    {
        //Returns the Date object
        return dueDate;
    }


    public String getDescription()
    {
        //Returns the description of an Item object
        //.get() returns String, converting from SimpleStringProperty
        return description.get();
    }


    public CheckBox getComplete()
    {
        //Returns the checkbox complete
        return complete;
    }


    public void setDescription(String description)
    {
        //Updates this description to the new description from parameter
        //Converts from String to SimpleStringProperty
        this.description = new SimpleStringProperty(description);
    }


    public void setDueDate(LocalDate dueDate)
    {
        //Updates this date to the new date from parameter
        this.dueDate = dueDate;
    }


    public void setComplete(CheckBox complete)
    {
        //Sets the complete to the checkbox parameter
        this.complete = complete;
    }
}
