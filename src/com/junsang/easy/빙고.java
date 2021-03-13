package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.13
 * @DESC       : 빙고
 * @see        : https://www.acmicpc.net/problem/2578
 */
public class 빙고 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int[][] bingo = new int[5][5];
    static int[] order = new int[25];
    static int gameRound = 25;

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {

        // 현재 라운드
        int curRound = 0;

        // 게임 라운드 (25라운드)
        while (gameRound-- > 0) {
            boolean flag = false;

            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if (bingo[i][j] == order[curRound]) {
                        bingo[i][j] += 100;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }

            // 현재라운드 +1
            ++curRound;

            // 최소 15번째 라운드부터 검증
            if (curRound >= 12) {
                int bingoCnt = 0;
                bingoCnt += rowBingoCnt();          // 행 빙고 수
                bingoCnt += columnBingoCnt();       // 열 빙고 수
                bingoCnt += diagonal1BingoCnt();    // 사선1 빙고 수
                bingoCnt += diagonal2BingoCnt();    // 사선2 빙고 수

                // 빙고가 3개 이상이라면, 종료
                if (bingoCnt >= 3) {
                    result.append(curRound);
                    return;
                }
            }
        }
    }

    public static int rowBingoCnt() {
        int bingoCnt = 0;

        for(int i=0; i<5; i++) {
            int combo = 0;
            for(int j=0; j<5; j++) {
                if (bingo[i][j] > 100) {
                    combo += 1;
                }
            }
            if (combo == 5)
                bingoCnt +=1;
        }

        return bingoCnt;
    }

    public static int columnBingoCnt() {
        int bingoCnt = 0;

        for(int i=0; i<5; i++) {
            int combo = 0;
            for(int j=0; j<5; j++) {
                if (bingo[j][i] > 100) {
                    combo += 1;
                }
            }
            if (combo == 5)
                bingoCnt +=1;
        }

        return bingoCnt;
    }

    public static int diagonal1BingoCnt() {
        int bingoCnt = 0;

        int combo = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if (i == j && bingo[j][i] > 100) {
                    combo += 1;
                }
            }
            if (combo == 5)
                bingoCnt +=1;
        }

        return bingoCnt;
    }

    public static int diagonal2BingoCnt() {
        int bingoCnt = 0;

        int combo = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if (i+j == 4 && bingo[j][i] > 100) {
                    combo += 1;
                }
            }
            if (combo == 5)
                bingoCnt +=1;
        }

        return bingoCnt;
    }


    public static void input() throws Exception {
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                order[cnt] = Integer.parseInt(st.nextToken());
                cnt++;
            }
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}