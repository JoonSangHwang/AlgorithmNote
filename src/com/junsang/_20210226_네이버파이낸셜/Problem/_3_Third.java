package com.junsang._20210226_네이버파이낸셜.Problem;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.26
 * @DESC       : 네이버파이낸셜 경력직 채용 3번 문제 풀이
 */
public class _3_Third {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    ;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{3, 2, -2, 5, -3}));
        System.out.println(solution(new int[]{1, 1, 2, -1, 2, -1}));
        System.out.println(solution(new int[]{1, 2, 3, -4}));
    }

    static public int solution(int[] A) {

        int positiveCnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                positiveCnt++;
            }
        }
        int negativeCnt = A.length - positiveCnt;


        int answer = 0;
        int mMax = 0;
        int[] positive = new int[positiveCnt];
        int[] negative = new int[negativeCnt];
        int pCnt = 0;
        int nCnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                positive[pCnt] = A[i];
                pCnt++;
            } else {
                negative[nCnt] = A[i];
                nCnt++;
            }
        }

        for (int i = 0; i < positiveCnt; i++) {
            for (int j = 0; j < negativeCnt; j++) {
                if (positive[i] == Math.abs(negative[j])) {
                    if (mMax < positive[i]) {
                        mMax = positive[i];
                    }
                }
            }
        }

        return mMax;
    }
}