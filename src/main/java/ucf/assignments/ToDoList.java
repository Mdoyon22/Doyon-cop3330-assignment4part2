/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import javafx.scene.control.CheckBox;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ToDoList
{
    //Private List<Item> for items in list
    private ArrayList<Item> items;

    //Default constructor
    public ToDoList()
    {
        //Initializes ArrayList when object is created
        items = new ArrayList<>();
    }

    public ArrayList<Item> getAllItems()
    {
        //Returns all the items in the ArrayList
        return items;
    }

    public ArrayList<Item> inCompleteItems()
    {
        //Initialize a new ArrayList for incomplete items
        ArrayList<Item> incompleteItems = new ArrayList<>();

        //Loop through items and find if incomplete
        //Use by getComplete() in Item.java, which returns and item's checkbox
        //Use checkbox isSelected() method, which returns a boolean
        for (Item i : items)
        {
            CheckBox temp = i.getComplete();

            //If the checkbox is off
            if (!temp.isSelected())
            {
                //Add into the incomplete items ArrayList
                incompleteItems.add(i);
            }
        }

        return incompleteItems;
    }


    public ArrayList<Item> completeItems()
    {
        //Initialize a new ArrayList for complete items
        ArrayList<Item> completeItems = new ArrayList<>();

        //Loop through items and find if complete
        //Use by getComplete() in Item.java, which returns an item's CheckBox
        //Use CheckBox isSelected() method, which returns a boolean
        for (Item i : items)
        {
            CheckBox temp = i.getComplete();

            //If the Checkbox is on
            if (temp.isSelected())
            {
                //Add into the incomplete items ArrayList
                completeItems.add(i);
            }
        }

        return completeItems;
    }


    public void addItem(Item item)
    {
        //Get a new created Item object
        //Add that Item object (parameter) to list of items
        items.add(item);
    }


    public void removeItem(Item item)
    {
        //Removes item from list
        items.remove(item);
    }


    public void clearAll()
    {
        //Use ArrayList method clear to remove all items
        items.clear();
    }


    public void updateItem(Item item, String newDescription, LocalDate newDueDate)
    {
        //Get the item object, and its new description and date object
        //Using item's setter methods, assign them
        item.setDescription(newDescription);
        item.setDueDate(newDueDate);
    }


    public Boolean itemExists(String findItem)
    {
        //Check if the items exist already using description
        //Run through the loop and find if the item exists
        for (Item i : items)
        {
            if (i.getDescription().equals(findItem))
            {
                //Item found returns true
                return true;
            }
        }
        //Returns false if item is not found
        return false;
    }


    public void save(File fileDirectory)
    {
        //Gets a file or file directory
        //Saves this ArrayList of items into file as CSV format
        try
        {
            //Use a bufferedwriter to write into the file
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileDirectory));

            //Write the headings
            bw.write("Description");
            bw.write(",");
            bw.write("DueDate");
            bw.write(",");
            bw.write("Completed");
            bw.write("\n");

            //Loop through every time and write into file
            for (Item item : items)
            {
                //Console message
                System.out.print("Adding item to file: ");
                System.out.print(item.getDescription() + ",");

                //Write description
                bw.write(item.getDescription());
                bw.write(",");

                //Convert date object into string using toString()
                String date = item.getDueDate().toString();

                //Console message
                System.out.print(date + "\n");

                //Write date
                bw.write(date);
                bw.write(",");


                //Check if CheckBox is checked or unchecked
                if (item.getComplete().isSelected())
                {
                    //If checked, write "yes" into file
                    bw.write("yes\n");
                }

                else
                {
                    //Write no into file if unchecked
                    bw.write("no\n");
                }
            }

            bw.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<Item> load(File fileDirectory)
    {
        //Creates and initializes new ArrayList fileItems
        //Gets a file or file directory, .csv file
        //Reads the file in CSV format
        //Assigns new item into the fileItems
        ArrayList<Item> fileItems = new ArrayList<>();

        try
        {
            //Use a bufferedreader for reading the CSV file
            BufferedReader br = new BufferedReader(new FileReader(fileDirectory));

            String line = "";
            //Ignores the headings
            line = br.readLine();

            while ((line = br.readLine()) != null)
            {
                //To separate values
                String[] values = line.split(",");

                //Console message
                System.out.println(values);

                //Convert from string to date
                Item item = new Item(values[0], convertToDate(values[1]));

                //Create a temp CheckBox to add to an item
                CheckBox complete = new CheckBox();

                //Check if the text is "yes" or "no" and set box accordingly
                if (values[2].equalsIgnoreCase("yes"))
                {
                    complete.setSelected(true);
                }

                else
                {
                    complete.setSelected(false);
                }

                //Add the checkbox to the item
                item.setComplete(complete);

                //Add into fileItems
                fileItems.add(item);

            }
            //Add into this list items
            items = fileItems;
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return fileItems;
    }


    //Helps convert string to formatted date object
    private LocalDate convertToDate(String date)
    {
        //Format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        //Console message
        System.out.println(localDate);

        return localDate;
    }
}
