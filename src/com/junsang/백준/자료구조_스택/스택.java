package com.junsang.백준.자료구조_스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.21
 * @DESC       : 스택
 *               - push()
 *               - pop()
 *               - empty()
 *               - peek() : top 리턴
 *               - search("") : 요소 찾기, 없으면 -1 / 있으면 index 리턴 (Top부터 1)
 * @see        : https://www.acmicpc.net/problem/10828
 */
public class 스택 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        Stack<Integer> stack = new Stack<>();
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if ("push".equals(command)) {
                int content = Integer.parseInt(st.nextToken());
                stack.push(content);
            }

            if ("top".equals(command)) {
                if (stack.empty())
                    result.append("-1\n");
                else
                    result.append(stack.peek() + "\n");
            }

            if ("size".equals(command)) {
                result.append(stack.size()+"\n");
            }

            if ("empty".equals(command)) {
                if (stack.empty())
                    result.append("1\n");
                else
                    result.append("0\n");
            }

            if ("pop".equals(command)) {
                if (stack.empty())
                    result.append("-1\n");
                else
                    result.append(stack.pop() + "\n");
            }
        }
    }



    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}