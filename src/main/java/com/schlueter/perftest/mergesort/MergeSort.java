package com.schlueter.perftest.mergesort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public List<Long> mergeSort(List<Long> list) {
        if (list.size() <= 1) return list;

        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        long nx = list.size() - 1;

        for (int i = 0; i < nx / 2; i++) {
            left.add(list.get(i));
        }
        for (int i = 0; nx / 2 + 1 < nx; i++) {
            right.add(list.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);


        return merge(left, right);
    }

    private List<Long> merge(List<Long> left, List<Long> right) {
        List<Long> result = new ArrayList<>();
        int nl = left.size() - 1;
        int nr = right.size() - 1;

        int il = 0;

        for (int i = 0; i < nl + nr + 1; i++) {
            if (il > nl) {
                result.add(right.get(i - il));
                continue;
            }
            if (il < i - nr) {
                result.add(left.get(il));
                il = il + i;
                continue;
            }

            if (left.get(il) <= right.get(i - il)) {
                left.add((long) il);
                continue;
            }

            result.add((long) (i - il));

        }

        return result;

    }

}
