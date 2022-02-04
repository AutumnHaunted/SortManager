package com.sparta.sortmanager.main;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {

    public static Logger logger = LogManager.getLogger("Sort Manager Logger");

    public static void main(String[] args) {
        SortManager sm = new SortManager();
        DisplayManager dm = new DisplayManager();
        String[] sorterTypes = dm.getSorterTypes();
        for(String sorterType : sorterTypes) {
            oneSort(sm, dm, sorterType);
        }
    }

    public static void oneSort(SortManager sm, DisplayManager dm, String sorterType) {
        logger.info("Sorter Type: " + sorterType);
        int[] initArr;
        if(dm.getIsRandom()) initArr = sm.getRandomArray(dm.getArraySize());
        else initArr = dm.getUserArray();
        logger.info("Array: " + Arrays.toString(initArr));
        int[] sortedArr = sm.performSort(Arrays.copyOf(initArr, initArr.length), sorterType);
        dm.printResults(initArr, sortedArr, sorterType);
    }
}
