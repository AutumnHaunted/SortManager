package com.sparta.sortmanagertest;

import com.sparta.sortmanager.BubbleSorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class SorterTest {

    @DisplayName("Test that the bubble sort correctly sorts the given array in various cases")
    @ParameterizedTest
    @CsvSource
    private static void bubbleSortTest(int[] arr) {
        int[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, new BubbleSorter().sort(arr));
    }

}
