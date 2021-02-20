package com.junsang.백준.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.20
 * @DESC       : 체스판 다시 칠하기
 * @see        : https://www.acmicpc.net/problem/1018
 */
public class 체스판_다시_칠하기 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N = 0;
    static int M = 0;
    static String[] line;

    public static void main(String[] args) throws Exception {

        in();

        solution();

        ot();
    }

    public static void solution() {
        int boardCnt = 64;      // 지민이가 다시 칠해야 하는 최초 정사각형 개수, 64개

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                int curCnt = minSearch(line, i, j);
//                System.out.println("i = " + i + "    ||||    j = " + j + "    ||||    boardCnt = " + boardCnt + "    ||||    curCnt = " + curCnt);
                if (boardCnt > curCnt) {
                    boardCnt = curCnt;
                }
            }
        }

        result.append(boardCnt);
    }

    public static int minSearch(String[] line, int x, int y) {
        String[] case1 = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};
        String[] case2 = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};

        int case1_cnt = 0;
        int case2_cnt = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (line[i].charAt(j) != case1[i-x].charAt(j-y)) {
                    case1_cnt++;
                }
                if (line[i].charAt(j) != case2[i-x].charAt(j-y)) {
                    case2_cnt++;
                }
            }
        }

        if (case1_cnt > case2_cnt)
            return case2_cnt;
        else
            return case1_cnt;

    }


    public static void in() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        line = new String[N];
        for (int i = 0; i<N; i++) {
            line[i] = br.readLine();
        }
    }

    public static void ot() throws Exception {

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
