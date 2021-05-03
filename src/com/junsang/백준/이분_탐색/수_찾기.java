package com.junsang.백준.이분_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.05.03
 * @DESC       : 수 찾기
 * @see        : https://www.acmicpc.net/problem/1920
 */
public class 수_찾기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        //== Input
        int arrCnt = Integer.parseInt(br.readLine());
        int[] arr = new int[arrCnt];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arrCnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int compCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] compArr = new int[compCnt];
        for(int i=0; i<compCnt; i++) {
            compArr[i] = Integer.parseInt(st.nextToken());
        }

        //== Logic
        Arrays.sort(arr);
        for(int i=0; i<compCnt; i++) {


            if (binarySearch(compArr[i], arr))
                System.out.println(1);
            else
                System.out.println(0);
        }

    }

    /**
     * @param num 탐색해야하는 수
     * @param arr 배열 리스트
     */
    private static boolean binarySearch(int num, int[] arr) {
        int mid = 0;
        int left = 0;
        int right = arr.length - 1;

        while(right >= left) {
            mid = (right+left) / 2;

            // 수를 찾았을 경우
            if (num == arr[mid]) {
                return true;
            }

            // 수를 못찾을 경우
            else if (num < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}