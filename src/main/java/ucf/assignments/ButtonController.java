/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import javafx.fxml.FXML;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ButtonController implements Initializable
{
    ToDoList list = new ToDoList();
    static ObservableList<ToDoItems> display = FXCollections.observableArrayList();

    // this the date picker field that the user will use to pick a due date for their item
    @FXML
    private DatePicker dateField;

    // these are the table columns that will hold the different features of a to-do list
    // it contains the description, due date, and completion status of an item
    @FXML
    private TableView<ToDoItems> listTable;

    @FXML
    private TableColumn<ToDoItems, String> desc;

    @FXML
    private TableColumn<ToDoItems, String> dueDate;

    @FXML
    private TableColumn<ToDoItems, Boolean> isComplete;

    // these are the text fields that the user will input all their item information into
    // contains text files for the description and the load/save file names
    @FXML
    private TextField descField;

    @FXML
    private TextField loadFileField;

    @FXML
    private TextField saveFileField;

    // these are the buttons that the user will press within the UI to achieve certain actions
    // they are defined in this file and referenced in the dashboard fxml
    @FXML
    private Button editDateButton;

    @FXML
    private Button editDescButton;

    @FXML
    private Button editPosButton;

    @FXML
    private Button incompleteButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button delItemButton;

    @FXML
    private Button addItemButton;

    @FXML
    private Button allButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button completeButton;

    // this the action event that is triggered when the add button is pressed
    @FXML
    void addAction(ActionEvent event)
    {
        // creates a new task with the initial fields and adds it to the to-do list
        ToDoItems task = new ToDoItems(descField.getText(), dateField.getValue().toString());
        list.addTask(task);

        // refreshing the to-do list table with the newly created item
        listTable.getItems().add(task);
        listTable.refresh();

        descField.setText("");
        dateField.setValue(null);
    }

    // this is the action event that clears all items from a to-do list
    @FXML
    void clearAction(ActionEvent event)
    {
        // uses the .clear() method to clear all the items in a to-do list and refreshes the table so it is blank
        list.clear();
        listTable.getItems().clear();
        listTable.refresh();
    }

    // this is the action event that displays all the items in your to-do list
    @FXML
    void displayAll(ActionEvent event)
    {
        // uses the .setItems() method to display the items then refreshes the table to display all the items in your to-do list
        display = FXCollections.observableArrayList(list.getTasks());
        listTable.setItems(display);
        listTable.refresh();
    }

    // this is the action event that displays only the completed items in your to-do list
    @FXML
    void displayComplete(ActionEvent event)
    {
        // uses the .getComplete() method to get all the completed tasks from your to-do list
        // uses the .setItems() method to display all the items in your to-do list and refreshes the to-do list
        display = FXCollections.observableArrayList(list.getComplete());
        listTable.setItems(display);
        listTable.refresh();
    }

    // this is the action event that displays only the uncompleted items in your to-do list
    @FXML
    void displayIncomplete(ActionEvent event)
    {
        // uses the .getIncomplete() method to get all the uncompleted tasks from your to-do list
        // uses the .setItems() method to display all the items in your to-do list and refreshes the to-do list
        display = FXCollections.observableArrayList(list.getIncomplete());
        listTable.setItems(display);
        listTable.refresh();
    }

    // this is the action event that allows the user to edit the due date of an item in their to-do list
    @FXML
    void editTaskDate(ActionEvent event)
    {
        // uses the .getValue().toString() method to turn the due date into a string so we can then use the .editdueDate() method to actaully edit it
        // after that, the table is refreshed so we can see the updated table
        ToDoItems current = listTable.getSelectionModel().getSelectedItem();
        String str = dateField.getValue().toString();
        current.editdueDate(str);
        listTable.refresh();
    }

    // this is the action event that allows the user to edit the description of an item in their to-do list
    @FXML
    void editTaskDesc(ActionEvent event)
    {
        // uses the .getSelectionModel().getSelectedItem() to get the item we want so we can edit it
        // uses the .editDesc() method to edit the description of an item and refreshes the table so we can see the updated table
        ToDoItems current = listTable.getSelectionModel().getSelectedItem();
        String str = descField.getText();
        current.editDesc(str);
        listTable.refresh();
    }

    @FXML
    void editTaskPos(ActionEvent event)
    {
        ToDoItems current = listTable.getSelectionModel().getSelectedItem();
        current.editIsComplete();
        listTable.refresh();
    }

    @FXML
    void loadAction(ActionEvent event)
    {
        String name = loadFileField.getText();
        File file = new File("./lists/"+name+".csv");

        display = FXCollections.observableArrayList(list.loadList(file).tasks);
        listTable.setItems(display);
        listTable.refresh();
        loadFileField.setText("");
    }

    @FXML
    void removeAction(ActionEvent event)
    {
        ToDoItems task = listTable.getSelectionModel().getSelectedItem();

        list.deleteTask(task);
        listTable.getItems().remove(task);
        listTable.refresh();
    }

    @FXML
    void saveAction(ActionEvent event)
    {
        String name = saveFileField.getText();
        File file = new File("./lists/"+name+".csv");

        list.saveList(file);
        saveFileField.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        desc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        dueDate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ToDoItems, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ToDoItems, String> p)
            {
                return p.getValue().itemDueDate;
            }
        });

        isComplete.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ToDoItems, Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<ToDoItems, Boolean> p)
            {
                return p.getValue().itemIsComplete;
            }
        });

        dateField.setDayCellFactory(picker -> new DateCell()
        {
            public void updateItem(LocalDate date, boolean empty)
            {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

        listTable.setItems(display);

        new File("./lists").mkdirs();
    }
}

