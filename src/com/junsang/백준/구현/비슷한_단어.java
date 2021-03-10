package com.junsang.백준.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.10
 * @DESC       : 비슷한 단어
 * @see        : https://www.acmicpc.net/problem/2607
 */
public class 비슷한_단어 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static String[] word;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        for(int i=1; i<N; i++) {
            String trgtStr = word[0];     int tLeng = trgtStr.length();
            String compStr = word[i];     int cLeng = compStr.length();

            // 길이 제한 (1)
            if (cLeng < tLeng-1)
                continue;

            // 길이 제한 (2)
            if (cLeng > tLeng+1)
                continue;

            // 타겟 문자열 바꾸기 (1)
            for(int j=0; j<cLeng; j++) {
                String tempB = String.valueOf(word[i].charAt(j));
                trgtStr = trgtStr.replaceFirst(tempB, "");
            }

            // 비교 문자열 바꾸기 (2)
            for(int j=0; j<tLeng; j++) {
                String tempA = String.valueOf(word[0].charAt(j));
                compStr = compStr.replaceFirst(tempA, "");
            }

            if (trgtStr.length()+compStr.length() < 3) {
                answer++;
            }
        }
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        word = new String[N];
        for(int i=0; i<N; i++) {
            word[i] = br.readLine();
        }
    }

    public static void output() throws Exception {
        result.append(answer);
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}