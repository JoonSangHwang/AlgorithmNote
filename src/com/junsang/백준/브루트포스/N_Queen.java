package com.junsang.백준.브루트포스;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.02
 * @DESC       : N-Queen
 * @see        : https://www.acmicpc.net/problem/9663
 */
public class N_Queen {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N = 0;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        input();

        dfs(arr, 0);
        result.append(answer);

        output();
    }

    public static void dfs(int[] arr, int cnt) {
        int arrLen = arr.length;

        // 서로 공격할 수 없게 배치 완료
        if (cnt == arrLen) {
            answer++;
        } else {
            for (int i=0; i<arrLen; i++) {
                arr[cnt] = i;
                if (isPossible(arr, cnt)) {
                    dfs(arr, cnt + 1);   // 재귀
                }
            }
        }
    }

    public static boolean isPossible(int[] arr, int cnt) {
        for (int i=0; i<cnt; i++) {

            // 같은 열인지 검증
            if (arr[i] == arr[cnt]) {
                return false;
            }

            // 대각선 \ 방향
            if ((arr[i] - arr[cnt]) == (cnt - i)) {
                return false;
            }

            // 대각선 / 방향
            if ((arr[cnt] - arr[i]) == (cnt - i)) {
                return false;
            }
        }
        return true;
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
