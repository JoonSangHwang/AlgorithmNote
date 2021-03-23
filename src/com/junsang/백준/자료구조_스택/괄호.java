package com.junsang.백준.자료구조_스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.22
 * @DESC       : 괄호
 * @see        : https://www.acmicpc.net/problem/9012
 */
public class 괄호 {


    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    //===

    static int T;               // 테스트케이스
    static String[] words;      // 입력 받은 문자들


    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<T; i++) {
            String[] word = words[i].split("");

            for(int j=0; j<word.length; j++) {
                // 스택이 비어 있다면, PUSH
                if (stack.empty()) {
                    stack.push(word[j]);

                    // 만약 첫 문자가 ) 라면, 더 이상 탐색할 필요 없이 NO 출력
                    if (word[j].equals(")")) break;
                    else continue;
                }

                // 스택의 TOP 이랑 비교하여, PUSH/POP 결정
                if (word[j].equals(stack.peek()))
                    stack.push(word[j]);
                else
                    stack.pop();
            }


            // 스택에 남은 문자가 없다면, VPS
            if (stack.size() == 0)
                result.append("YES\n");
            else
                result.append("NO\n");


            stack.clear();
        }
    }


    public static void input() throws Exception {
        T = Integer.parseInt(br.readLine());
        words = new String[T];
        for(int i=0; i<T; i++) {
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