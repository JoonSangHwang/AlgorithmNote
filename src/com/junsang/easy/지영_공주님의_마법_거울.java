package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.14
 * @DESC       : 지영 공주님의 마법 거울
 * @see        : https://www.acmicpc.net/problem/11586
 */
public class 지영_공주님의_마법_거울 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static String[][] mirror;
    static int mentalState;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        if (mentalState == 1) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    result.append(mirror[i][j]);
                }
                result.append("\n");
            }
        }

        else if (mentalState == 2) {
            for(int i=0; i<N; i++) {
                for(int j=N-1; j>=0; j--) {
                    result.append(mirror[i][j]);
                }
                result.append("\n");
            }
        }

        else if (mentalState == 3) {
            for(int i=N-1; i>=0; i--) {
                for(int j=0; j<N; j++) {
                    result.append(mirror[i][j]);
                }
                result.append("\n");
            }
        }
    }


    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        mirror = new String[N][N];

        for(int i=0; i<N; i++) {
            String[] strs = br.readLine().split("");
            for(int j=0; j<N; j++) {
                mirror[i][j] = strs[j];
            }
        }

        mentalState = Integer.parseInt(br.readLine());
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}