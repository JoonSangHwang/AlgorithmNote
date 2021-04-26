package com.junsang.백준.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.04.26
 * @DESC       : 가운데를 말해요
 * @see        : https://www.acmicpc.net/problem/1655
 */
public class 가운데를_말해요 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();

    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static int totalCount = 0;


    public static void main(String[] args) throws Exception {

        // 입력
        problemInput();


        // 초기 값은 바로 add
        maxHeap.add(Integer.parseInt(br.readLine()));
        result.append(maxHeap.peek() + "\n");

        while (totalCount-- > 0) {

            // 정수 입력 받기
            int curNum = Integer.parseInt(br.readLine());

            // 우선순위 큐에 삽입
            if (maxHeap.size() == minHeap.size())
                maxHeap.add(curNum);
            else
                minHeap.add(curNum);

            // peek 값 비교 후, value 체인지 여부 판단
            if (maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }

            result.append(maxHeap.peek() + "\n");
        }


        // 출력
        problemOutput();
    }


    /**
     * 입력
     */
    private static void problemInput() throws Exception {

        // 수빈이가 외칠 정수의 개수
        totalCount = Integer.parseInt(br.readLine()) -1;

        // 최소 우선순위 큐, Comparator 오름차순
        minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 최대 우선순위 큐, Comparator 내림차순
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }


    /**
     * 출력
     */
    private static void problemOutput() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}