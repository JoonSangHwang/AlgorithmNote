package com.junsang.백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author     : junsang Hwang
 * @Date       : 2020.10.20
 * @DESC       : 대충 더해
 * @see        : https://www.acmicpc.net/problem/8949
 */
public class 대충_더해 {

    static int MAX;
    static String[] str;
    static String answer = "";

    public static void main(String[] args) throws IOException {

        input();

        for(int i=0; i<str.length; i++) {
            int leng = str[i].split("").length;

            if (MAX < leng) {
                MAX = leng;
            }
        }


        String[] s1 = reverseStrArr(str[0].split(""));
        String[] s2 = reverseStrArr(str[1].split(""));


        for(int i=0; i<MAX; i++) {
            int total = 0;
            if (i < s1.length) {
                total += Integer.parseInt(s1[i]);
            }

            if (i < s2.length) {
                total += Integer.parseInt(s2[i]);
            }

            answer = Integer.toString(total) + answer;
        }

        output();
    }


    public static String[] reverseStrArr(String[] str) {

        String[] cloneStr = new String[str.length];
        for(int i=0; i<str.length; i++) {
            int cnt = str.length -i -1;
            cloneStr[i] = str[cnt];
        }

        return cloneStr;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split(" ");
    }

    public static void output() {
        System.out.println(answer);
    }

}