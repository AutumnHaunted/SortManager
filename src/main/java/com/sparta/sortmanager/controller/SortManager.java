package com.sparta.sortmanager.controller;

import com.sparta.sortmanager.model.Sorter;
import com.sparta.sortmanager.model.SorterFactory;

import java.util.Random;

public class SortManager {
    public int[] getRandomArray(int size) {
        int[] arr = new int[size];
        Random r = new Random();
        for(int i = 0; i < size; i++) arr[i] = r.nextInt();
        return arr;
    }

    public int[] performSort(int[] initArr, String sorterType) {
        return SorterFactory.getSorter(sorterType).sort(initArr);
    }
}
