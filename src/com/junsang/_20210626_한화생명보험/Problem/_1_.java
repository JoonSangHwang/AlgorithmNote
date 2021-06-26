package com.junsang._20210626_한화생명보험.Problem;

public class _1_ {

    public static void main(String[] args) {
        System.out.println(solution("100111"));
        System.out.println(solution("10011101111011011"));
        System.out.println(solution("0000000000000"));

    }

    private static int solution(String s) {

        int totalMax = 0;
        int curMax = 0;
        boolean flag = true;

        String[] word = s.split("");
        for(int i=0; i< word.length; i++) {
            if (flag)
                curMax = 0;

            if ("1".equals(word[i])) {
                flag = false;
                curMax++;
            } else
                flag = true;

            if (totalMax < curMax)
                totalMax = curMax;
        }

        return totalMax;
    }


}
