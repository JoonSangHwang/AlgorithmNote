package com.junsang._20210626_한화생명보험.Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 가장 길게 연속으로 접속한 평일의 수 return
 * 만약 접속한 기록이 없다면 0 return
 *
 */
public class _3_ {

    public static void main(String[] args) {
//        System.out.println(solution("05/04 MON",
//                "05/30",
//                new String[] {"05/26", "05/25", "05/27", "05/10", "05/11", "05/23", "05/22", "05/21", "05/06", "05/09","05/07","05/08"}));

        System.out.println(
                solution("05/27 SUN",
                "06/16",
                new String[] {"05/31", "05/30", "06/01", "06/04", "06/07", "06/06", "06/09", "06/08", "06/13", "06/14","06/10"}));
    }

    /**
     * 공휴일/윤년은 없음
     *
     * @param start_date    길이 9 고정, MM/DD DAY 형식, 01/01 ~ 12/31, MON TUE WED THU FRI SAT SUN
     * @param end_date      길이 5 고정, MM/DD     형식, 01/01 ~ 12/31, end_date >= start_date, 같은 년도
     * @param login_dates   길이 1~365, 접속한 날짜들이 담긴 배열, 하나의 배열은 길이 5, MM/DD 형식, 01/01 ~ 12/31, 정렬X, 중복X
     * @return  가장 길게 연속으로 접속한 평일의 수 return, 만약 접속한 기록이 없다면 0 return
     */
    private static int solution(String start_date, String end_date, String[] login_dates) {

        int[] dateArr = new int[366];
        Arrays.fill(dateArr, 0);

        fillArrayLoginCount(dateArr, login_dates);
        int startDateIdx = fillArrayLoginCountStartDate(dateArr, start_date);

        List<Integer> list = removeWeekendsFromArray(dateArr, start_date, startDateIdx);

        return maxNumOfConsecutiveLogins(list);
    }

    private static int maxNumOfConsecutiveLogins(List<Integer> dateArr) {

        int totalMax = 0;
        int curMax = 0;
        boolean flag = true;

        for(int i=0; i< dateArr.size(); i++) {
            if (flag)
                curMax = 0;

            if (dateArr.get(i) == 1) {
                flag = false;
                curMax++;
            } else
                flag = true;

            if (totalMax < curMax)
                totalMax = curMax;
        }

        return totalMax;
    }


    private static List removeWeekendsFromArray(int[] dateArr, String start_date, int startDateIdx) {

        int waitingTime = 0;

        String day = start_date.split("/")[1].split(" ")[1];
        if ("MON".equals(day)) {
            waitingTime = 0;
        } else if ("TUE".equals(day)) {
            waitingTime = 6;
        } else if ("WED".equals(day)) {
            waitingTime = 5;
        } else if ("THU".equals(day)) {
            waitingTime = 4;
        } else if ("FRI".equals(day)) {
            waitingTime = 3;
        } else if ("SAT".equals(day)) {
            waitingTime = 2;
        } else if ("SUN".equals(day)) {
            waitingTime = 1;
        }


        int dayCount = 0;
        for(int i=0; i<dateArr.length; i++) {
            if (startDateIdx > i) {
                dateArr[i] = 99;
                continue;
            }

            if (waitingTime != 0) {
                if (waitingTime == 1 || waitingTime == 2)
                    dateArr[i] = 99;

                waitingTime--;
                continue;
            }

            dayCount++;
            if (dayCount > 5)
                dateArr[i] = 99;

            if (dayCount == 7)
                dayCount = 0;
        }

        List<Integer> list = new ArrayList();
        for(int i=0; i<dateArr.length; i++) {
            if (dateArr[i] == 99)
                continue;

            list.add(dateArr[i]);
        }
        return list;
    }

    private static int fillArrayLoginCountStartDate(int[] dateArr, String start_date) {
        String mon = start_date.split("/")[0];
        String day = start_date.split("/")[1].split(" ")[0];
        int curIdx = curDateIdx(mon, day);
        dateArr[curIdx]++;

        return curIdx;
    }

    private static void fillArrayLoginCount(int[] dateArr, String[] login_dates) {
        for(int i=0; i<login_dates.length; i++) {
            String mon = login_dates[i].split("/")[0];
            String day = login_dates[i].split("/")[1];

            int curIdx = curDateIdx(mon, day);
            dateArr[curIdx]++;
        }
    }

    private static int curDateIdx(String mon, String day) {
        int jan = 0,
            feb = 31,
            mar = 59,
            apr = 90,
            may = 120,
            jun = 151,
            jul = 181,
            aug = 212,
            sep = 243,
            oct = 273,
            nov = 304,
            dec = 334;

        if ("01".equals(mon))
            return jan + Integer.parseInt(day);
        else if ("02".equals(mon))
            return feb + Integer.parseInt(day);
        else if ("03".equals(mon))
            return mar + Integer.parseInt(day);
        else if ("04".equals(mon))
            return apr + Integer.parseInt(day);
        else if ("05".equals(mon))
            return may + Integer.parseInt(day);
        else if ("06".equals(mon))
            return jun + Integer.parseInt(day);
        else if ("07".equals(mon))
            return jul + Integer.parseInt(day);
        else if ("08".equals(mon))
            return aug + Integer.parseInt(day);
        else if ("09".equals(mon))
            return sep + Integer.parseInt(day);
        else if ("10".equals(mon))
            return oct + Integer.parseInt(day);
        else if ("11".equals(mon))
            return nov + Integer.parseInt(day);
        else
            return dec + Integer.parseInt(day);
    }

}
