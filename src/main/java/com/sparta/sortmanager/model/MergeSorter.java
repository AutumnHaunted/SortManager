package com.sparta.sortmanager.model;

import static com.sparta.sortmanager.main.Main.logger;

public class MergeSorter implements Sorter{

    /*
     * Performs a top-down merge sort,
     * i.e. splits the array into subarrays
     * until they are trivially sorted
     * before merging them recursively.
     */
    public int[] sort(int[] arr) {
        Sorter.logStart(arr);
        if(arr == null) { logger.error("Could not sort null array."); return null; }
        if(arr.length == 1) return arr;

        int[] arrA = new int[(int) Math.ceil(((double) arr.length) / 2)];
        int[] arrB = new int[(int) Math.floor(((double) arr.length) / 2)];
        logger.info("Arrays of sizes " + arrA.length + " and " + arrB.length);
        for(int i = 0; i < arr.length; i++) {
            if(i < arrA.length) arrA[i] = arr[i];
            else arrB[i - arrA.length] = arr[i];
        }
        return merge(sort(arrA), sort(arrB));
    }

    /*
     * Takes two sorted arrays and merges them
     * into a single sorted array containing the
     * union of their elements.
     */
    private int[] merge(int[] arrA, int[] arrB) {
        if(arrA == null && arrB == null) return null;
        if(arrA == null) return arrB;
        if(arrB == null) return arrA;

        int[] arrOut = new int[arrA.length + arrB.length];
        int aPos = 0, bPos = 0;

        for(int i = 0; i < arrOut.length; i++) {
            if(isNextFromA(arrA, arrB, aPos, bPos)) {
                arrOut[i] = arrA[aPos];
                aPos++;
            } else {
                arrOut[i] = arrB[bPos];
                bPos++;
            }
        }
        return arrOut;
    }

    private boolean isNextFromA(int[] arrA, int[] arrB, int aPos, int bPos) {
        if(aPos >= arrA.length) return false;
        if(bPos >= arrB.length) return true;
        return (arrA[aPos] < arrB[bPos]);
    }
}
