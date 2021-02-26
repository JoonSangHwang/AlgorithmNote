package com.junsang._20210226_네이버파이낸셜.Problem;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.26
 * @DESC       : 네이버파이낸셜 경력직 채용 2번 문제 풀이
 */
public class _2_Second {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{0, 1, 5, 9, 9}, 5));
    }

    static public int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] >= X) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
}
