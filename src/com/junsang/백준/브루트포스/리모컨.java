package com.junsang.백준.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.02.19
 * @DESC       : 리모컨
 * @see        : https://www.acmicpc.net/problem/1107
 */
public class 리모컨 {

    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    //===

    static int N = 0;
    static int M = 0;
    static boolean[] brokenBtn = new boolean[10];

    public static void main(String[] args) throws Exception{
        in();

        solution();

        ot();
    }

    public static void solution() {

        // 1번 : 리모컨의 +, - 버튼으로만 이동 했을 경우의 수
        int answer = Math.abs(N - 100);
//        System.out.println("case 1 = " + answer);

        // 2번 : 0 ~ 1000000 까지 모든 채널을 돌면서 가장 적은 버튼을 눌러 이동할 수 있는 채널을 찾는다
        for(int i = 0; i <= 1000000; i++) {
            int curNum = i;
            int pass = brokenYn(curNum);

            // 고장난 버튼이 아닌 경우
            if (pass > 0) {
                // N 에 최대한 인접하게 이동한 후, +, -를 몇 번 눌러야 하는지 구함
                int press = Math.abs(curNum - N);
                if (answer > pass + press) {
                    answer = pass + press;
                }
            }
        }
        result.append(answer);
    }

    /**
     * 고장 난 숫자일 경우 ?
     * : 0 리턴
     *
     * 고장 나지 않았을 경우 ?
     * : 1의 자리는 1
     * : 10의 자리는 2
     * : 100의 자리는 3
     * : ......
     */
    public static int brokenYn(int curNum) {
        if (curNum == 0) {
            if (brokenBtn[0]) return 0;
            else return 1;
        }

        int len = 0;
        while (curNum > 0) {
            if (brokenBtn[curNum % 10]) {
                return 0;
            }
            len += 1;
            curNum /= 10;
        }

        return len;
    }

    public static void in() throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // NullPointerException 방지
        if(M ==0) return;

        String sp[] = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            brokenBtn[Integer.parseInt(sp[i])] = true;
        }
    }

    public static void ot() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
