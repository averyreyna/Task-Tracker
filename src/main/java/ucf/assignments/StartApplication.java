/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class StartApplication extends Application
{
    @Override
    public void start (Stage stage) throws IOException
    {
        // use FXMLLoader to load the application
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("ToDoListDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        // launch the application
        launch();
    }
}