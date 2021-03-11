package com.junsang.easy;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.11
 * @DESC       : 암호
 * @see        : https://www.acmicpc.net/problem/1718
 */
public class 암호 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String encryKeys;
    static String plainTxts;
    static char answer;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        String[] plainTxt = plainTxts.split("");
        String[] encryKey = encryKeys.split("");

        for(int i=0; i<plainTxt.length; i++) {
            if (" ".equals(plainTxt[i])) {
                result.append(" ");
                continue;
            }


            int j = i % encryKey.length;                // 인덱스
            int plainIdx = plainTxt[i].charAt(0);       // 알파벳
            int encryIdx = encryKey[j].charAt(0);       // 알파벳


            /**
             * [참고] 아스키 코드
             * - 알파벳 a 의 값 : 97
             * - 알파벳 총 개수 : 26개
             */
            if (plainIdx-encryIdx <= 0)
                answer = (char) (96 + 26 -Math.abs(plainIdx-encryIdx));
            else
                answer = (char) ((plainIdx-encryIdx) + 96);

            result.append(answer);
        }
    }

    public static void input() throws Exception {
        plainTxts = br.readLine();
        encryKeys = br.readLine();
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}