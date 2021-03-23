package com.junsang.백준.자료구조_스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.22
 * @DESC       : 좋은 단어
 * @see        : https://www.acmicpc.net/problem/3986
 */
public class 좋은_단어 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    //===

    static int N;               // 입력 받아야 할 문자 수
    static String[] words;      // 입력 받은 문자들
    static int goodWordCnt = 0; // 좋은 단어 개수


    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            String[] word = words[i].split("");

            for(int j=0; j<word.length; j++) {
                // 스택이 비어 있다면, PUSH
                if (stack.empty()) {
                    stack.push(word[j]);
                    continue;
                }

                // 스택의 TOP 이랑 비교하여, PUSH/POP 결정
                if (word[j].equals(stack.peek()))
                    stack.pop();
                else
                    stack.push(word[j]);
            }


            // 스택에 남은 문자가 없다면, 좋은 단어로 판정
            if (stack.size() == 0)
                goodWordCnt++;


            stack.clear();
        }

        // 출력
        result.append(goodWordCnt);
    }


    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for(int i=0; i<N; i++) {
            words[i] = br.readLine();
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}