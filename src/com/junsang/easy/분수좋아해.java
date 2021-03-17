package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.17
 * @DESC       : 분수좋아해?
 * @see        : https://www.acmicpc.net/problem/10474
 */
public class 분수좋아해 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int denominator;    // 분모
    static int numerator;      // 분자

    public static void main(String[] args) throws Exception {

        while(true) {
            st = new StringTokenizer(br.readLine());
            numerator = Integer.parseInt(st.nextToken());
            denominator = Integer.parseInt(st.nextToken());

            if (numerator == 0 && denominator == 0)
                break;
            else
                solution(numerator, denominator);
        }


        output();
    }

    public static void solution(int numerator, int denominator) throws Exception {
        int a = numerator / denominator;
        int b = numerator - (denominator * a);

        result.append(a + " " + b + " / " + denominator + "\n");
    }


    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}