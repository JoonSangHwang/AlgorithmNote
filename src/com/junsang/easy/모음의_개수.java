package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.07
 * @DESC       : 모음의 개수
 * @see        : https://www.acmicpc.net/problem/10987
 */
public class 모음의_개수 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String str = "";
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        String[] strSplit = str.split("");
        for(int i=0; i<strSplit.length; i++) {
            for(int j=0; j<5; j++) {
                if (vowels[j].equals(strSplit[i])) {
                    answer++;
                }
            }
        }
        result.append(answer);
    }

    public static void input() throws Exception {
        str = br.readLine();
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
