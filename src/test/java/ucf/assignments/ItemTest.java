/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ItemTest
{
    //Testing item's edit

    //Test whether an item's description edit works
    @Test
    void editDescription_Test()
    {
        //Create new temp Item object
        //Call editDescription() method with String 'newDes' as parameter

        //To check whether the description has been updated
        //Call getDescription() on the temp Item object

        //assert whether the return value from getDescription() is same as 'newDes'
    }


    //Test whether an item's date edit works
    @Test
    void editDate_Test()
    {
        //Create new temp Item object
        //Call editDate() method with String 'newDate' as parameter

        //To check whether the date has been updated
        //Convert the 'newDate' String into a Date object - 'newDateObj'
        //Since the return from getDate() is Date object, call getDate() on the temp Item object

        //assert whether the return value from getDate() is same as 'newDateObj'
    }


    //Test whether an item's finished works
    @Test
    void editFinished_Test_True()
    {
        //Create a new temp Item object
        //Call editFinished() method with true as parameter

        //To check whether the finished has been updated
        //Call checkFinished() on the temp Item object

        //assertTrue the return value from checkFinished()
    }


    //Test whether an item's not finished works
    @Test
    void editFinished_Test_False()
    {
        //Create new temp Item object
        //Call editFinished() method with false as parameter

        //To check whether the finished has been updated
        //Call checkFinished() on the temp Item object

        //assertFalse the return value from checkFinished()
    }
}