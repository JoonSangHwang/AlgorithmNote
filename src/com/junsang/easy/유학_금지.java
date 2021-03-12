package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.12
 * @DESC       : 유학 금지
 * @see        : https://www.acmicpc.net/problem/2789
 */
public class 유학_금지 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String str;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        String[] censorship = {"C" , "A" , "M" , "B" , "R" , "I" , "D" , "G" , "E"};
        String[] word = str.split("");

        for(int i=0; i<word.length; i++) {
            boolean flag = true;
            for(int j=0; j<censorship.length; j++) {
                if (censorship[j].equals(word[i])) {
                    flag = false;
                }
            }
            if (flag) result.append(word[i]);
        }
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