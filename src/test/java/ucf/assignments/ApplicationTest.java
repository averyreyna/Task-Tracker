/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest
{
    @Test
    void addRemoveTest()
    {
        ToDoList list = new ToDoList();

        ArrayList<ToDo> tasks = new ArrayList<>();

        ToDo task1 = new ToDo("task1", "2021-11-03");
        ToDo task2 = new ToDo("task2", "2021-11-25");

        list.addTask(task1);
        list.addTask(task2);

        tasks.add(task1);
        tasks.add(task2);

        list.deleteTask(task2);
        tasks.remove(task2);

        assertEquals(list.tasks, tasks);
    }

    @Test
    void saveLoadTest()
    {
        ToDoList list = new ToDoList();

        ToDo task1 = new ToDo("task1", "2021-11-03");
        ToDo task2 = new ToDo("task2", "2021-11-25");

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

    @Test
    void clearListTest()
    {
        ToDoList list = new ToDoList();

        ToDo task1 = new ToDo("task1", "2021-11-03");
        ToDo task2 = new ToDo("task2", "2021-11-25");

        list.addTask(task1);
        list.addTask(task2);

        list.clear();

        assertTrue(list.tasks.isEmpty());

    }

    @Test
    void editTaskTest()
    {
        ToDoList list = new ToDoList();

        ToDo task1 = new ToDo("task", "2021-11-25");
        ToDo task2 = new ToDo("task", "2021-11-25");

        list.addTask(task1);
        list.addTask(task2);

        task2.editDesc("description should be different");
        task2.editdueDate("2021-11-26");
        task2.editisComplete();

        assertTrue(task1.getdueDate() != task2.getdueDate() && task1.getDesc() != task2.getDesc() && task1.getisComplete() != task2.getisComplete());

    }

    @Test
    void getTasksTest()
    {
        ToDoList list = new ToDoList();
        ToDo task1 = new ToDo("task1", "2021-11-03");
        ToDo task2 = new ToDo("task2", "2021-11-25");

        list.addTask(task1);
        list.addTask(task2);
        task2.editisComplete();

        assertTrue(list.getTasks() != list.getComplete() && list.getTasks() != list.getIncomplete() && list.getComplete()!= list.getIncomplete());
    }


}