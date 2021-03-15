package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.15
 * @DESC       : 문자열 폭발
 * @see        : https://www.acmicpc.net/problem/9935
 */
public class 문자열_폭발 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String oriStr;
    static String expStr;
    static boolean repeatYn = true;

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<oriStr.length(); i++) {
            stack.push(oriStr.charAt(i));

            if (stack.size() < expStr.length()) continue;

            boolean flag = true;
            for (int j = 0; j < expStr.length(); j++) {
                // 제거해야할 문자와 같지 않다면, break
                if (stack.get(stack.size() - expStr.length() + j) != expStr.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int j = 0; j < expStr.length(); j++) {
                    stack.pop();
                }
            }

        }


        for(int i=0; i<stack.size(); i++) {
            result.append(stack.get(i));
        }
    }



    public static void input() throws Exception {
        oriStr = br.readLine();
        expStr = br.readLine();
    }

    public static void output() throws Exception {

        if (result.length() == 0)
            result.append("FRULA");

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}