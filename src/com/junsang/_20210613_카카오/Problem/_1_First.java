package com.junsang._20210613_카카오.Problem;

public class _1_First {


    public static void main(String[] args) {

        System.out.println(solution("statistics"));
        System.out.println(solution("hackthegame"));
        System.out.println(solution("falafal"));
    }

    private static int solution(String s) {
        int[] wordAsciiTable = new int[26];
        int answer = 0;

        String[] word = s.split("");
        for(int i=0; i<word.length; i++) {
            int ascii = ((int) word[i].toCharArray()[0]) - 97;
            wordAsciiTable[ascii]++;
        }


        boolean searchFlag = false;
        for(int i=0; i<word.length; i++) {
            int ascii = ((int) word[i].toCharArray()[0]) - 97;

            if (wordAsciiTable[ascii] == 1) {
                answer = i+1;
                searchFlag = true;
                break;
            }
        }

        if (searchFlag)
            return answer;
        else
            return -1;
    }
}
