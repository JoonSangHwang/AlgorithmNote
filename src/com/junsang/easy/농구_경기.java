package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.08
 * @DESC       : 농구 경기
 * @see        : https://www.acmicpc.net/problem/1159
 */
public class 농구_경기 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N = 0;
    static String[] nameList;
    static int[] firstName = new int[26];

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        for(int i=0; i<N; i++) {
            int nameIndex = nameList[i].charAt(0);
            firstName[nameIndex-97]++;
        }

        for(int i=0; i<26; i++) {
            if (firstName[i] >= 5) {
                result.append((char) (i+97));
            }
        }

        if (result.length() == 0) {
            result.append("PREDAJA");
        }
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        nameList = new String[N];
        for(int i=0; i<N; i++) {
            nameList[i] = br.readLine();
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
