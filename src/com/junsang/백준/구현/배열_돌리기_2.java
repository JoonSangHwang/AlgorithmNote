package com.junsang.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.04.21
 * @DESC       : 배열 돌리기 2
 * @see        : https://www.acmicpc.net/problem/16927
 */
public class 배열_돌리기_2 {

    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        exampleInput(N, M, arr);

        int rowStart = 0;
        int rowEnd = N;
        int colStart = 0;
        int colEnd = M;


        while(true) {

            // 시간초과를 위한 회전 수, 나머지 연산
            int rotateNum = R % ((rowEnd-rowStart)*2 + (colEnd-colStart)*2 -4);

            // 회전
            arrTurnLeft(rowStart, rowEnd, colStart, colEnd, rotateNum, arr);
//            arrTurnRight(rowStart, rowEnd, colStart, colEnd, R, arr);

            // 배열 안쪽으로 인덱스 이동
            rowStart  += 1;
            rowEnd    -= 1;
            colStart  += 1;
            colEnd    -= 1;

            // 종료 조건
            if (rowStart >= rowEnd || colStart >= colEnd) break;
        }

        exampleOutput(N, M, arr);
    }

    private static void exampleOutput(int N, int M, int[][] arr) {

        for(int row=0; row<N; row++) {
            for (int col = 0; col < M; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void arrTurnLeft(int rowStart, int rowEnd, int colStart, int colEnd, int rotateNum, int[][] arr) {
        rowEnd -= 1;
        colEnd -= 1;

        for(int curRot=0; curRot<rotateNum; curRot++) {
            int temp = arr[rowStart][colStart];

            //  00 01 02   ==>   01 02 03
            for(int i=colStart; i<colEnd; i++)
                arr[colStart][i] = arr[colStart][i+1];

            //  13 23 33 43 53 63   ==>   03 13 23 33 43 53
            for(int i=rowStart; i<rowEnd; i++)
                arr[i][colEnd] = arr[i+1][colEnd];

            //  60 61 62   ==>   61 62 63
            for(int i=colEnd; i>colStart; i--)
                arr[rowEnd][i] = arr[rowEnd][i-1];

            //  00 10 20 30 40 50   ==>   10 20 30 40 50 60
            for(int i=rowEnd; i>rowStart; i--)
                arr[i][rowStart] = arr[i-1][rowStart];

            arr[rowStart+1][colStart] = temp;
        }
    }


    private static void arrTurnRight(int rowStart, int rowEnd, int colStart, int colEnd, int rotateNum, int[][] arr) {
        rowEnd -= 1;
        colEnd -= 1;

        for(int curRot=0; curRot<rotateNum; curRot++) {
            int temp = arr[rowStart][colEnd];

            //  02 01 00   ==>   03 02 01
            for(int i=colEnd; i>rowStart; i--)
                arr[colStart][i] = arr[colStart][i-1];

            //  10 20 30 40 50 60   =>   00 10 20 30 40 50
            for(int i=rowStart; i<rowEnd; i++)
                arr[i][rowStart] = arr[i+1][rowStart];

            //  61 62 63   ==>   60 61 62
            for(int i=colStart; i<colEnd; i++)
                arr[rowEnd][i] = arr[rowEnd][i+1];

            //  53 43 33 23 13 03   =>   63 53 43 33 23 13
            for(int i=rowEnd; i>colStart; i--)
                arr[i][colEnd] = arr[i-1][colEnd];

            arr[rowStart+1][colEnd] = temp;
        }
    }

    public static void exampleInput(int N, int M, int[][] arr) throws IOException {

        for(int row=0; row<N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<M; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
