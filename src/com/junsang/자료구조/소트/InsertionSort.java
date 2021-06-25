package com.junsang.자료구조.소트;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] examArr = new int[] {1, 3, 56, 8, 9, 3, 2, 1, 23, 11, 10};

        System.out.println(Arrays.toString(examArr));
        insertionSort(examArr);
        System.out.println(Arrays.toString(examArr));
    }

    private static void insertionSort(int[] arr) {
        for(int index = 1 ; index < arr.length ; index++){
            int target = arr[index];
            int prev = index - 1;

            while (prev >= 0 && arr[prev] > target) {
                arr[prev+1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = target;
        }
    }


    private static void swap(int[] tArr, int t1, int t2) {
        int temp = tArr[t1];
        tArr[t1] = tArr[t2];
        tArr[t2] = temp;
    }
}