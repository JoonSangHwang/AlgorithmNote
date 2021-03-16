package com.junsang.백준.유클리드호제법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.16
 * @DESC       : 분수 합
 * @see        : https://www.acmicpc.net/problem/1735
 */
public class 분수_합 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int denominatorA;    // 분모 A
    static int numeratorA;      // 분자 A
    static int denominatorB;    // 분모 B
    static int numeratorB;      // 분자 B


    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        int a = denominatorA * denominatorB;
        int b = (numeratorA * denominatorB) + (denominatorA * numeratorB);

        // 유클리드 호제법 (최대 공약수)
        int gcd = GCD(a, b);

        // 답
        result.append(b/gcd + " " + a/gcd);
    }

    public static int GCD(int a, int b){
        if(b == 0) return a;
        else return GCD(b, a % b);
    }



    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        numeratorA = Integer.parseInt(st.nextToken());
        denominatorA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numeratorB = Integer.parseInt(st.nextToken());
        denominatorB = Integer.parseInt(st.nextToken());
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}