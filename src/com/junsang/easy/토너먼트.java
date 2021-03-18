package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.17
 * @DESC       : 토너먼트
 * @see        : https://www.acmicpc.net/problem/1057
 */
public class 토너먼트 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int peopleNum;   // 인원 수
    static int jiminNum;    // 김지민 번호
    static int hansuNum;    // 임한수 번호

    public static void main(String[] args) throws Exception {

        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        int round = 0;
        while(true) {
            round++;

            jiminNum = (jiminNum+1) / 2;
            hansuNum = (hansuNum+1) / 2;

            if (jiminNum == hansuNum)
                break;
        }

        result.append(round);
    }

    public static void input() throws Exception {
        String in[] = br.readLine().split(" ");
        peopleNum = Integer.parseInt(in[0]);
        jiminNum = Integer.parseInt(in[1]);
        hansuNum = Integer.parseInt(in[2]);
    }


    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}