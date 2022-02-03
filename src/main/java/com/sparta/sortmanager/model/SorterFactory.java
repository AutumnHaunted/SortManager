package com.sparta.sortmanager.model;

public class SorterFactory {
    public static Sorter getSorter(String sorterType) {
        sorterType = sorterType.toLowerCase();
        return switch(sorterType) {
            case "bubble" -> new BubbleSorter();
            case "merge" -> new MergeSorter();
            case "tree" -> new TreeSorter();
            default -> null;
        };
    }
}
