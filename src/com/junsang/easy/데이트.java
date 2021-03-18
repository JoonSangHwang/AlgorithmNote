package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.18
 * @DESC       : 데이트
 * @see        : https://www.acmicpc.net/problem/1296
 */
public class 데이트 {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static String myName;
    static String[] loveList;


    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        // 오민식의 LOVE 카운트
        int[] msLoveCnt = new int[4];
        String[] word = myName.split("");
        for(int i=0; i<word.length; i++) {
            if ("L".equals(word[i])) {
                msLoveCnt[0]++;
            } else if ("O".equals(word[i])) {
                msLoveCnt[1]++;
            } else if ("V".equals(word[i])) {
                msLoveCnt[2]++;
            } else if ("E".equals(word[i])) {
                msLoveCnt[3]++;
            }
        }

        // ===========================


        // 여자 멤버들 정렬 - 여러명일 때에는 알파벳이 가장 앞서는 이름을 출력하기 위함
        Arrays.sort(loveList);


        // 여성 멤버들의 LOVE 카운트
        int maxLoveCnt = -1;
        String maxName = "";
        for(int i=N-1; i>=0; i--) {    // 반대로 루프
            int[] girlLoveCnt = new int[4];
            for(int j=0; j<loveList[i].length(); j++) {
                String curAlphabet = String.valueOf(loveList[i].charAt(j));
                if ("L".equals(curAlphabet))
                    girlLoveCnt[0]++;
                else if ("O".equals(curAlphabet))
                    girlLoveCnt[1]++;
                else if ("V".equals(curAlphabet))
                    girlLoveCnt[2]++;
                else if ("E".equals(curAlphabet))
                    girlLoveCnt[3]++;
            }

            int lCnt = msLoveCnt[0] + girlLoveCnt[0];
            int oCnt = msLoveCnt[1] + girlLoveCnt[1];
            int vCnt = msLoveCnt[2] + girlLoveCnt[2];
            int eCnt = msLoveCnt[3] + girlLoveCnt[3];
            int thisNum = ((lCnt + oCnt) * (lCnt + vCnt) * (lCnt + eCnt) * (oCnt + vCnt) * (oCnt + eCnt) * (vCnt + eCnt))  % 100;

            // 사랑 확률이 더 높은지 체크
            if (maxLoveCnt <= thisNum) {
                maxLoveCnt = thisNum;
                maxName = loveList[i];
            }
        }

        // 출력
        result.append(maxName);
    }

    public static void input() throws Exception {
        myName = br.readLine();
        N = Integer.parseInt(br.readLine());
        loveList = new String[N];
        for(int i=0; i<N; i++) {
            loveList[i] = br.readLine();
        }
    }


    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}