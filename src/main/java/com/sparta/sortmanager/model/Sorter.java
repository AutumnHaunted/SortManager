package com.sparta.sortmanager.model;

import static com.sparta.sortmanager.main.Main.logger;

public interface Sorter {
    int[] sort(int[] arr);

    static boolean isSorted(int[] arr) {
        if(arr == null) return true;
        for(int i = 0; i < (arr.length - 1); i++) {
            if(arr[i] > arr[i + 1]) return false;
        } // if the above condition never applies...
        return true;
    }

    static void logStart(int[] arr) { logger.info("Sorting " + java.util.Arrays.toString(arr)); }
}
