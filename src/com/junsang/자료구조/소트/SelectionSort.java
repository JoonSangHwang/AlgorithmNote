package com.junsang.자료구조.소트;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] examArr = new int[] {1, 3, 56, 8, 9, 3, 2, 1, 23, 11, 10};

        System.out.println(Arrays.toString(examArr));
        selectionSort(examArr);
        System.out.println(Arrays.toString(examArr));
    }

    private static void selectionSort(int[] arr) {
        int indexMin;
        for (int i = 0; i < arr.length-1; i++) {
            indexMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexMin])
                    indexMin = j;
            }

            swap(arr, indexMin, i);
        }
    }


    private static void swap(int[] tArr, int t1, int t2) {
        int temp = tArr[t1];
        tArr[t1] = tArr[t2];
        tArr[t2] = temp;
    }
}
