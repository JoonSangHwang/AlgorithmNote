package com.junsang._20210613_카카오.Problem;

import java.util.ArrayList;
import java.util.List;

public class _3_Third {

    public static void main(String[] args) {
        // 10, 8, 9, 15, 12, 6, 7
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(8);
        arr.add(9);
        arr.add(15);
        arr.add(12);
        arr.add(6);
        arr.add(7);


        System.out.println(solution(arr));
    }

    public static int solution(List<Integer> arr) {
        int answer = 0;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                for (int k = i; k <= j; k++) {

                    // 수식1번: x0<=x1<=xi
                    boolean passFlag = true;
                    for (int num = i; num <= k - 1; num++) {
                        if (arr.get(num) > arr.get(num + 1)) {
                            passFlag = false;
                            break;
                        }
                    }

                    if (!passFlag)
                        continue;

                    // 수식2번: xi>=xi+1>xj-1
                    for (int num = k; num <= j - 1; num++) {
                        if (arr.get(num) < arr.get(num + 1)) {
                            passFlag = false;
                            break;
                        }
                    }

                    // 다만족한 경우
                    if (passFlag) {
                        int len = (j - i) + 1;
                        answer = Math.max(answer, len); //최대값 산출
                    }
                }
            }
        }

        return answer;
    }

}
