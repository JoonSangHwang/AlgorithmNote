package com.junsang._20210429_삼성.Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.04.30
 * @DESC       : 마법사 상어와 블리자드
 * @see        : https://www.acmicpc.net/problem/21611
 */
public class 마법사_상어와_블리자드 {

    //== 입력
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int sideLength;          // 변의 길이
    static int magicPerformCount;   // 마법 수행 카운트

    static int[][] grid;                                // 격자
    static List<Integer> gridList = new ArrayList<>();  // 격자 리스트

    static int num1 = 0, num2 = 0, num3 = 0;            // 구슬 개수


    public static void main(String[] args) throws IOException {
        //== 입력
        problemInput();

        //== 로직 시작
        gridListInit();

        while(magicPerformCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            int moveDir = Integer.parseInt(st.nextToken());    // 이동 방향
            int moveNum = Integer.parseInt(st.nextToken());    // 이동 횟수

            // 1. 블리자드 마법 시전
            blizzardMagic(moveDir, moveNum);

            // 2. 구슬 폭파
            while(true) {
                if (beadExplosion())
                    break;
            }

            // 3. 구슬 변화
            beadChange();
        }

        //== 출력
        problemOutput();
    }


    /**
     * 입력
     */
    private static void problemInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        sideLength = Integer.parseInt(st.nextToken());
        magicPerformCount = Integer.parseInt(st.nextToken());

        grid = new int[sideLength][sideLength];
        for(int row = 0; row< sideLength; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col< sideLength; col++) {
                grid[row][col] = Integer.parseInt(st.nextToken());
                gridList.add(0);
            }
        }
    }


    /**
     * 그리드 초기화 (달팽이 배열)
     */
    private static void gridListInit() {
        int gridListCnt = (sideLength * sideLength) -1;
        int arrSideLeng = sideLength;
        int right = -1;
        int bottom = 0;
        int top = 1;

        for(int i=sideLength; i>0; i--) {

            for(int j = 0; j< arrSideLeng; j++) {
                right += top;
                gridList.set(gridListCnt, grid[bottom][right]);
                gridListCnt--;
            }

            arrSideLeng--;

            for(int j = 0; j< arrSideLeng; j++) {
                bottom += top;
                gridList.set(gridListCnt, grid[bottom][right]);
                gridListCnt--;
            }

            top *= -1;
        }
    }


    /**
     * 1. 블리자드 마법 시전
     */
    private static void blizzardMagic(int moveDir, int moveNum) {

        int seq = 1;                     // moveDir : 1(↑)
        if (moveDir == 2) seq = 3;       // moveDir : 1(↓)
        else if (moveDir == 4) seq = 5;  // moveDir : 1(←)
        else if (moveDir == 1) seq = 7;  // moveDir : 1(→)

        int num = 0;
        List<Integer> removeIdx = new ArrayList<>();
        for(int i=0; i<moveNum; i++) {
            num += (sideLength * i) + (seq + i);
            removeIdx.add(num);
        }

        for(int i=removeIdx.size()-1; i>=0; i--) {
            int idx = removeIdx.get(i);

            if (gridList.size() < idx)
                continue;

            gridList.remove(idx);
        }
    }


    /**
     * 2. 구슬 폭파
     */
    private static boolean beadExplosion() {
        for(int i=1; i<gridList.size(); i++) {

            int idx = 1;
            int explosionFlag = 1;
            while (true) {

                if (i+idx >= sideLength*sideLength || i+idx >= gridList.size())
                    break;

                if (gridList.get(i+idx) == 0)
                    break;

                if (gridList.get(i) != gridList.get(i+idx) )
                    break;

                explosionFlag++;
                idx++;
            }

            // 폭발 조건
            if (explosionFlag < 4)
                continue;

            while(explosionFlag-- > 0) {
                int curValue = gridList.get(i+idx-1);

                if (curValue == 1) num1++;
                else if (curValue == 2) num2++;
                else if (curValue == 3) num3++;

                gridList.remove(i+idx-1);
                idx--;
            }

            return false;
        }

        return true;
    }


    /**
     * 3. 구슬 변화
     */
    private static void beadChange() {

        List<Integer> cloneGridList = new ArrayList<>();
        cloneGridList.add(0);

        for(int i=1; i<gridList.size();) {

            // 범위 확인
            if (i >= sideLength*sideLength || i >= gridList.size())
                break;

            if (gridList.get(i) == 0)
                break;

            // 다음 구슬이 같은 구슬인지 확인
            int idx = 1;
            while (true) {
                if (i+idx >= sideLength*sideLength || i+idx >= gridList.size())
                    break;

                if (gridList.get(i+idx) == 0)
                    break;

                if (gridList.get(i) != gridList.get(i+idx) )
                    break;

                idx++;
            }

            // 구슬 변화
            cloneGridList.add(idx);             // 구슬 개수
            cloneGridList.add(gridList.get(i)); // 구슬 숫자

            // 초기화
            i += idx;
        }

        // 만약 변화한 구슬의 길이가 부족하면, 나머지 0으로 채워줌
        while (cloneGridList.size() < sideLength*sideLength) {
            cloneGridList.add(0);
        }

        // 원본 그리드 리스트 초기화 및 clone 복사
        gridList.clear();
        gridList.addAll(cloneGridList);
        cloneGridList.clear();
    }


    /**
     * 출력
     */
    private static void problemOutput() {
        int answer = (1*num1) + (2*num2) + (3*num3);
        System.out.print(answer);
    }
}
