package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.08
 * @DESC       : 행복한지 슬픈지
 * @see        : https://www.acmicpc.net/problem/10769
 */
public class 행복한지_슬픈지 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String str = "";
    static String[] happy = {":", "-", ")"};
    static String[] sad  = {":", "-", "("};
    static int happyPoint = 0;
    static int sadPoint = 0;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        String[] strSplit = str.split("");
        for(int i=0; i<strSplit.length; i++) {

            if (happy[0].equals(strSplit[i])) {
                if (happy[1].equals(strSplit[i+1]) && happy[2].equals(strSplit[i+2])) {
                    happyPoint++;
                }
            }

            if (sad[0].equals(strSplit[i])) {
                if (sad[1].equals(strSplit[i+1]) && sad[2].equals(strSplit[i+2])) {
                    sadPoint++;
                }
            }
        }

        if (happyPoint == 0 && sadPoint == 0) {
            result.append("none");
        } else if (happyPoint > sadPoint) {
            result.append("happy");
        } else if (happyPoint < sadPoint) {
            result.append("sad ");
        } else if (happyPoint == sadPoint) {
            result.append("unsure ");
        }
    }

    public static void input() throws Exception {
        str = br.readLine();
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}