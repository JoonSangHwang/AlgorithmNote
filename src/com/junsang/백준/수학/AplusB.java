package com.junsang.백준.수학;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.03
 * @DESC       : A+B
 * @see        : https://www.acmicpc.net/problem/10757
 */
public class AplusB {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static BigInteger A;
    static BigInteger B;

    public static void main(String[] args) throws Exception {

        in();

        solution();

        ot();

    }

    static public void solution() {
        result.append(A.add(B));
    }

    static public void in() throws IOException {
        st = new StringTokenizer(br.readLine());

//        Integer MAX_VALUE : 2147483647, Long MAX_VALUE : 9223372036854775807

//        Long a = Long.valueOf(n.trim()).longValue();
        A = new BigInteger(st.nextToken().trim());
        B = new BigInteger(st.nextToken().trim());
    }

    static public void ot() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
