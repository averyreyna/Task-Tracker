/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ToDoItems
{
    SimpleStringProperty itemDescription;
    SimpleStringProperty itemDueDate;
    SimpleBooleanProperty itemIsComplete;

    public ToDoItems(String desc, String dueDate)
    {
        this.itemDescription = new SimpleStringProperty(desc);
        this.itemDueDate = new SimpleStringProperty(dueDate);
        this.itemIsComplete = new SimpleBooleanProperty(false);
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

    public void editIsComplete()
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
}