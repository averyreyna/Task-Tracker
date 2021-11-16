/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class ApplicationTest
{
    // this tests the add and remove functionalities of the to-do list application
    @Test
    void addRemoveTest()
    {
        // create list of type ToDoList and an ArrayList named tasks
        ToDoList list = new ToDoList();
        ArrayList<ToDoItems> tasks = new ArrayList<>();

        // set the ToDoItems with a description and dueDate
        ToDoItems task1 = new ToDoItems("task1", "2021-11-03");
        ToDoItems task2 = new ToDoItems("task2", "2021-11-25");
        ToDoItems task3 = new ToDoItems("task3", "2021-11-25");

        // use the .addTask() method to add tasks to the list
        list.addTask(task1);
        list.addTask(task2);
        list.addTask(task3);

        // use the .addTask() method to add tasks to the tasks
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

        // use the .deleteTask() method to delete a task from both list and tasks
        list.deleteTask(task1);
        tasks.remove(task1);

        // assert true if lists and tasks have the same number of tasks
        assertEquals(list.tasks, tasks);
    }

    @Test
    void editTaskTest()
    {
        ToDoList list = new ToDoList();

        ToDoItems task1 = new ToDoItems("task", "2021-11-25");
        ToDoItems task2 = new ToDoItems("task", "2021-11-25");

        list.addTask(task1);
        list.addTask(task2);

        task2.editDesc("description should be different");
        task2.editdueDate("2021-11-26");
        task2.editIsComplete();

        assertTrue(task1.getdueDate() != task2.getdueDate() && task1.getDesc() != task2.getDesc() && task1.getisComplete() != task2.getisComplete());
    }

    @Test
    void clearListTest()
    {
        ToDoList list = new ToDoList();

        ToDoItems task1 = new ToDoItems("task1", "2021-11-02");
        ToDoItems task2 = new ToDoItems("task2", "2021-11-12");

        list.addTask(task1);
        list.addTask(task2);

        list.clear();

        assertTrue(list.tasks.isEmpty());
    }

    @Test
    void getTasksTest()
    {
        ToDoList list = new ToDoList();
        ToDoItems task1 = new ToDoItems("task1", "2021-11-04");
        ToDoItems task2 = new ToDoItems("task2", "2021-11-08");

        list.addTask(task1);
        list.addTask(task2);
        task2.editIsComplete();

        assertTrue(list.getTasks() != list.getComplete() && list.getTasks() != list.getIncomplete() && list.getComplete()!= list.getIncomplete());
    }

    @Test
    void saveLoadTest()
    {
        ToDoList savedList = new ToDoList();

        ToDoItems task1 = new ToDoItems("task1", "2021-11-03");
        ToDoItems task2 = new ToDoItems("task2", "2021-11-06");

        savedList.addTask(task1);
        savedList.addTask(task2);

        new File("./listTests").mkdirs();

        String name = "test";
        File file = new File("./listTests/"+name+".csv");

        savedList.saveList(file);

        ToDoList loadedList;
        loadedList = savedList.loadList(file);

        assertFalse(loadedList.tasks.isEmpty());
    }
}