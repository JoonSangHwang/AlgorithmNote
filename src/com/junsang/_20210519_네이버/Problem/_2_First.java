package com.junsang._20210519_네이버.Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2_First {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();
    //===

    public static void main(String[] args) {

        solution();
    }

    public static int solution(String S) {

        int answer = 0x80000000;  //최대값 저장
        String string_word_chk = "";   //공백 초기화
        int word_cnt = 0;         //단어 수 저장
        String[] strArr = S.split("");

        for (int s_idx = 0; s_idx <= strArr.length-1; s_idx++) {
            //1.string_word_chk에 단어 저장 이때 . ? ! 문장의 끝이면 단어 체크
            if (strArr[s_idx].equals(" ")|| strArr[s_idx].equals("?")||strArr[s_idx].equals("!")||strArr[s_idx].equals(".")) {
                //2.string_word_chk 단어 길이가 1이상이면 word_cnt ++
                if (string_word_chk.length() >= 1) {
                    word_cnt++;
                    string_word_chk=new String("");//다시 문자열 리셋
                }

                if (!strArr[s_idx].equals(" ")) {//3.그리고 . ? ! 문장의 끝 인경우는 단어의 개수 끝 이때 최대값 갱신
                    answer = answer < word_cnt ? word_cnt : answer;   //4.string_word_chk값 리셋 1,2,3반복
                    word_cnt = 0;// 최대값 갱신 후 리셋
                    s_idx++;
                    if (s_idx==strArr.length)
                        break;
                }

            }

            //answer = answer > word_cnt ? word_cnt : answer;
            if (strArr[s_idx].equals("?")||strArr[s_idx].equals("!")||strArr[s_idx].equals(".")) {
                s_idx--;
                continue;
            }

            if(!strArr[s_idx].equals(" "))
                string_word_chk += strArr[s_idx];

        }

        if (string_word_chk.length() >= 1)
            word_cnt++;

        //4.string_word_chk값 리셋 1,2,3반복
        answer = answer < word_cnt ? word_cnt : answer;
        return answer;
    }
}
