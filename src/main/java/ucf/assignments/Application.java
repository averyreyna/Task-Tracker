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
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    List list = new List();

    static ObservableList<ToDos> display = FXCollections.observableArrayList();

    @FXML
    private Button addItemButton;

    @FXML
    private Button allButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button completeButton;

    @FXML
    private DatePicker dateField;

    @FXML
    private Button delItemButton;

    @FXML
    private TableView<ToDos> listTable;

    @FXML
    private TableColumn<ToDos, String> desc;

    @FXML
    private TableColumn<ToDos, String> dueDate;

    @FXML
    private TableColumn<ToDos, Boolean> isComplete;

    @FXML
    private TextField descField;

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
    private TextField fileField;

    @FXML
    void addAction(ActionEvent event)
    {
        ToDos task = new ToDos(descField.getText(), dateField.getValue().toString());
        list.addTask(task);

        listTable.getItems().add(task);
        listTable.refresh();

        descField.setText("");
        dateField.setValue(null);
    }

    @FXML
    void clearAction(ActionEvent event)
    {
        list.clear();
        listTable.getItems().clear();
        listTable.refresh();
    }

    @FXML
    void displayAll(ActionEvent event)
    {
        display = FXCollections.observableArrayList(list.getTasks());
        listTable.setItems(display);
        listTable.refresh();
    }

    @FXML
    void displayComplete(ActionEvent event)
    {
        display = FXCollections.observableArrayList(list.getComplete());
        listTable.setItems(display);
        listTable.refresh();
    }

    @FXML
    void displayIncomplete(ActionEvent event)
    {
        display = FXCollections.observableArrayList(list.getIncomplete());
        listTable.setItems(display);
        listTable.refresh();
    }

    @FXML
    void editTaskDate(ActionEvent event)
    {
        ToDos current = listTable.getSelectionModel().getSelectedItem();
        String str = dateField.getValue().toString();
        current.editdueDate(str);
        listTable.refresh();
    }

    @FXML
    void editTaskDesc(ActionEvent event)
    {
        ToDos current = listTable.getSelectionModel().getSelectedItem();
        String str = descField.getText();
        current.editDesc(str);
        listTable.refresh();
    }

    @FXML
    void editTaskPos(ActionEvent event)
    {
        ToDos current = listTable.getSelectionModel().getSelectedItem();
        current.editisComplete();
        listTable.refresh();
    }

    @FXML
    void loadAction(ActionEvent event)
    {
        String name = fileField.getText();
        File file = new File("./lists/"+name+".csv");

        display = FXCollections.observableArrayList(list.loadList(file).tasks);
        listTable.setItems(display);
        listTable.refresh();
        fileField.setText("");
    }

    @FXML
    void removeAction(ActionEvent event)
    {
        ToDos task = listTable.getSelectionModel().getSelectedItem();

        list.deleteTask(task);
        listTable.getItems().remove(task);
        listTable.refresh();
    }

    @FXML
    void saveAction(ActionEvent event)
    {
        String name = fileField.getText();
        File file = new File("./lists/"+name+".csv");

        list.saveList(file);
        fileField.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        desc.setCellValueFactory(new PropertyValueFactory<>("desc"));

        dueDate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ToDos, String>, ObservableValue<String>>()
        {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ToDos, String> p)
            {
                // p.getValue() returns the ToDos instance for a particular TableView row
                return p.getValue().dueDate;
            }
        });

        isComplete.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ToDos, Boolean>, ObservableValue<Boolean>>()
        {
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<ToDos, Boolean> p)
            {
                return p.getValue().isComplete;
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
