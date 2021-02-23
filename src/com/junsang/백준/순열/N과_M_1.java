package com.junsang.백준.순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.23
 * @DESC       : N과 M (1)
 * @see        : https://www.acmicpc.net/problem/15649
 */
public class N과_M_1 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static int M;
    static int[] arr;       // 순열 배열
    static int[] duplCk;    // 중복 체크

    public static void main(String[] args) throws Exception {
        input();

        dfs(0,0);

        output();
    }

    public static void dfs(int cnt,int idx) {

        // 중복 없이 M 개의 자리 수
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                result.append(arr[i] + " ");
            }
            result.append("\n");
            return;
        }

        // 1 ~ N 까지의 순열
        for (int i = 0; i < N; i++) {
            if (duplCk[i] == 0) {
                duplCk[i] = 1;         //숫자 사용
                arr[idx] = i+1;     //사용된 위치 저장
                dfs(cnt + 1, idx + 1);
                arr[idx] = 0;
                duplCk[i] = 0;//숫자 다시 리셋
            }
        }
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        duplCk = new int[N];
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}


