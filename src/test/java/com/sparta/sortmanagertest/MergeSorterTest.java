package com.sparta.sortmanagertest;

import com.sparta.sortmanager.model.SorterFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSorterTest {

    @Test
    private static void mergeSortTest(int[] arr) {
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, SorterFactory.getSorter("bubble").sort(arr));
    }

    @DisplayName("Test that the merge sort correctly sorts an array of distinct positive integers")
    @Test
    private static void distinctPosIntTest() {
        mergeSortTest(new int[] {1, 6, 4, 2, 5, 3});
    }

    @DisplayName("Test that the merge sort correctly sorts an array of distinct negative integers")
    @Test
    private static void distinctNegIntTest() {
        mergeSortTest(new int[] {-5, -4, -1, -3, -6, -2});
    }

    @DisplayName("Test that the merge sort correctly sorts an array of distinct positive and negative integers")
    @Test
    private static void distinctMixedIntTest() {
        mergeSortTest(new int[] {2, -1, 0, 3, -3, -2, 1});
    }

    @DisplayName("Test that the merge sort correctly sorts an array of integers where some elements are the same")
    @Test
    private static void sameIntTest() {
        mergeSortTest(new int[] {4, 3, 1, 4, 2, 1});
    }

    @DisplayName("Test that the merge sort correctly responds to an empty array")
    @Test
    private static void emptyTest() {
        mergeSortTest(new int[] {});
    }

    @DisplayName("Test that the merge sort correctly responds to a null")
    @Test
    private static void nullTest() {
        mergeSortTest(new int[] {1, 6, 4, 2, 5, 3});
    }

}
