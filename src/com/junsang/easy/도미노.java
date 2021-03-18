package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.17
 * @DESC       : 도미노
 * @see        : https://www.acmicpc.net/problem/2921
 */
public class 도미노 {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;


    public static void main(String[] args) throws Exception {

        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        int sum = 0;
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++) {
                if (i <= j) {
                    sum += (i+j);
                }
            }
        }
        result.append(sum);
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }


    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}