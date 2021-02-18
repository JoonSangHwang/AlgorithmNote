package com.junsang.백준.브루트포스;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.18
 * @DESC       : 일곱 난쟁이
 * @see        : https://www.acmicpc.net/problem/2309
 */
public class 일곱_난쟁이 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int[] arr = new int[9];


    public static void main(String[] args) throws IOException {

        in();

        // 정렬
        Arrays.sort(arr);

        // 솔루션
        solution(arr);

        ot();
    }

    public static void solution(int[] arr) {
        // 총 신장
        int totalHeight = 0;
        for (int i=0; i<9; i++) {
            totalHeight += arr[i];
        }

        for (int i=0; i<9; i++) {
            for (int j=i+1; j<9; j++) {
                // 일곱 난쟁이의 키는 100이 넘지 않는다.
                int curHeight = totalHeight - (arr[i] + arr[j]);
                if (curHeight == 100) {
                    for (int k=0; k<9; k++) {
                        if (k != i && k != j) {
                            result.append(arr[k]+"\n");
                        }
                    }
                    return ;
                }
            }
        }
    }

    static public void in() throws IOException {
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static public void ot() throws IOException {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
