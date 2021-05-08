package com.junsang._20210508_카카오.Problem;

import java.util.HashMap;
import java.util.Map;

public class _1_First {

    public static void main(String[] args) {
        solution(new String("one4seveneight"));
        System.out.println();
        solution(new String("23four5six7"));
        System.out.println();
        solution(new String("2three45sixseven"));
        System.out.println();
        solution(new String("123"));
    }

    private static void solution(String str) {

        String[] words = str.split("");

        for(int idx=0; idx<words.length; idx++) {
            if (words[idx].matches("[+-]?\\d*(\\.\\d+)?")) {
                System.out.print(words[idx]);
            } else {
                Map num = searchNum(words[idx], words[idx+1]);
                int increase = (int) num.get("idx") - 1;
                idx += increase;

                System.out.print(num.get("num"));
            }
        }

    }

    private static Map searchNum(String word, String nextWord) {

        Map map = new HashMap();

        // 0
        if (word.equals("z")) {
            map.put("idx", 4); map.put("num", 0);
        }

        // 1
        else if (word.equals("o")) {
            map.put("idx", 3); map.put("num", 1);
        }

        // 2 3
        else if (word.equals("t")) {
            if (nextWord.equals("w")) {
                map.put("idx", 3);
                map.put("num", 2);
            } else {
                map.put("idx", 5);
                map.put("num", 3);
            }
        }

        // 4 5
        else if (word.equals("f")) {
            if (nextWord.equals("o")) {
                map.put("idx", 4);
                map.put("num", 4);
            } else {
                map.put("idx", 4);
                map.put("num", 5);
            }
        }

        // 6 7
        else if (word.equals("s")) {
            if (nextWord.equals("i")) {
                map.put("idx", 3);
                map.put("num", 6);
            } else {
                map.put("idx", 5);
                map.put("num", 7);
            }
        }

        // 8
        else if (word.equals("e")) {
            map.put("idx", 5); map.put("num", 8);
        }

        // 9
        else {
            map.put("idx", 4); map.put("num", 9);
        }

        return map;
    }
}
