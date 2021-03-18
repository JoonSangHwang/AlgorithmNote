package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.18
 * @DESC       : 돌 게임
 * @see        : https://www.acmicpc.net/problem/9655
 */
public class 돌_게임 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    //===

    static int N;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        String winner = "";
        if (N % 2 == 0)
            winner = "CY";
        else
            winner = "SK";


        result.append(winner);
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
