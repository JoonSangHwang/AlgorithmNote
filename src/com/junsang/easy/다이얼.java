package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.12
 * @DESC       : 다이얼
 * @see        : https://www.acmicpc.net/problem/5622
 */
public class 다이얼 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String str;
    static int answer;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        String[] word = str.split("");
        for(int i=0; i< word.length; i++) {
            int wordNum = word[i].charAt(0);

            // 알파벳 Z 부터 다이얼 숫자가 4개가 됨, -2 을 해줘서 공식을 유지함
            if (wordNum >= 89) {
                wordNum -= 2;
            }

            // 알파벳 S 부터 다이얼 숫자가 4개가 됨, -1 을 해줘서 공식을 유지함
            else if (wordNum >= 83) {
                wordNum -= 1;
            }

            answer += (((wordNum-65) / 3) +3);
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