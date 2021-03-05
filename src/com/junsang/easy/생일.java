package com.junsang.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.05
 * @DESC       : 생일
 * @see        : https://www.acmicpc.net/problem/5635
 */
public class 생일 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N = 0;
    static String[][] inputArr;
    static List<AbstractMap.SimpleImmutableEntry<String, Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        input();
        solution();
        output();
    }

    public static void solution() throws Exception {

        Collections.sort(arr, new Comparator<AbstractMap.SimpleImmutableEntry<String, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleImmutableEntry<String, Integer> o1, AbstractMap.SimpleImmutableEntry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue().equals(o2.getValue())) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for(int i=0; i< arr.size(); i++) {
            if (i==0) result.append(arr.get(i).getKey() + "\n");
            if (i==arr.size()-1) result.append(arr.get(i).getKey());
        }
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        inputArr = new String[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            inputArr[i][0] = st.nextToken();
            String dd = String.format("%02d", Integer.parseInt(st.nextToken()));
            String mm = String.format("%02d", Integer.parseInt(st.nextToken()));
            String yy = String.format("%04d", Integer.parseInt(st.nextToken()));

            arr.add(new AbstractMap.SimpleImmutableEntry<>(inputArr[i][0], Integer.parseInt(yy+mm+dd)));
        }


    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
