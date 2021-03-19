package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.19
 * @DESC       : 요세푸스 문제
 * @see        : https://www.acmicpc.net/problem/1158
 */
public class 요세푸스_문제 {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static int K;

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        int[] chk = new int[N];
        int cnt = 0, loop = 0;

        // 큐가 다 채워질 때까지 반복
        while(true) {
            cnt++;
            int round = (cnt % N == 0) ? N : cnt % N;
            if (chk[round-1] == 1)   // 이미 죽인 사람이라면 pass
                continue;


            loop++;
            if (loop == K) {
                chk[round-1] = 1;       // 죽인 번호 체크
                queue.offer(round);     // 죽인 번호 Queue 삽입
                loop = 0;               // 루프 초기화
            }


            // 큐가 다 채워졌다면 break
            if (queue.size() == chk.length) break;
        }


        // 출력 형태 만들기
        result.append("<");
        for(int i=0; i<chk.length; i++) {
            if (i == chk.length-1)
                result.append(queue.poll());
            else
                result.append(queue.poll() + ", ");
        }
        result.append(">");
    }

    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }


    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}