package com.sparta.sortmanager.view;

import java.util.Scanner;
import java.util.Arrays;

public class DisplayManager {

    private final String PROMPT_SORTER_TYPES = "Which sort types would you like? Type a comma-separated list of one or more of the following: \"bubble\", \"merge\", (binary search) \"tree\" (or type \"q\" to quit)";
    private final String PROMPT_RANDOM_CHOICE = "Would you prefer a random array (\"r\") or to input an array (\"i\")? (or type \"q\" to quit)";
    private final String PROMPT_INTEGERS = "Please input your array in the form of a comma-separated list of integers. (or type \"q\" to quit)";
    private final String PROMPT_SIZE = "Please choose the size of the random array. (or type \"q\" to quit)";
    private final String PROMPT_INVALID_INPUT = "Invalid input. Please try again.";
    private final String PROMPT_EXIT_CONFIRM = "Are you sure you want to quit? (y/n)";

    private final String QUIT_INPUT = "q";
    private final String ARRAY_STRING_DELIMITER = ",";

    private final String[] VALID_SORTER_TYPES = {"bubble", "merge", "tree"};

    private String promptInput(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.println(prompt);
        return s.nextLine();
    }

    private void exit() {
        if(promptInput(PROMPT_EXIT_CONFIRM).equals("y")) System.exit(0); // else
        return;
    }


    public String getSorterType(String sorterType) {
        if(Arrays.stream(VALID_SORTER_TYPES).anyMatch(sorterType::equalsIgnoreCase)) {
            return sorterType;
        } else {
            System.err.println(PROMPT_INVALID_INPUT);
            return null;
        }
    }

    public String[] getSorterTypes() {
        String userInput;
        String[] sorterTypes;

        do {
            userInput = promptInput(PROMPT_SORTER_TYPES).replace(" ", "");
            if(userInput.equals(QUIT_INPUT)) {
                exit();
            } else {
                sorterTypes = iterateSorterTypes(userInput);
                if(sorterTypes != null) return sorterTypes; // else try again
            }
        } while(true);
    }

    public String[] iterateSorterTypes(String userInput) {
        String[] userListString;
        String[] sorterTypes;
        String currentString;
        userListString = userInput.split(ARRAY_STRING_DELIMITER);
        sorterTypes = new String[userListString.length];
        for(int i = 0; i < userListString.length; i++) {
            currentString = getSorterType(userListString[i]);
            if(currentString == null || Arrays.stream(sorterTypes).anyMatch(currentString::equals)) {
                System.err.println(PROMPT_INVALID_INPUT);
                return null;
            } // else
            sorterTypes[i] = currentString;
        }
        return sorterTypes;
    }

    public boolean getIsRandom() {
        String isRandomChoice;
        do {
            isRandomChoice = promptInput(PROMPT_RANDOM_CHOICE).toLowerCase();
            switch (isRandomChoice) {
                case "r" -> { return true; }
                case "i" -> { return false; }
                case QUIT_INPUT -> { exit(); break; }
                default -> { System.err.println(PROMPT_INVALID_INPUT); }
            }
        } while(true);
    }

    public int[] getUserArray() {
        String[] userArrayString;
        int[] userArray;
        boolean loop;
        int currentInt;
        do {
            loop = false;
            userArrayString = promptInput(PROMPT_INTEGERS).replace(" ", "").split(ARRAY_STRING_DELIMITER);
            userArray = new int[userArrayString.length];
            if(userArrayString[0].equals(QUIT_INPUT)) exit();
            else {
                for (int i = 0; i < userArray.length; i++) {
                    try {
                        currentInt = Integer.parseInt(userArrayString[i]);
                    } catch (NumberFormatException e) {
                        System.err.println(PROMPT_INVALID_INPUT);
                        loop = true;
                        break;
                    }
                    userArray[i] = currentInt;
                }
            }
        } while(loop);
        return userArray;
    }

    public int getArraySize() {
        String sizeString;
        do {
            sizeString = promptInput(PROMPT_SIZE);
            if(sizeString.equals(QUIT_INPUT)) exit(); // else
            try {
                return Integer.parseInt(sizeString);
            } catch (NumberFormatException e) {
                System.err.println(PROMPT_INVALID_INPUT);
            }
        } while(true);
    }

    public void printResults(int[] initArr, int[] sortedArr, String sorterType) {
        System.out.printf("Initial array: %s", Arrays.toString(initArr));                System.out.println();
        System.out.printf("Sorted using %s sort: %s", sorterType, Arrays.toString(sortedArr));  System.out.println();
    }

}
