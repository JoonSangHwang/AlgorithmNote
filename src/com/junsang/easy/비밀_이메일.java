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
public class 비밀_이메일 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String N;
    static String[][] answer;
    static int R, C, cnt = 0;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        int strLeng = N.length();

        for(int i=1; i<=strLeng; i++) {
            if (strLeng % i == 0) {
                int spareR = i;
                int spareC = strLeng/i;

                // 조건1: R<=C
                if (spareR > spareC)
                    continue;

                // 조건2: R*C=N
                if (spareR * spareC != strLeng)
                    continue;

                R = spareR;
                C = spareC;
            }
        }

        answer = new String[R][C];
        for(int i=0; i<C; i++) {
            for(int j=0; j<R; j++) {
                answer[j][i] = String.valueOf(N.charAt(cnt));
                cnt++;
            }
        }
    }

    public static void input() throws Exception {
        N = br.readLine();
    }

    public static void output() throws Exception {
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                result.append(answer[i][j]);
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
