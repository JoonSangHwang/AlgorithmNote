package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

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
    //===

    static String oriStr;   // 오리지널 문자
    static String expStr;   // 폭파 대상 문자

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<oriStr.length(); i++) {
            // 스택에 PUSH
            stack.push(oriStr.charAt(i));

            // 폭파문자 길이 미만은 체크 X
            if (stack.size() < expStr.length()) continue;

            // 폭파 문자 길이 만큼 반복하여, 폭파 문자가 있는지 체크
            boolean flag = true;
            for (int j = 0; j < expStr.length(); j++) {
                // 제거해야할 문자와 같지 않다면, break
                if (stack.get(stack.size() - expStr.length() + j) != expStr.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            // 제거해야할 문자와 같다면 flag 변수가 ture 유지
            if (flag) {
                // 제거 문자 POP
                for (int j = 0; j < expStr.length(); j++) {
                    stack.pop();
                }
            }

        }


        //= 출력
        for(int i=0; i<stack.size(); i++) {
            result.append(stack.get(i));
        }

        if (result.length() == 0)
            result.append("FRULA");
    }


    public static void input() throws Exception {
        oriStr = br.readLine();
        expStr = br.readLine();
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}