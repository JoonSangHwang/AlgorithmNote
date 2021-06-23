package com.junsang.자료구조.퀵소트;

import java.util.Arrays;

/**
 * Worst : O(n^2)
 * = Array 가 이미 정렬이 되어 있을 경우, 맨 앞 또는 맨 뒤를 element 로 잡을 경우 재귀함수의 깊이가 가장 깊어질 것
 * Average : O(n long n)
 * Best : O(n log n)
 *
 * 분할과 정복
 *
 * 범위 -> 기준 -> 비교 -> 스왑
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] examArr = new int[] {1, 3, 56, 8, 9, 3, 2, 1, 23, 11, 10};

        System.out.println(Arrays.toString(examArr));
        quickSort(examArr, 0, examArr.length - 1);
        System.out.println(Arrays.toString(examArr));
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int pivot = partition(arr, left, right);    // 피봇 선정
            quickSort(arr, left, pivot - 1);      // pivot 왼쪽 정렬
            quickSort(arr, pivot + 1, right);      // pivot 오른쪽 정렬
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int changeIdx = left -1;

        for (int cursor=left; cursor<=right-1; cursor++) {
            if (arr[cursor] <= arr[right]) {
                changeIdx++;
                swap(arr, changeIdx, cursor);
            }
        }

        swap(arr, changeIdx+1, right);
        return changeIdx+1;
    }

    private static void swap(int[] tArr, int t1, int t2) {
        int temp = tArr[t1];
        tArr[t1] = tArr[t2];
        tArr[t2] = temp;
    }
}