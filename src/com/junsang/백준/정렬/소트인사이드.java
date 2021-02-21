package com.junsang.백준.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.21
 * @DESC       : 소트인사이드
 * @see        : https://www.acmicpc.net/problem/1427
 */
public class 소트인사이드 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String[] N;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() {
        Arrays.sort(N, Collections.reverseOrder());

        for (int i=0; i<N.length; i++) {
            result.append(N[i]);
        }
    }

    public static void input() throws Exception {
        N = br.readLine().split("");
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
