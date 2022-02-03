package com.sparta.sortmanager.model;

import java.util.ArrayList;
import java.util.HashMap;

import static com.sparta.sortmanager.main.Main.logger;

public class TreeSorter implements Sorter{

    /* Converts the given array into a binary search tree,
     * before retrieving its inorder traversal, then
     * adding back the extra copies that were lost in the
     * creation of the tree.
     */
    @Override
    public int[] sort(int[] arr) {
        int[] sortedArray = toArray(new BinarySearchTree(arr).getOrderedList());
        return addCopies(arr, sortedArray);
    }

    /* Converts the given Array List of integers
     * into an array of ints.
     */
    private int[] toArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }

    /* Finds how many copies of each value was in
     * the original array and adds each of them to
     * the sorted array, before returning the result.
     */
    private int[] addCopies(int[] origArr, int[] sortedArr) {
        HashMap<Integer, Integer> copies = getCopyCount(origArr);

        int[] finalArr = new int[origArr.length];
        int copiesOfCurrentValue = 0;
        int cumulativeCopies = 0;

        for(int i = 0; i < sortedArr.length; i++) {
            finalArr[i + cumulativeCopies] = sortedArr[i];
            copiesOfCurrentValue = copies.get(sortedArr[i]);
            if(copiesOfCurrentValue > 1) {
                for(int j = 1; j < copiesOfCurrentValue; j++) {
                    cumulativeCopies++;
                    finalArr[i + cumulativeCopies] = sortedArr[i];
                }
            }
        }
        return finalArr;
    }

    /* Maps each value to the number of copies of it
     * in the given array.
     */
    private HashMap<Integer, Integer> getCopyCount(int[] arr) {
        HashMap<Integer, Integer> copies = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(copies.containsKey(arr[i])) copies.replace(arr[i], (copies.get(arr[i]) + 1));
            else copies.put(arr[i], 1);
        }
        return copies;
    }
}
