package com.junsang.백준.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.24
 * @DESC       : 수 정렬하기
 * @see        : https://www.acmicpc.net/problem/2750
 */
public class 수_정렬하기 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        Arrays.sort(arr);

        for(int i=0; i<N; i++) {
            result.append(arr[i]+"\n");
        }
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
