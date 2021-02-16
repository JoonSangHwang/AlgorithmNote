package com.junsang.백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2020.10.18
 * @DESC       : JOI와IOI
 * @see        : https://www.acmicpc.net/problem/5586
 */
public class JOI와IOI {

    static String[] inStr = new String[1000];
    static int joiCnt = 0;
    static int ioiCnt = 0;

    public static void main(String[] args) throws IOException {

        input();

        String[] splitStr = inStr[0].split("");
        for (int i=0; i<splitStr.length; i++) {
            if (i+1 < splitStr.length ) {
                if ("J".equals(splitStr[i]) && "O".equals(splitStr[i + 1]) && "I".equals(splitStr[i + 2]))
                    joiCnt++;

                if ("I".equals(splitStr[i]) && "O".equals(splitStr[i + 1]) && "I".equals(splitStr[i + 2]))
                    ioiCnt++;
            }
        }

        output();
    }



    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String fbi = st.nextToken();
        inStr[0] = fbi;
    }

    private static void output() {
        System.out.println(joiCnt);
        System.out.println(ioiCnt);
    }

}
