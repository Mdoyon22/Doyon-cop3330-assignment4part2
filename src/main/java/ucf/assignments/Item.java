/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
//Package for date object
import java.util.Date;

public class Item
{
    //Private string variable for description
    //Private string variable for date
    //Private boolean variable for whether the item is finished

    //Constructor
    public Item(String des, String date)
    {
        //Takes in parameters for description and date
        //Assigns them accordingly
    }

    private Date convertDate()
    {
        //Initialize new Date object
        //Converts the string data of date into that Date object (for comparing)

        //Returns converted Date object
        return null; //setting null for now
    }

    public Date getDate()
    {
        //Convert to Date object and return it
        //Returns the Date object from convertDate()
        return null; //setting null for now
    }

    public String getDescription()
    {
        //Return the description of an Item object
        return null; //setting null for now
    }

    public void editDescription(String des)
    {
        //Updates this description to the new description from parameter
    }

    public void editDate(String date)
    {
        //Updates this date to the new date from parameter
    }

    public void editFinished(Boolean Finish)
    {
        //Sets whether the item is finished or not
    }

    public Boolean checkFinished()
    {
        //Returns the boolean value of Finished (for display options)
        return false; //setting false for now
    }
}
