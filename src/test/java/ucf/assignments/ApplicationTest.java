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

public class ApplicationTest
{
    @Test
    public void main() throws IOException
    {
        HashMap<String, ApplicationController.ItemDetails> testOuterMap = new HashMap<>();

        String itemTitleTest = "Test Item Title";
        String itemDescriptionTest = "Test Item Description";
        String dueDateTest = "2021-11-16";
        String completionStatusTest = "0";
        String itemTitleTestTwo = "Test Item Title #2";
        String itemDescriptionTestTwo = "Test Item Description";
        String dueDateTestTwo = "2021-11-16";
        String testItemCompletionFlag2 = "0";

        makeItemFunction(testOuterMap, itemTitleTest, itemDescriptionTest, dueDateTest, completionStatusTest);
        assertEquals(itemTitleTest, testOuterMap.keySet().toArray()[0]);
        editItemFunction(testOuterMap, itemTitleTest, itemTitleTestTwo, itemDescriptionTestTwo, dueDateTestTwo, testItemCompletionFlag2);
        assertEquals(itemTitleTestTwo, testOuterMap.keySet().toArray()[0]);

        assertEquals(itemDescriptionTestTwo, testOuterMap.get(itemTitleTestTwo).getItemDescription());
        assertEquals(dueDateTestTwo, testOuterMap.get(itemTitleTestTwo).getDueDate());
        assertEquals(testItemCompletionFlag2, testOuterMap.get(itemTitleTestTwo).getCompletionFlag());
        Application.removeItem(testOuterMap, itemTitleTestTwo);
        assertEquals(0, testOuterMap.size());

        Application.makeItemFunction(testOuterMap, itemTitleTest, itemDescriptionTest, dueDateTest, completionStatusTest);
        Application.makeItemFunction(testOuterMap, itemTitleTestTwo, itemDescriptionTestTwo, dueDateTestTwo, testItemCompletionFlag2);

        assertTrue(Application.printAllItemsOfList(testOuterMap).contains(itemTitleTest));
        assertTrue(Application.printAllItemsOfList(testOuterMap).contains(itemTitleTestTwo));
        assertTrue(Application.printAllCompletedItemsOfList(testOuterMap).contains(itemTitleTestTwo));
        assertTrue(Application.printAllUncompletedItemsOfList(testOuterMap).contains(itemTitleTest));
        Application.removeAllItemsFunction(testOuterMap);

        assertEquals(0, testOuterMap.size());

        Application.makeItemFunction(testOuterMap,itemTitleTest, itemDescriptionTest, dueDateTest, completionStatusTest);
        Application.makeItemFunction(testOuterMap, itemTitleTestTwo, itemDescriptionTestTwo, dueDateTestTwo, testItemCompletionFlag2);

        File saveListFile = new File("src/main/java/ucf/assignments/saveListFile.txt");

        Application.saveListFunction(testOuterMap);

        assertTrue(saveListFile.exists());
        assertTrue(saveListFile.length() != 0);

        Application.loadListFunction(testOuterMap);

        assertTrue(testOuterMap.size() != 0);
    }
}