package com.schlueter.perftest.bubblesort;

import com.schlueter.perftest.ReturnType;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    
    public static List<ReturnType> sort(int[] array) {
        List<ReturnType> returnTypes = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    //swap elements
                    temp = (int) array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }

        ReturnType returnType = new ReturnType();
        returnType.name = "BubbleSort";
        returnType.arrayLength = (long) array.length;
        returnType.time = System.currentTimeMillis() - startTime;
        returnTypes.add(returnType);
        return returnTypes;
    }
}
