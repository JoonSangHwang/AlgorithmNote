package com.junsang._20210619_요기요.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class _1_ {

    public static void main(String[] args) {


        solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "Example");
    }


    public static String solution(String S, String C) {

        String[] newRecruitsArr = S.split(",");
        List<String> newRecruitsEmailArr = new ArrayList<>();

        String answer = "";

        // 앞, 뒤 공백 제거
        for(int i=0; i<newRecruitsArr.length; i++) {
            newRecruitsArr[i] = newRecruitsArr[i].trim();
        }

        // 로직
        for(int i=0; i<newRecruitsArr.length; i++) {

            String[] curNewRecruits = newRecruitsArr[i].split(" ");

            if (newRecruitsArr[i].split(" ").length == 2) {
                answer += String.valueOf(curNewRecruits[0].charAt(0)).toLowerCase(Locale.ROOT);;

                String transStr = curNewRecruits[1].replace("-", "");

                if (transStr.length() >= 8)
                    transStr = transStr.substring(0, 9);

                answer += transStr.toLowerCase();
            } else {
                answer += String.valueOf(curNewRecruits[0].charAt(0)).toLowerCase(Locale.ROOT);;
                answer += String.valueOf(curNewRecruits[1].charAt(0)).toLowerCase(Locale.ROOT);;

                String transStr = curNewRecruits[2].replace("-", "");

                if (transStr.length() >= 7)
                    transStr = transStr.substring(0, 8);

                answer += transStr.toLowerCase();
            }

            int num = 2;
            String originStr = answer;
            while (true) {
                boolean reLoop = false;

                for(int j=0; j<newRecruitsEmailArr.size(); j++) {
                    if (newRecruitsEmailArr.get(j).equals(answer)) {
                        answer = originStr + String.valueOf(num);
                        num++;
                        reLoop = true;
                        break;
                    }
                }

                if (!reLoop)
                    break;
            }

            newRecruitsEmailArr.add(answer);

            answer = "";
        }

        String ret = "";
        for(int i=0; i<newRecruitsArr.length; i++) {

            if (i == newRecruitsArr.length-1)
                ret += newRecruitsArr[i] + " <" + newRecruitsEmailArr.get(i) + "@" + C.toLowerCase() + ".com>";
            else
                ret += newRecruitsArr[i] + " <" + newRecruitsEmailArr.get(i) + "@" + C.toLowerCase() + ".com>, ";
        }

        return ret;
    }
}
