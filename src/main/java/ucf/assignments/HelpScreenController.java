/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Michael Doyon
 */


package ucf.assignments;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelpScreenController
{
    //Private instance Button for closing the window
    @FXML
    private Button closeButton;


    public void closeButtonClicked(ActionEvent actionEvent)
    {
        //Action event to close the current window when button is clicked
        //Get current stage
        Stage currentStage = (Stage) closeButton.getScene().getWindow();
        //Closes
        currentStage.close();
    }
}
