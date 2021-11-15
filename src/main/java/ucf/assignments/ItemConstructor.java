/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
// import javafx.application.Application.launch;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class ToDos
{
    SimpleStringProperty itemDescription;
    SimpleStringProperty itemDueDate;
    SimpleBooleanProperty itemIsComplete;

    public ToDos(String desc, String dueDate)
    {
        this.itemDescription = new SimpleStringProperty(desc);
        this.itemDueDate = new SimpleStringProperty(dueDate);
        this.itemIsComplete = new SimpleBooleanProperty(false); // false until the editPos button is clicked
    }

    public String getDesc()
    {
        return itemDescription.get();
    }

    public String getdueDate()
    {
        return itemDueDate.get();
    }

    public Boolean getisComplete()
    {
        return itemIsComplete.get();
    }

    public void editDesc(String str)
    {
        this.itemDescription = new SimpleStringProperty(str);
    }

    public void editdueDate(String date)
    {
        this.itemDueDate = new SimpleStringProperty(date);
    }

    public void editisComplete()
    {
        if (itemIsComplete.get())
        {
            this.itemIsComplete = new SimpleBooleanProperty(false);
        }
        else
        {
            this.itemIsComplete = new SimpleBooleanProperty(true);
        }
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("WelcomeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}