package com.junsang.백준.수학;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.18
 * @DESC       : 수 이어 쓰기 1
 * @see        : https://www.acmicpc.net/problem/1748
 */
public class 수_이어_쓰기_1 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String N = "";
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        in();

        solution();

        ot();

    }

    static public void solution() {


        int len = 10;
        int cnt = 1;
        int intN = Integer.parseInt(N);
        for(int i=1; i<=intN; i++) {
            if (i == len) {
                len *= 10;
                cnt++;
            }
            answer += cnt;
        }

        result.append(answer);

    }

    static public void in() throws IOException {
        N = br.readLine();
    }

    static public void ot() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
