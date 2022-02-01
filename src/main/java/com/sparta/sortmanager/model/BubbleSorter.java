package com.sparta.sortmanager.model;

public class BubbleSorter implements Sorter {

    /*
     * Performs a bubble sort on the given array;
     * i.e. swaps incorrectly ordered adjacent elements
     * until there are none to swap.
     */
    public int[] sort(int[] arr) {
        while(!Sorter.isSorted(arr)) {
            arr = pass(arr);
        }
        return arr;
    }

    /*
     * Performs one pass of the bubble sort.
     */
    private int[] pass(int[] arr) {
        int hold;
        for(int i = 0; i < (arr.length - 1); i++) {
            if(arr[i] > arr[i + 1]) {
                hold = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = hold;
            }
        }
        return arr;
    }
}
