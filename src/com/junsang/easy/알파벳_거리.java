package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.08
 * @DESC       : 알파벳_거리
 * @see        : https://www.acmicpc.net/problem/5218
 */
public class 알파벳_거리 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N = 0;
    static String[][] arr;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {

        for(int i=0; i<N; i++) {
            int arrSize = arr[i][0].length();           result.append("Distances: ");
            for(int j=0; j<arrSize; j++) {
                char chrA = arr[i][0].charAt(j);
                char chrB = arr[i][1].charAt(j);
                int numA = (int) chrA;
                int numB = (int) chrB;

                if (numB >= numA) {
                    result.append(numB-numA + " ");
                } else {
                    result.append((numB+26)-numA + " ");
                }

                if (j+1 == arrSize) {
                    result.append("\n");
                }
            }
        }

    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new String[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
