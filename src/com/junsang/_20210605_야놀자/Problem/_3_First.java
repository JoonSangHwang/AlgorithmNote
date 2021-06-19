//package com.junsang._20210605.Problem;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Vector;
//
//public class _3_First {
//
//    //===
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringBuilder result = new StringBuilder();
//    //===
//
//    // 배열 탐색
//    static Vector<Integer> workSpace = new Vector<>();
//
//    // 최소 값을 구하기 위함
//    static  int answer = 0x7fffffff;
//
//    // 1~n 값 체크
//    static  Map<Integer, Integer> numChk = new HashMap<>();
//
//    static Vector<Integer> vector = new Vector<>();
//
//    static int[] num = new int[200001];
//
//
//
//
//    public static void main(String[] args) {
//
//        int a = solution(new int[]{1, 2, 1});
//    }
//
//    public static int solution(int[] A) {
//
//
//
//        // 작업 공간에 -1 +1 값 넣기
//        for (int i = 0; i < A.length; i++) {
//            workSpace.set(i, A[i] - 1);
//            workSpace.set(i, A[i]);
//            workSpace.set(i, A[i] + 1);
//        }
//
//        dfs(0, 0, A.length);
//        return answer;
//
//
//
//    }
//
//
//    public static void dfs(int idx, int d, int size) {
//
//        if (idx == size) {
//            int score = 0;
//            int cnt = 0;
//
//            Arrays.fill(num, 0);
//
//            for (int i = 0; i < size; i++) {
//                ///
//                if (num[workSpace.set(i, vector.get(i)) == 0) {
//                    if (a[i] != 1)score++;
//                    num[workSpace[i][a[i]]] = 1;
//                    cnt++;
//                }
//            }
//            if (cnt == size) {
//                answer = answer > score ? score : answer;
//            }
//            return;
//        }
//        for (int i = 0; i <= 2; i++) {
//            vector.add(i);
//            dfs(idx + 1, d + 1,size);
//            vector.remove(vector.size()-1);
//        }
//    }
//
//
//
//}
