package com.junsang._20210403_DevMatching.Problem;

public class _1_First {

    public static void main(String[] args) {

        solution(new int[]{ 44, 1, 0, 0, 31, 25 }, new int[]{31, 10, 45, 1, 6, 19});
        solution(new int[]{ 0, 0, 0, 0, 0, 0 }, new int[]{38, 19, 20, 40, 15, 25});
        solution(new int[]{ 45, 4, 35, 20, 3, 9 }, new int[]{20, 9, 3, 45, 4, 35});
    }

    public static int[] solution(int[] lottos, int[] win_nums) {


        int zeroCnt = 0;
        int curCnt = 0;
        for(int i=0; i<lottos.length; i++) {

            if (lottos[i] == 0)
                zeroCnt++;


            for(int j=0; j<win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    curCnt++;
                    break;
                }
            }

        }

        System.out.println(curCnt);


        int mMin = cntCheck(curCnt);
        int mMax = 0;
        if (mMin > zeroCnt)
            mMax = mMin - zeroCnt;
        else
            mMax = 1;





        return new int[] {mMax, mMin};
    }

    public static int cntCheck(int cnt) {
        if (cnt == 6)
            return 1;
        else if (cnt == 5)
            return 2;
        else if (cnt == 4)
            return 3;
        else if (cnt == 3)
            return 4;
        else if (cnt == 2)
            return 5;
        else
            return 6;
    }


}
