package com.junsang._20210605_야놀자.Problem;//package com.codility.external;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 과제 1
 * 프랑코가 그의 친구 조반니와 가위바위보 게임을 할 것이다.
 * 각 턴에서 두 선수는 동시에 자신이 선택한 제스처(바위, 종이 또는 가위)를 취한다.
 * 매 턴마다 승점 2점(가위, 가위, 종이, 종이, 가위)이 1점(두 선수가 같은 동작을 보일 때)이 1점, 패자가 0점이다.
 *
 * 프랑코는 매우 간단한 전략을 써서 조반니를 놀라게 하고 싶어한다:
 *  그는 경기 내내 매 턴마다 같은 동작을 할 것이다.
 *  이 전략으로 그가 득점할 수 있는 최대 점수는 몇 점입니까?
 *
 * 함수를 작성한다:
 *
 * 조반니의 턴 순서를 나타내는 문자열 G가 주어지면
 *   R: 바위
 *   P: 보
 *   S: 가위
 * 프랑코가 그의 전략을 사용하여 득점할 수 있는 최대 점수 수를 반환한다.
 *
 * 예:
 *  · "RSPRS"가 주어지면 함수는 6을 반환해야 합니다(선택한 제스처는 흔들림). 프랑코는 승점 6점(2회전, 5회전, 1회전, 4회전 공동)을 얻는다.
 *          ->
 *  · "SRR"이 주어지면 이 기능은 4를 반환해야 합니다(선택한 제스처: 록, 첫 번째 턴에서 이기고 두 번째와 세 번째 턴에서 동점임).
 *  · "PRRPP"가 주어지면 함수는 10(선택한 제스처: 종이)을 반환해야 한다.
 *  · "PPPPRRSSSS"가 주어지면 이 기능은 13(선택한 제스처: 가위)을 반환해야 한다. g의 길이가 범위 내에 있다고 가정한다 [1..100];
 *  · 문자열 G는 문자 'R', 'P', 'S'로만 구성됩니다.
 *
 *  솔루션에서 정확성에 초점을 맞추십시오. 솔루션의 성능은 평가의 초점이 되지 않습니다.
 */
public class _1_First {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();
    //===

    public static void main(String[] args) {
        System.out.println(solution("RSPRS"));
        System.out.println(solution("SRR"));
        System.out.println(solution("PRPRRPP"));
        System.out.println(solution("PPPPRRSSSSS"));

    }

    public static int solution(String G) {

        String[] turn = G.split("");

        List<Integer> strategyPerform = new ArrayList<>();
        strategyPerform.add(choiseStrategy(turn, "가위", 0, 2, 1));
        strategyPerform.add(choiseStrategy(turn, "바위", 1, 0, 2));
        strategyPerform.add(choiseStrategy(turn, "보", 2, 1, 0));

        int mMax = 0;
        for(int curNum : strategyPerform) {
            if (mMax <= curNum)
                mMax = curNum;
        }

        return mMax;
    }

    /**
     *
     * @param turn  게임 턴
     * @param type  전략 타입
     * @param r     주먹을 낸 경우 점수
     * @param p     보를 낸 경우 점수
     * @param s     가위를 낸 경우 점수
     * @return      해당 전략 총 합
     */
    private static int choiseStrategy(String[] turn, String type, int r, int p, int s) {

        int total = 0;
        for(int i=0; i<turn.length; i++) {
            if ("R".equals(turn[i]))
                total += r;
            else if ("P".equals(turn[i]))
                total += p;
            else
                total += s;
        }

        return total;
    }








    /**
     * 보을 낸 경우
     * R=2 / P=1 / S=0
     */
    private static int choiseThePaper(String[] turn) {

        int total = 0;
        for(int i=0; i<turn.length; i++) {
            if ("R".equals(turn[i]))
                total += 2;
            else if ("P".equals(turn[i]))
                total += 1;
            else
                total += 0;
        }

        return total;
    }

    /**
     * 주먹을 낸 경우
     * R=1 / P=0 / S=2
     */
    private static int choiseTheRock(String[] turn) {
        int total = 0;
        for(int i=0; i<turn.length; i++) {
            if ("R".equals(turn[i]))
                total += 1;
            else if ("P".equals(turn[i]))
                total += 0;
            else
                total += 2;
        }

        return total;
    }

    /**
     * 가위을 낸 경우
     * R=0 / P=2 / S=1
     */
    private static int choiseTheScissors(String[] turn) {
        int total = 0;
        for(int i=0; i<turn.length; i++) {
            if ("R".equals(turn[i]))
                total += 0;
            else if ("P".equals(turn[i]))
                total += 2;
            else
                total += 1;
        }

        return total;
    }
}
