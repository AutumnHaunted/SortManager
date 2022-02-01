package com.sparta.sortmanager.main;

import com.sparta.sortmanager.controller.SortManager;
import com.sparta.sortmanager.view.DisplayManager;

public class Main {
    public static void main(String[] args) {
        SortManager sm = new SortManager();
        DisplayManager dm = new DisplayManager();
        String sorterType = dm.getSorterType();
        int[] initArr;
        if(dm.getIsRandom()) initArr = sm.getRandomArray(dm.getArraySize());
        else initArr = dm.getUserArray();
        int[] sortedArr = sm.performSort(initArr, sorterType);
        dm.printResults(initArr, sortedArr, sorterType);
    }
}
