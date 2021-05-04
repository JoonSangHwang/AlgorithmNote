package com.junsang.백준.이분_탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.05.04
 * @DESC       : 숫자 카드 2
 * @see        : https://www.acmicpc.net/problem/10816
 */
public class 숫자_카드_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] numCard;
    static int numCardCnt;
    static int[] compNumCard;
    static int compNumCardCnt;

    public static void main(String[] args) throws IOException {

        problemInput();


        Arrays.sort(numCard);
        for(int i=0; i<compNumCardCnt; i++) {
            int up = upperBound(compNumCard[i], numCard);
            int lo = lowerBound(compNumCard[i], numCard);
            sb.append(up - lo + " ");
        }


        problemOutput();
    }


    private static int upperBound(int searchNum, int[] numCard) {

        int right = numCard.length - 1;
        int left = 0;

        while(right > left) {
            int mid = (right+left) / 2;

            if (numCard[mid] > searchNum) right = mid;
            else left = mid + 1;
        }

        if (numCard[right] == searchNum) right++;
        return right;
    }

    private static int lowerBound(int searchNum, int[] numCard) {

        int right = numCard.length - 1;
        int left = 0;

        while(right > left) {
            int mid = (right+left) / 2;

            if (numCard[mid] >= searchNum) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    private static void problemInput() throws IOException {
        numCardCnt = Integer.parseInt(br.readLine());
        numCard = new int[numCardCnt];
        st = new StringTokenizer(br.readLine());
        for(int initCnt=0; initCnt<numCardCnt; initCnt++) {
            numCard[initCnt] = Integer.parseInt(st.nextToken());
        }

        compNumCardCnt = Integer.parseInt(br.readLine());
        compNumCard = new int[compNumCardCnt];
        st = new StringTokenizer(br.readLine());
        for(int initCnt=0; initCnt<compNumCardCnt; initCnt++) {
            compNumCard[initCnt] = Integer.parseInt(st.nextToken());
        }
    }

    private static void problemOutput() throws IOException {
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}