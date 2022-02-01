package com.sparta.sortmanager.view;

import java.util.Scanner;

public class DisplayManager {

    private final String PROMPT_SORTER_TYPE = "Which sort type would you like? \"bubble\" or \"merge\"?";
    private final String PROMPT_RANDOM_CHOICE = "Would you prefer a random array (\"r\") or to input an array (\"i\")?";
    private final String PROMPT_INTEGERS = "Please input your array in the form of a comma-separated list of integers.";
    private final String PROMPT_SIZE = "Please choose the size of the random array.";
    private final String PROMPT_INVALID_INPUT = "Invalid input. Please try again.";

    private final String ARRAY_STRING_DELIMITER = ",";

    private String promptInput(String prompt) {
        Scanner s = new Scanner(System.in);
        System.out.println(prompt);
        return s.next();
    }

    public String getSorterType() {
        String sorterType = promptInput(PROMPT_SORTER_TYPE).toLowerCase();
        switch(sorterType) {
            case "bubble", "merge" -> { return sorterType; }
            default -> {
                System.err.println(PROMPT_INVALID_INPUT);
                return getSorterType();
            }
        }
    }

    public boolean getIsRandom() {
        String isRandomChoice = promptInput(PROMPT_RANDOM_CHOICE).toLowerCase();
        switch(isRandomChoice) {
            case "r" -> { return true; }
            case "i" -> { return false; }
            default -> {
                System.err.println(PROMPT_INVALID_INPUT);
                return getIsRandom();
            }
        }
    }

    public int[] getUserArray() {
        String[] userArrayString = promptInput(PROMPT_INTEGERS).replace(" ", "").split(ARRAY_STRING_DELIMITER);
        int[] userArray = new int[userArrayString.length];
        int currentInt;
        for(int i = 0; i < userArray.length; i++) {
            try { currentInt = Integer.parseInt(userArrayString[i]); }
            catch(NumberFormatException e) {
                System.err.println(PROMPT_INVALID_INPUT);
                return getUserArray();
            }
            userArray[i] = currentInt;
        }
        return userArray;
    }

    public int getArraySize() {
        String sizeString = promptInput(PROMPT_SIZE);
        try { return Integer.parseInt(sizeString); }
        catch(NumberFormatException e) {
            System.err.println(PROMPT_INVALID_INPUT);
            return getArraySize();
        }
    }

    public void printResults(int[] initArr, int[] sortedArr, String sorterType) {
        System.out.printf("Initial array: %s", initArr);                System.out.println();
        System.out.printf("Sorted using %s: %s", sorterType, initArr);  System.out.println();
    }
}
