package com.junsang.백준.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.22
 * @DESC       : 단어 수학
 * @see        : https://www.acmicpc.net/problem/1339
 */
public class 단어_수학 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N = 0;
    static String[] arr;
    static int[] data = new int[26];

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {

        // 입력 받은 값의 제곱근을 구하고 알파벳 인덱스에 맞게 int[] 배열에 저장
        for(int i=0; i<N; i++) {
            for(int j=0; j<arr[i].length(); j++) {
                // 아스키 코드로 알파벳 위치를 찾음
                int index = (int) arr[i].charAt(j) - 65;

                // 해당 알파벳 위치 인덱스에 제곱근 값을 넣어줌. 자리수마다 큰 값
                data[index] += Math.pow(10, arr[i].length() -j -1);
            }
        }

        // 알파벳 인덱스 총 26 번을 탐색하며, 큰 수를 파악
        int[] order = new int[26];
        for(int i=0; i<9; i++) {
            int maxIndex = 0;
            int maxCnt = 0;
            for(int j=0; j<26; j++) {
                if (maxCnt < data[j] && order[j] == 0 && data[j] != 0) {
                    maxIndex = j;
                    maxCnt = data[j];
                }
            }
            if (maxCnt != 0) {
                order[maxIndex] = 9-i;
            }
        }

        // 알파벳의 크기와 제곱근을 곱하여, 총 덧셈
        int answer = 0;
        for(int i=0; i<26; i++) {
            if (order[i] != 0) {
                answer += order[i] * data[i];
            }
        }

        // 답
        result.append(answer);
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++) {
           arr[i] = br.readLine();
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
