package com.schlueter.perftest.bubblesort;

import com.schlueter.perftest.ReturnType;
import com.schlueter.perftest.bubblesort.BubbleSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BubbleSortTest {

    int listLength = 100_00;

    @Test
    public void testSortOneList() {
        List<int[]> arrayList = new ArrayList<>();
        int[] array = generateRandomArray((int) listLength);

        List<ReturnType> type = BubbleSort.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1]);
        }
    }

    @Test
    public void testSortHundredsOfLists() {
        List<int[]> arrayList = new ArrayList<>();
        long averageTime = 0;
        for (int i = 0; i < 100; i++) {
            arrayList.add(generateRandomArray((int) listLength));
        }
        for (int[] array : arrayList) {
            List<ReturnType> type = BubbleSort.sort(array);
            for (int i = 0; i < array.length - 1; i++) {
                assertTrue(array[i] <= array[i + 1]);
            }
            for (ReturnType returnType : type) {
                averageTime += returnType.time;
            }
        }
        System.out.println("Average time: " + averageTime / 100);
    }

    private int[] generateRandomArray(int l) {
        int[] array = new int[l];
        for (int i = 0; i < l; i++) {
            array[i] = (int) (Math.random() * l);
        }
        return array;
    }

}
