/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import javafx.beans.property.SimpleBooleanProperty;
import java.util.ArrayList;
import java.io.*;

public class ToDoList
{
    ArrayList<ToDoItems> tasks;

    public ToDoList()
    {
        tasks = new ArrayList<>();
    }

    public void addTask(ToDoItems task)
    {
        tasks.add(task);
    }

    public void deleteTask(ToDoItems task)
    {
        tasks.remove(task);
    }

    public void clear()
    {
        tasks.clear();
    }

    public ArrayList<ToDoItems> getIncomplete()
    {
        ArrayList<ToDoItems> incompletes = new ArrayList<>();

        for(ToDoItems i: tasks)
        {
            if (!(i.itemIsComplete.get()))
            {
                incompletes.add(i);
            }
        }
        return incompletes;
    }

    public ArrayList<ToDoItems> getComplete()
    {
        ArrayList<ToDoItems> completes = new ArrayList<>();

        for(ToDoItems i: tasks)
        {
            if (i.itemIsComplete.get())
                completes.add(i);
        }

        return completes;
    }

    public ArrayList<ToDoItems> getTasks()
    {
        return tasks;
    }

    public void saveList(File fileDirectory)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileDirectory));
            writer.write("Description");
            writer.write(",");
            writer.write("Due Date");
            writer.write(",");
            writer.write("Completion Status");
            writer.write("\n");

            for (ToDoItems task: tasks)
            {
                writer.write(task.getDesc());
                writer.write(",");

                writer.write(task.getdueDate());
                writer.write(",");

                if(task.itemIsComplete.get())
                {
                    writer.write("complete\n");
                }
                else
                {
                    writer.write("incomplete\n");
                }
            }

            writer.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public ToDoList loadList(File fileDirectory)
    {
        ToDoList newlist = new ToDoList();
        ArrayList<ToDoItems> newtasks = new ArrayList<>();
        newlist.tasks = newtasks;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(fileDirectory));

            String line = "";
            line = reader.readLine();
            while((line = reader.readLine()) != null)
            {
                String[] str = line.split(",");

                ToDoItems task = new ToDoItems(str[0], str[1]);

                if (str[2].equals("complete"))
                {
                    task.itemIsComplete = new SimpleBooleanProperty(true);
                }
                else
                {
                    task.itemIsComplete = new SimpleBooleanProperty(false);
                }

                newtasks.add(task);
            }

            tasks = newtasks;
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return newlist;
    }
}
