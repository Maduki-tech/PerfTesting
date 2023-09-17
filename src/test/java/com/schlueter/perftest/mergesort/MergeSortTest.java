package com.schlueter.perftest.mergesort;

import junit.framework.TestCase;

import java.util.List;

public class MergeSortTest extends TestCase {

    public void testMergeSort() {
        List<Long> list = List.of(1L, 2L, 3L, 4L, 5L, 6L);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(list);
    }
}