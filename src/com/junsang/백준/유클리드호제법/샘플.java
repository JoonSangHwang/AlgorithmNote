package com.junsang.백준.유클리드호제법;

import java.util.Scanner;

public class 샘플 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();       // 입력1
        int b = sc.nextInt();       // 입력2

        // 유클리드 호제법
        int gcd = GCD(a, b);
        int lcm = LCM(a, b, gcd);

        // 출력
        System.out.println("최대공약수 : " + gcd);
        System.out.println("최소공배수 : " + lcm);
    }

    /**
     * 최대 공약수 (GCD)
     */
    public static int GCD(int a, int b){
        if(b == 0) return a;
        else return GCD(b, a % b);
    }

    /**
     * 최소 공배수 (LCM)
     */
    public static int LCM(int a, int b, int gcd){
        return a * b / gcd;
    }
}
