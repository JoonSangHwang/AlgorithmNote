package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.09
 * @DESC       : 하얀 칸
 * @see        : https://www.acmicpc.net/problem/1100
 */
public class 하얀_칸 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String[] chessBoard = new String[8];

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {
        int answer = 0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                String curChessBoard = String.valueOf(chessBoard[i].charAt(j));

                boolean flag = false;
                if (i%2 == 0 && j%2 == 0)
                    flag = true;

                if (i%2 == 1 && j%2 == 1)
                    flag = true;

                if (flag)
                    if ("F".equals(curChessBoard))
                        answer++;
            }
        }
        result.append(answer);
    }

    public static void input() throws Exception {
        for(int i=0; i<8; i++) {
            chessBoard[i] = br.readLine();
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
