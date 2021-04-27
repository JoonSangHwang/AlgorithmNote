package com.junsang.백준.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.30
 * @DESC       : 창고 다각형
 * @see        : https://www.acmicpc.net/problem/2304
 */
public class 창고_다각형 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int bar = 0;
    static int rightBar = 0;
    static int leftBar = 1000;
    static int[] graph = new int[1000];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        // 그래프 이동 (방향: --->)
        for(int i=leftBar; i<=rightBar; i++) {

            // 첫 시작은 bar 초기화
            if (i == leftBar) {
                bar = graph[i];
                continue;
            }

            // 그전 bar 가 더 클 경우
            if (graph[i] < bar) {
                stack.push(i);      // 스택에 모아두기
            }
            // 현재 bar 가 더 클경우
            else {
                graphFill(bar);     // bar 값으로 그래프 채우기
                bar = graph[i];     // 현재 bar 값으로 bar 초기화
            }
        }


        stack.clear();



        // 그래프 이동 (방향: <---)
        for(int i=rightBar; i>=leftBar; i--) {

            // 첫 시작은 bar 초기화
            if (i == rightBar) {
                bar = graph[i];
                continue;
            }

            // 그전 bar 가 더 클 경우
            if (graph[i] < bar) {
                stack.push(i);      // 스택에 모아두기
            }

            // 현재 bar 가 더 클경우
            else {
                graphFill(bar);     // bar 값으로 그래프 채우기
                bar = graph[i];     // 현재 bar 값으로 bar 초기화
            }

        }
    }

    // bar 값으로 그래프 채우기
    public static void graphFill(int bar) {
        while (!stack.empty()) {
            int popValue = stack.pop();
            graph[popValue] = bar;
        }
    }



    public static void input() throws Exception {
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            if (rightBar < width)
                rightBar = width;

            if (leftBar > width)
                leftBar = width;

            graph[width] = height;
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}