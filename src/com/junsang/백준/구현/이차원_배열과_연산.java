package com.junsang.백준.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.04.01
 * @DESC       : 이차원_배열과_연산
 * @see        : https://www.acmicpc.net/problem/17140
 */
public class 이차원_배열과_연산 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int r, c, k;
    static int[][] arr;
    static int retTime = 0;

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        while (true) {

            // 종료 조건
            if (exitCheck())
                break;

            // 연산자 확인
            String operation = operationCheck();

            int row = arr.length;
            int column = arr[0].length;
            List<List<AbstractMap.SimpleImmutableEntry<Integer, Integer>>> a = new ArrayList<>();



            // R 연산
            if ("R".equals(operation)) {


                int nextColumn = 0;


                for(int i=0; i<row; i++) {

                    int[] num = new int[200];
                    for(int j=0; j<column; j++) {
                        if (arr[i][j] != 0)
                            num[arr[i][j]]++;
                    }

                    a.add(i, aa(num));



                    if (nextColumn < (a.get(i).size() * 2)) {
                        nextColumn = (a.get(i).size() * 2);
                    }
                }





                arr = new int[row][nextColumn];
                for(int i=0; i<row; i++) {

                    int strNum = (a.get(i).size() * 2);

                    for(int j=0; j<nextColumn; j++) {


                        if (j >= strNum)
                            break;

                        if (j >= 50)
                            break;

                        if (j%2 == 0) {
                            arr[i][j] = a.get(i).get(j/2).getKey();
                            arr[i][j+1] = a.get(i).get(j/2).getValue();
                        }

                    }
                }



            }




            // C 연산
            else if ("C".equals(operation)) {
                int nextRow = 0;


                for(int i=0; i<column; i++) {

                    int[] num = new int[200];
                    for(int j=0; j<row; j++) {

                        if (arr[j][i] != 0)
                            num[arr[j][i]]++;
                    }

                    a.add(i, aa(num));



                    if (nextRow < (a.get(i).size() * 2)) {
                        nextRow = (a.get(i).size() * 2);
                    }
                }


                arr = new int[nextRow][column];
                for(int i=0; i<column; i++) {

                    int strNum = (a.get(i).size() * 2);

                    for(int j=0; j<nextRow; j++) {

                        if (j >= strNum)
                            break;

                        if (j >= 50)
                            break;


                        if (j%2 == 0) {
                            arr[j][i] = a.get(i).get(j/2).getKey();
                            arr[j+1][i] = a.get(i).get(j/2).getValue();
                        }


                    }
                }





            }





            retTime++;
        }


        result.append(retTime);


    }


    public static List<AbstractMap.SimpleImmutableEntry<Integer, Integer>> aa(int[] num) {
        List<AbstractMap.SimpleImmutableEntry<Integer, Integer>> pair = new ArrayList<>();

        for (int i=0; i<num.length; i++) {
            if (num[i] != 0) {
                pair.add(new AbstractMap.SimpleImmutableEntry<>(i, num[i]));
            }
        }

        Collections.sort(pair, new Comparator<AbstractMap.SimpleImmutableEntry<Integer, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleImmutableEntry<Integer, Integer> o1, AbstractMap.SimpleImmutableEntry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                } else if (o1.getValue().equals(o2.getValue())) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        return pair;
    }





    public static String operationCheck() {
        int rowCnt = arr.length;
        int columnCnt = arr[0].length;

        if (rowCnt >= columnCnt)
            return "R";
        else
            return "C";
    }

    public static boolean exitCheck() {

        if (r-1 < arr.length && c-1<arr[0].length)
            if (arr[r-1][c-1] == k) return true;

        if (retTime > 100) {
            retTime = -1;
            return true;
        }


        return false;
    }

    public static void input() throws Exception {

        for(int i=0; i<3; i++) {

            if (i == 0) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());
                arr = new int[3][3];
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}