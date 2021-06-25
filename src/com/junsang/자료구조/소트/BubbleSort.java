package com.junsang.자료구조.소트;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] examArr = new int[] {1, 3, 56, 8, 9, 3, 2, 1, 23, 11, 10};

        System.out.println(Arrays.toString(examArr));
        bubbleSort(examArr);
        System.out.println(Arrays.toString(examArr));
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j= 1 ; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j])
                    swap(arr, j-1, j);
            }
        }
    }

    private static void swap(int[] tArr, int t1, int t2) {
        int temp = tArr[t1];
        tArr[t1] = tArr[t2];
        tArr[t2] = temp;
    }
}
