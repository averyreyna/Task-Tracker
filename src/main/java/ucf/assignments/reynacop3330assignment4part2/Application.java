/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Avery Reyna
 */

package ucf.assignments.reynacop3330assignment4part2;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap = new HashMap<>();

        Scanner openAppResponseInput = new Scanner(System.in);
        System.out.println("Would you like to run the To Do List App (y/n)?");
        String openAppResponse = openAppResponseInput.next();

        while (openAppResponse.equals("y")) {

            Scanner makeListResponseInput = new Scanner(System.in);
            System.out.println("Would you like to make a new list (y/n)?");
            String makeListResponse = makeListResponseInput.next();

            while (makeListResponse.equals("y")) {
                makeListResponse = makeListFunction(outerMap, makeListResponseInput);
            }

            Scanner makeItemResponseInput = new Scanner(System.in);
            System.out.println("Would you like to make a new item (y/n)?");
            String makeItemResponse = makeItemResponseInput.next();

            while (makeItemResponse.equals("y")) {
                makeItemResponse = makeItemFunction(outerMap, makeItemResponseInput);
            }

            Scanner editListResponseInput = new Scanner(System.in);
            System.out.println("Would you like to edit a list (y/n)?");
            String editListResponse = editListResponseInput.next();

            while (editListResponse.equals("y")) {
                editListResponse = editListFunction(outerMap, editListResponseInput);
            }

            Scanner editItemResponseInput = new Scanner(System.in);
            System.out.println("Would you like to edit an item (y/n)?");
            String editItemResponse = editItemResponseInput.next();

            while (editItemResponse.equals("y")) {
                Scanner listToEditItemOfInput = new Scanner(System.in);
                System.out.println("From which of the following lists would you like to edit an item? Please input the exact name of the list.");
                for (int i = 0; i < outerMap.size(); i++) {
                    System.out.println(outerMap.keySet().toArray()[i]);
                }

                String listToEditItemOf = listToEditItemOfInput.next();

                editItemResponse = editItemFunction(outerMap, editItemResponseInput, listToEditItemOf);
            }

            Scanner removeListResponseInput = new Scanner(System.in);
            System.out.println("Would you like to remove a list (y/n)?");
            String removeListResponse = removeListResponseInput.next();

            while (removeListResponse.equals("y")) {
                Scanner typeOfListRemovalResponseInput = new Scanner(System.in);
                System.out.println("Would you like to delete one list or all lists? 1 if one list; 0 if all lists.");
                String typeOfListRemovalResponse = typeOfListRemovalResponseInput.next();

                if (typeOfListRemovalResponse.equals("1")) {
                    removeListResponse = removeListFunction(outerMap, typeOfListRemovalResponseInput);
                } else if (typeOfListRemovalResponse.equals("0")) {
                    removeListResponse = removeAllListsFunction(outerMap);
                }
            }

            Scanner removeItemResponseInput = new Scanner(System.in);
            System.out.println("Would you like to remove an item from a list (y/n)?");
            String removeItemResponse = removeItemResponseInput.next();

            while (removeItemResponse.equals("y")) {
                Scanner typeOfItemRemovalResponseInput = new Scanner(System.in);
                System.out.println("Would you like to delete one list or all lists? 1 if one list; 0 if all lists.");
                String typeOfListRemovalResponse = typeOfItemRemovalResponseInput.next();

                if (typeOfListRemovalResponse.equals("1")) {
                    Scanner listToRemoveItemFromInput = new Scanner(System.in);
                    System.out.println("From which of the following lists would you like to remove an item? Please input the exact name of the list.");
                    for (int i = 0; i < outerMap.size(); i++) {
                        System.out.println(outerMap.keySet().toArray()[i]);
                    }

                    String listToRemoveItemFrom = listToRemoveItemFromInput.next();

                    removeItemResponse = removeItemFunction(outerMap, typeOfItemRemovalResponseInput, listToRemoveItemFrom);
                } else if (typeOfListRemovalResponse.equals("0")) {
                    Scanner listToRemoveItemsFromInput = new Scanner(System.in);
                    System.out.println("From which of the following lists would you like to remove items? Please input the exact name of the list.");
                    for (int i = 0; i < outerMap.size(); i++) {
                        System.out.println(outerMap.keySet().toArray()[i]);
                    }

                    String listToRemoveItemsFrom = listToRemoveItemsFromInput.next();

                    removeItemResponse = removeAllItemsFunction(outerMap, listToRemoveItemsFrom);
                }
            }

            Scanner displayResponseInput = new Scanner(System.in);
            System.out.println("Would you like to display any of the lists and or items (y/n)?");
            String displayResponse = displayResponseInput.next();

            while (displayResponse.equals("y")) {
                Scanner specificDisplayResponseInput = new Scanner(System.in);
                System.out.println("""
                        Would you like to display (1, 2, 3, 4, or 5)?
                        1. All Lists and Items
                        2. All Lists Only
                        3. All Items of a Specific List
                        4. All Completed Items of a Specific List
                        5. All Uncompleted Items of a Specific List
                        """);

                String specificDisplayResponse = specificDisplayResponseInput.next();

                switch (specificDisplayResponse) {
                    case "1":
                        printAllListsAndItems(outerMap);
                        break;
                    case "2":
                        printAllLists(outerMap);
                        break;
                    case "3":
                        Scanner listToPrintItemsFromInput = new Scanner(System.in);
                        System.out.println("Which of the following lists would you like to display items from? Please input the exact name of the list.");
                        for (int i = 0; i < outerMap.size(); i++) {
                            System.out.println(outerMap.keySet().toArray()[i]);
                        }

                        String listToPrintItemsFrom = listToPrintItemsFromInput.next();

                        printAllItemsOfList(outerMap, listToPrintItemsFrom);
                        break;
                    case "4":
                        listToPrintItemsFromInput = new Scanner(System.in);
                        System.out.println("Which of the following lists would you like to display items from? Please input the exact name of the list.");
                        for (int i = 0; i < outerMap.size(); i++) {
                            System.out.println(outerMap.keySet().toArray()[i]);
                        }

                        listToPrintItemsFrom = listToPrintItemsFromInput.next();

                        printAllCompletedItemsOfList(outerMap, listToPrintItemsFrom);
                        break;
                    case "5":
                        listToPrintItemsFromInput = new Scanner(System.in);
                        System.out.println("Which of the following lists would you like to display items from? Please input the exact name of the list.");
                        for (int i = 0; i < outerMap.size(); i++) {
                            System.out.println(outerMap.keySet().toArray()[i]);
                        }

                        listToPrintItemsFrom = listToPrintItemsFromInput.next();

                        printAllUncompletedItemsOfList(outerMap, listToPrintItemsFrom);
                        break;
                }

                System.out.println("Would you like to continue printing lists and or items (y/n)?");
                displayResponse = displayResponseInput.next();
            }

            Scanner saveListResponseInput = new Scanner(System.in);
            System.out.println("Would you like to save a list to an external file (y/n)?");
            String saveListResponse = saveListResponseInput.next();

            while (saveListResponse.equals("y")) {
                Scanner listToSaveInput = new Scanner(System.in);
                System.out.println("Which of the following lists would you like to save? Please input the exact name of the list.");
                for (int i = 0; i < outerMap.size(); i++) {
                    System.out.println(outerMap.keySet().toArray()[i]);
                }

                String listToSave = listToSaveInput.next();

                saveListResponse = saveListFunction(outerMap, listToSaveInput, listToSave);
            }

            Scanner loadListResponseInput = new Scanner(System.in);
            System.out.println("Would you like to load a list from an external file (y/n)?");
            String loadListResponse = loadListResponseInput.next();

            while (loadListResponse.equals("y")) {
                File loadListFile = new File("src/main/java/ucf/assignments/saveListFile.txt");
                BufferedReader loadListFileReader = new BufferedReader(new FileReader(loadListFile));

                Scanner listToLoadInput = new Scanner(System.in);
                System.out.println("Which of the following lists would you like to load? Please input the exact name of the list.");
                for (int i = 0; i < loadListFile.length(); i++) { //would need to be changed to the list read from the external file
                    String currentLine = loadListFileReader.readLine();
                    if (currentLine.contains("L")) {
                        String currentListTitle = currentLine.replace("List: ", "");
                        System.out.println(currentListTitle);
                    }
                }

                String listToLoad = listToLoadInput.next();

                loadListResponse = loadListFunction(outerMap, listToLoadInput, listToLoad);
            }

            System.out.println("Would you like to continue running the To Do List App (y/n)?");
            openAppResponse = openAppResponseInput.next();
        }

    }

    public static String makeListFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner makeListResponseInput) {

        Scanner listNameInput = new Scanner(System.in);
        System.out.println("What do you want to name your new list?");
        String listName = listNameInput.next();

        HashMap<String, ApplicationController.ItemDetails> innerMap = new HashMap<>();
        outerMap.put(listName, innerMap);

        System.out.println("Would you like to make another list (y/n)?");

        return makeListResponseInput.next();
    }

    public static String makeItemFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner makeItemResponseInput) {
        Scanner listForNewItemInput = new Scanner(System.in);
        System.out.println("For which of the following lists would you like to add this item into? Please input the exact name of the list.");
        for (int i = 0; i < outerMap.size(); i++) {
            System.out.println(outerMap.keySet().toArray()[i]);
        }

        String listForNewItem = listForNewItemInput.next();

        Scanner itemTitleInput = new Scanner(System.in);
        System.out.println("What would you like to name your new item?");
        String itemTitle = itemTitleInput.next();

        Scanner itemDescInput = new Scanner(System.in);
        System.out.println("What is the description for your new item?");
        String itemDesc = itemDescInput.nextLine();

        int descLength = itemDesc.length();

        while (descLength > 256) {
            System.out.println("Your description goes over the 256 character limit. Please input a shorter description.");
            itemDesc = itemDescInput.nextLine();
            descLength = itemDesc.length();
        }

        Scanner itemDeadlineInput = new Scanner(System.in);
        System.out.println("What is the deadline for your new item? Please input it as the following format: YYYY-MM-DD.");
        String itemDeadline = itemDeadlineInput.next();

        Scanner itemCompletionStatusInput = new Scanner(System.in);
        System.out.println("What is the completion status of your new item? 1 for completed; 0 for not completed.");
        String itemCompletionStatus = itemCompletionStatusInput.next();

        HashMap<String, ApplicationController.ItemDetails> innerMap = new HashMap<>();
        ApplicationController.ItemDetails itemStorage = new ApplicationController.ItemDetails();

        itemStorage.setTitle(itemTitle);
        itemStorage.setItemDescription(itemDesc);
        itemStorage.setDueDate(itemDeadline);
        itemStorage.setCompletionFlag(itemCompletionStatus);

        innerMap.put(itemTitle, itemStorage);
        outerMap.put(listForNewItem, innerMap);

        System.out.println("Would you like to make another item (y/n)?");

        return makeItemResponseInput.next();
    }

    public static String editListFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner editListResponseInput) {
        Scanner listToEditInput = new Scanner(System.in);
        System.out.println("For which of the following lists would you like to rename? Please input the exact name of the list.");
        for (int i = 0; i < outerMap.size(); i++) {
            System.out.println(outerMap.keySet().toArray()[i]);
        }

        String listToEdit = listToEditInput.next();

        Scanner newListTitleInput = new Scanner(System.in);
        System.out.println("What do you want the new name of the list to be?");
        String newListTitle = newListTitleInput.next();

        outerMap.put(newListTitle, outerMap.remove(listToEdit));

        System.out.print("Would you like to edit another list (y/n)?");

        return editListResponseInput.next();
    }

    public static String editItemFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner editItemResponseInput, String listToEditItemOf) {
        Scanner itemToEditInput = new Scanner(System.in);
        System.out.println("For which of the following item(s) would you like to edit? Please input the exact name of the item.");
        for (int i = 0; i < outerMap.get(listToEditItemOf).size(); i++) {
            String currentItem = (String) outerMap.get(listToEditItemOf).keySet().toArray()[i];
            System.out.println(outerMap.get(listToEditItemOf).get(currentItem).getTitle());
        }

        String itemToEdit = itemToEditInput.next();

        Scanner changeItemTitleResponseInput = new Scanner(System.in);
        System.out.println("Would you like to change the name of the item (y/n)?");
        String changeItemTitleResponse = changeItemTitleResponseInput.next();

        if (changeItemTitleResponse.equals("y")) {
            Scanner newItemTitleInput = new Scanner(System.in);
            System.out.println("What do you want the new name of the item to be?");
            String newItemTitle = newItemTitleInput.next();
            outerMap.get(listToEditItemOf).get(itemToEdit).setTitle(newItemTitle);
        }

        Scanner changeItemDescResponseInput = new Scanner(System.in);
        System.out.println("Would you like to change the description of the item (y/n)?");
        String changeItemDescResponse = changeItemDescResponseInput.next();

        if (changeItemDescResponse.equals("y")) {
            Scanner newItemDescInput = new Scanner(System.in);
            System.out.println("What do you want the new description of the item to be?");
            String newItemDesc = newItemDescInput.nextLine();

            int descLength = newItemDesc.length();

            while (descLength > 256) {
                System.out.println("Your description goes over the 256 character limit. Please input a shorter description.");
                newItemDesc = newItemDescInput.nextLine();
                descLength = newItemDesc.length();
            }

            outerMap.get(listToEditItemOf).get(itemToEdit).setItemDescription(newItemDesc);
        }

        Scanner changeItemDeadlineResponseInput = new Scanner(System.in);
        System.out.println("Would you like to change the deadline of the item (y/n)?");
        String changeItemDeadlineResponse = changeItemDeadlineResponseInput.next();

        if (changeItemDeadlineResponse.equals("y")) {
            Scanner newItemDeadlineInput = new Scanner(System.in);
            System.out.println("What do you want the new deadline of the item to be? Please input it as the following format: YYYY-MM-DD.");
            String newItemDeadline = newItemDeadlineInput.next();
            outerMap.get(listToEditItemOf).get(itemToEdit).setTitle(newItemDeadline);
        }

        Scanner changeItemCompletionStatusResponseInput = new Scanner(System.in);
        System.out.println("Would you like to change the deadline of the item (y/n)?");
        String changeItemCompletionStatusResponse = changeItemCompletionStatusResponseInput.next();

        if (changeItemCompletionStatusResponse.equals("y")) {
            if (outerMap.get(listToEditItemOf).get(itemToEdit).getTitle().equals("0")) {
                outerMap.get(listToEditItemOf).get(itemToEdit).setTitle("1");
            } else {
                outerMap.get(listToEditItemOf).get(itemToEdit).setCompletionFlag("0");
            }
        }

        System.out.println("Would you like to edit another item (y/n)?");

        return editItemResponseInput.next();
    }

    public static String removeListFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner typeOfListRemovalResponseInput) {
        Scanner listToRemoveInput = new Scanner(System.in);
        System.out.println("For which of the following lists would you like to remove? Please input the exact name of the list.");
        for (int i = 0; i < outerMap.size(); i++) {
            System.out.println(outerMap.keySet().toArray()[i]);
        }

        String listToRemove = listToRemoveInput.next();
        outerMap.remove(listToRemove);

        System.out.println("Would you like to remove another list (y/n)?");

        return typeOfListRemovalResponseInput.next();
    }

    public static String removeAllListsFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap) {
        for (int i = 0; i < outerMap.size(); i++) {
            String currentList = (String) outerMap.keySet().toArray()[i];
            outerMap.remove(currentList);
        }

        return "n";
    }

    public static String removeItemFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner typeOfItemRemovalResponseInput, String listToRemoveItemFrom) {
        Scanner itemToEditInput = new Scanner(System.in);
        System.out.println("For which of the following item(s) would you like to remove? Please input the exact name of the item.");
        for (int i = 0; i < outerMap.get(listToRemoveItemFrom).size(); i++) {
            String currentItem = (String) outerMap.get(listToRemoveItemFrom).keySet().toArray()[i];

            System.out.println(outerMap.get(listToRemoveItemFrom).get(currentItem).getTitle());
        }

        String itemToRemove = itemToEditInput.next();
        outerMap.get(listToRemoveItemFrom).remove(itemToRemove);

        System.out.println("Would you like to remove another item (y/n)?");

        return typeOfItemRemovalResponseInput.next();
    }

    public static String removeAllItemsFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, String listToRemoveItemsFrom) {
        for (int i = 0; i < outerMap.get(listToRemoveItemsFrom).size(); i++) {
            String currentItem = (String) outerMap.get(listToRemoveItemsFrom).keySet().toArray()[i];
            outerMap.get(listToRemoveItemsFrom).remove(currentItem);
        }

        return "n";
    }

    public static void printAllListsAndItems(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap) {
        for (int i = 0; i < outerMap.size(); i++) {
            String currentList = (String) outerMap.keySet().toArray()[i];
            System.out.println(currentList + " has a inner hashmap with a size of " + outerMap.get(currentList).keySet().size());

            for (int j = 0; j < outerMap.get(currentList).keySet().size(); j++) {
                String currentItem = (String) outerMap.get(currentList).keySet().toArray()[j];

                String currentItemTitle = outerMap.get(currentList).get(currentItem).getTitle();
                System.out.println(currentItemTitle);

                String currentItemDescription = outerMap.get(currentList).get(currentItem).getItemDescription();
                System.out.println(currentItemDescription);

                String currentItemDueDate = outerMap.get(currentList).get(currentItem).getDueDate();
                System.out.println(currentItemDueDate);

                String currentItemCompletionStatus = outerMap.get(currentList).get(currentItem).getCompletionFlag();
                System.out.println(currentItemCompletionStatus);
            }
        }
    }

    public static void printAllLists(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap) {
        for (int i = 0; i < outerMap.size(); i++) {
            String currentList = (String) outerMap.keySet().toArray()[i];
            System.out.println(currentList);
        }
    }

    public static void printAllItemsOfList(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, String listToPrintItemsFrom) {
        for (int i = 0; i < outerMap.get(listToPrintItemsFrom).size(); i++) {
            String currentItem = (String) outerMap.get(listToPrintItemsFrom).keySet().toArray()[i];
            System.out.println(currentItem);
        }
    }

    public static void printAllCompletedItemsOfList(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, String listToPrintItemsFrom) {
        for (int i = 0; i < outerMap.get(listToPrintItemsFrom).size(); i++) {
            String currentItem = (String) outerMap.get(listToPrintItemsFrom).keySet().toArray()[i];

            if (outerMap.get(listToPrintItemsFrom).get(currentItem).getCompletionFlag().equals("1")) {
                System.out.println(currentItem);
            }
        }
    }

    public static void printAllUncompletedItemsOfList(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, String listToPrintItemsFrom) {
        for (int i = 0; i < outerMap.get(listToPrintItemsFrom).size(); i++) {
            String currentItem = (String) outerMap.get(listToPrintItemsFrom).keySet().toArray()[i];

            if (outerMap.get(listToPrintItemsFrom).get(currentItem).getCompletionFlag().equals("0")) {
                System.out.println(currentItem);
            }
        }
    }

    public static String saveListFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner listToSaveInput, String listToSave) throws IOException {
        File saveListFile = new File("src/main/java/ucf/assignments/saveListFile.txt");
        boolean saveListFileCreated = saveListFile.createNewFile();
        FileWriter saveListFileOutput = new FileWriter(saveListFile);

        if (outerMap.size() != 0) {
            if (saveListFileCreated) {
                if (saveListFile.exists()) {
                    saveListFileOutput.write("List: " + listToSave);
                    for (int i = 0; i < outerMap.get(listToSave).size(); i++) {
                        String currentItem = (String) outerMap.get(listToSave).keySet().toArray()[i];

                        String currentItemTitle = outerMap.get(listToSave).get(currentItem).getTitle();
                        saveListFileOutput.write("\nItem: " + currentItemTitle);

                        String currentItemDesc = outerMap.get(listToSave).get(currentItem).getItemDescription();
                        saveListFileOutput.write(", " + currentItemDesc);

                        String currentItemDeadline = outerMap.get(listToSave).get(currentItem).getDueDate();
                        saveListFileOutput.write(", " + currentItemDeadline);

                        String currentItemCompletionFlag = outerMap.get(listToSave).get(currentItem).getCompletionFlag();
                        saveListFileOutput.write(", " + currentItemCompletionFlag + "\n");
                    }
                }

                saveListFileOutput.write("\n");
            }

            saveListFileOutput.close();

            System.out.println("Would you like to save another list (y/n)?");
        } else {
            System.out.println("There are no lists available to save.");
        }

        return listToSaveInput.next();
    }

    public static String loadListFunction(HashMap<String, HashMap<String, ApplicationController.ItemDetails>> outerMap, Scanner listToLoadInput, String listToLoad) throws IOException {
        File loadListFile = new File("src/main/java/ucf/assignments/saveListFile.txt");
        BufferedReader loadListFileReader = new BufferedReader(new FileReader(loadListFile));

        if (loadListFileReader.readLine() != null) {
            for (int i = 0; i < loadListFile.length(); i++) {
                String currentLine = loadListFileReader.readLine();
                if (currentLine.contains(listToLoad)) {
                    HashMap<String, ApplicationController.ItemDetails> innerMap = new HashMap<>();
                    outerMap.put(listToLoad, innerMap);

                    String itemDetails = loadListFileReader.readLine();
                    itemDetails = itemDetails.replace("Item: ", "");
                    String[] itemDetailsSplit = itemDetails.split(", ");

                    ApplicationController.ItemDetails itemStorage = new ApplicationController.ItemDetails();

                    itemStorage.setTitle(itemDetailsSplit[0]);
                    itemStorage.setItemDescription(itemDetailsSplit[1]);
                    itemStorage.setDueDate(itemDetailsSplit[2]);
                    itemStorage.setCompletionFlag(itemDetailsSplit[3]);

                    innerMap.put(itemDetailsSplit[0], itemStorage);
                    outerMap.put(listToLoad, innerMap);
                }
            }

            System.out.println("Would you like to load another list (y/n)?");
        } else {
            System.out.println("There are no lists available to save.");
        }

        return listToLoadInput.next();
    }
}
