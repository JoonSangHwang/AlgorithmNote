package com.junsang._20210619_요기요.Problem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _3_ {

    public static void main(String[] args) {
        solution(3, 2, new int[] {2, 1, 1, 0, 1});
    }


    public static String solution(int U, int L, int[] C) {

        int[][] a = new int[U][L];
        Arrays.fill(a, 0);

        for (int i=0; i<C.length; i++) {
            if (C[i] == 2) {

                U--;
                L--;
            }
        }

        return "";
    }
}
