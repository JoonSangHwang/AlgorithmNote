package com.junsang.프로그래머스.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.16
 * @DESC       : 가장 큰 수
 * @see        : https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class 가장_큰_수 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));

    }

    public static String solution(int[] numbers) {
        String answer = "";

        // int[] To String[]
        String[] result = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬 (내림차순)
        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        // 0 값의 중복 제거
        if ("0".equals(result[0])) {
            return "0";
        }

        // String[] To String
        for (String str: result) {
            answer += str;
        }

        return answer;
    }

}
