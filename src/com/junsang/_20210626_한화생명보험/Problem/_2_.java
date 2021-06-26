package com.junsang._20210626_한화생명보험.Problem;


import java.util.ArrayList;
import java.util.List;

public class _2_ {

    public static void main(String[] args) {
//        System.out.println(solution(new int[] {1,3,7,8,10,15}, 3));
        System.out.println(solution(new int[] {1,2,12,14,15}, 4));
    }

    private static int solution(int[] scores, int k) {
        if (k==1)
            return scores[scores.length-1] - scores[0];

        int answer = 1000000000;
        int scoreSize = scores.length;  //점수 개수

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(i);
        }


        while (true) {

            System.out.println("a");

            int sum = 0;
            for (int i = 0; i < k; i++) {
                if (i == k - 1)
                    sum += scores[scoreSize - 1] - scores[list.get(i)];
                else if (i == 0)
                    sum += scores[list.get(i+1) - 1] - scores[0];
                else
                    sum += scores[list.get(i+1) - 1] - scores[list.get(i)];
            }

            answer = Math.min(answer, sum); //최대값 산출


            list.set(k-1, list.get(k-1) + 1);

            if (list.get(k - 1) == scoreSize) {//끝값까지 갔으면
                if (list.get(0) == scoreSize - k)
                    break;

                for (int i = k - 1; i >= 0; i--) {
                    if (list.get(i) == scoreSize - (k - 1 -i)) {
                        list.set(i -1, list.get(i -1)+1);
                        list.set(i,    list.get(i -1)+1);
                        for (int j = i + 1; j < k; j++) {
                            if (list.get(j) == scoreSize)
                                list.set(j, list.get(j - 1)+1);
                        }
                    }
                }

                for (int i = k - 1; i >= 0; i--) {
                    if (list.get(i) == scoreSize - (k - 1 -i)) {
                        list.set(i -1, list.get(i -1)+1);
                        list.set(i,    list.get(i -1)+1);
                    }
                }
            }
        }

        return answer;
    }
}
