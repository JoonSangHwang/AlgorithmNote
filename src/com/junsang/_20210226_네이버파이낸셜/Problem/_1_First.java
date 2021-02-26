package com.junsang._20210226_네이버파이낸셜.Problem;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.26
 * @DESC       : 네이버파이낸셜 경력직 채용 1번 문제 풀이
 */
public class _1_First {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static String[] S;

    public static void main(String[] args) throws Exception {

        S = new String[]{"abc", "bca", "dbe"};
        System.out.println(solution(S));

        S = new String[]{"zzzz", "ferz", "zdsr", "fgtd"};
        System.out.println(solution(S));

        S = new String[]{"gr", "sd", "rg"};
        System.out.println(solution(S));

        S = new String[]{"bdafg", "ceagi"};
        System.out.println(solution(S));
    }

    static public int[] solution(String[] S) {

        int[] answer = new int[3];

        for(int i=0; i<S.length; i++) {
            for(int j=i+1; j<S.length; j++) {

                String[] str1 = S[i].split("");
                String[] str2 = S[j].split("");


                for(int k1=0; k1<str1.length; k1++) {
                    for(int k2=0; k2<str2.length; k2++) {
                        if (k1 == k2) {
                            if (str1[k1].equals(str2[k2])) {
                                answer[0] = i;
                                answer[1] = j;
                                answer[2] = k1;
                                return answer;
                            }
                        }
                    }
                }
            }
        }
        Math.abs(1);
        Integer[] emptyArr = {};
        answer = Arrays.stream(emptyArr).mapToInt(i -> i).toArray();
        return answer;
    }
}