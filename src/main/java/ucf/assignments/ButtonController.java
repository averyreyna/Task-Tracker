/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;
import javafx.stage.Stage;

public class ButtonController
{
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Hello!");

        // create a parent root variable that uses the .load() method to take the user to another fxml file
        // create a new Scene scene(root)

        // create a new stage variable that uses the .getSource().getScene().getWindow() to create a way for the user to see a visual cue
        // use the .setStage() method to set up the scene
        // use the .show() method to display the scene
    }

    // this creates functionality to bring the user to the "welcome back!" screen
    public void onBackToHomeClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WelcomeScreen.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    // this creates functionality to bring the user to the "edit to-do list" screen
    public void onEditListClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditToDoList.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // this creates functionality to bring the user to the "create a to-do list" screen
    @FXML
    protected void onMakeListClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateToDoList.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onDeleteItemClick(ActionEvent actionEvent)
    {
        welcomeText.setText("Delete item!");

        // create a parent root variable that uses the .load() method to take the user to another fxml file
        // create a new Scene scene(root)

        // create a new stage variable that uses the .getSource().getScene().getWindow() to create a way for the user to see a visual cue
        // use the .setStage() method to set up the scene
        // use the .show() method to display the scene
    }

    public void onViewCompletedItemsClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CompletedItems.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void onViewUncompletedItemsClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UncompletedItems.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // this creates functionality to bring the user to the "your to-do list " screen
    public void onSubmitListClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("YourToDoList.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // for these next four onActions commands, i don't know if they will be utilized for user functionality, but i want to present some type of idea as to what they might accomplish
    public void onSubmitItemClick(ActionEvent actionEvent)
    {
        welcomeText.setText("Submit to-do list item!");

        // create a parent root variable that uses the .load() method to take the user to another fxml file
        // create a new Scene scene(root)

        // create a new stage variable that uses the .getSource().getScene().getWindow() to create a way for the user to see a visual cue
        // use the .setStage() method to set up the scene
        // use the .show() method to display the scene
    }

    public void onBackToListClick(ActionEvent actionEvent)
    {
        welcomeText.setText("Go back to to-list!");

        // create a parent root variable that uses the .load() method to take the user to another fxml file
        // create a new Scene scene(root)

        // create a new stage variable that uses the .getSource().getScene().getWindow() to create a way for the user to see a visual cue
        // use the .setStage() method to set up the scene
        // use the .show() method to display the scene
    }

    public void onEditItemClick(ActionEvent actionEvent)
    {
        welcomeText.setText("Edit item!");

        // create a parent root variable that uses the .load() method to take the user to another fxml file
        // create a new Scene scene(root)

        // create a new stage variable that uses the .getSource().getScene().getWindow() to create a way for the user to see a visual cue
        // use the .setStage() method to set up the scene
        // use the .show() method to display the scene
    }

    public void onBackToItemClick(ActionEvent actionEvent)
    {
        welcomeText.setText("Go back to item!");

        // create a parent root variable that uses the .load() method to take the user to another fxml file
        // create a new Scene scene(root)

        // create a new stage variable that uses the .getSource().getScene().getWindow() to create a way for the user to see a visual cue
        // use the .setStage() method to set up the scene
        // use the .show() method to display the scene
    }

    // this creates functionality to bring the user to the "create item" screen
    public void onMakeItemClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateItem.fxml")));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}