package com.junsang._20210613_카카오.Problem;

import java.util.Arrays;

public class _2_Second {

    public static void main(String[] args) {


        System.out.println(solution(0));
//        System.out.println(solution(5));
//        System.out.println(solution(540));
//        System.out.println(solution(1000000));
    }

    public static int solution(int n) {
        int[] numChk = new int[10000001];   // 10^6
        Arrays.fill(numChk, 0);

        // 최대 계승 값
        int maxfactorialVal = n;         // 현재 리더 전력
        int numCnt = 1;                  // 현재 팀원 수
        numChk[n] = 1;;                  // 전력을 가진 선수가 있다는 것을 체크하기 위함
        String str = String.valueOf(n);  // 현재 선수의 전력

        while (true) {

            /** [S] 팀원 전력 파악하기 **/

            // 현재 팀원 전력 합 구하기
            int sum = 0;

            // 현재 팀원의 전력의 길이 만큼 반복하여 한 자리씩 접근 (120 이면 길이 3으로, 1접근/2접근/0접근)
            for (int i = 0; i<str.length(); i++) {

                // 부분 전력 (시작 값이 1인 이유는, 0! 은 1이고, 1! 역시 1이다... 참고)
                int offensePower = 1;

                // 계승 값의 합 (음... char 형으로 바꿔서 문자를 int 값으로 바꿔줄 필요 없었음)
                int ascii = ((int) str.split("")[i].toCharArray()[0]) - 48;
                for (int num = ascii; num > 0; num--)
                    offensePower *= num;

                sum += offensePower;
            }

            // 동일한 공격력을 가진 선수는 추가할 수 없다.
            if (numChk[sum] == 1)
                break;


            numChk[sum] = 1;    // 전력을 가진 선수가 있다는 것을 체크하기 위함
            numCnt++;           // 현재 팀원 수

            // 리더 뽑기 (=최대 전력을 가진 팀원)
            maxfactorialVal = Math.max(maxfactorialVal, sum);

            // 다음 선수의 전력
            str = String.valueOf(sum);
        }

        // 팀의 전력
        return maxfactorialVal * numCnt;
    }

}
