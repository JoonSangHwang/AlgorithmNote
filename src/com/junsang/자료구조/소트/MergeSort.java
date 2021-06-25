package com.junsang.자료구조.소트;

import java.util.Arrays;

/**
 * 분할 정복 알고리즘
 * - 모든 숫자를 다 나눈 다음에 병합하는 방식으로 정렬
 *
 * Worst : O(n log n)
 * Aver : O(n log n)
 * Best : O(n log n)
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] examArr = new int[] {1, 3, 56, 8, 9, 3, 2, 1, 23, 11, 10};

        System.out.println(Arrays.toString(examArr));
        mergeSort(examArr, 0, examArr.length - 1);
        System.out.println(Arrays.toString(examArr));
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            // (l+r) / 2
            int mid = left + (right-left) / 2;    // l 과 r 을 합쳤을때 표현 가능한 데이터 타입의 범위를 넘을것 같아 StackOverFlow 방지

            // 분할
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);

            // 정복
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int[] temp = new int[arr.length];

        while(i<=mid && j<=right) {
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i<=mid)
            temp[k++] = arr[i++];

        while(j<=right)
            temp[k++] = arr[j++];

        for(int idx=left; idx<=right; idx++)
            arr[idx] = temp[idx];
    }
}