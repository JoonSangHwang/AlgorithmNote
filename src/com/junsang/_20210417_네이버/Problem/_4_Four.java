package com.junsang._20210417_네이버.Problem;

import java.util.*;

public class _4_Four {


    public static void main(String[] args) {

        System.out.println(solution(new int[]{5, 5}));
        System.out.println(solution(new int[]{10,0,8,2,-1,12,11,3}));


    }

    public static int solution(int[] A) {
      Map<Integer, Integer> rackedPoint = new HashMap<>(); //주차된곳

      int answer = 0x80000000;

      List<Integer> pointVector = new ArrayList<>();

      int length = A.length;

      int MinIndex = 0x7fffffff;
      int MaxIndex = 0x80000000;//최소 인덱스 최대 인덱스 산출




      for(int i=0;i<length;i++){
          rackedPoint.put(A[i] + 1000000000, 1);
          pointVector.add(A[i] + 1000000000);//음수제거하기 위해서
          MinIndex = MinIndex > A[i] + 1000000000 ? A[i] + 1000000000 : MinIndex;
          MaxIndex = MaxIndex < A[i] + 1000000000 ? A[i] + 1000000000 : MaxIndex;
      }

        pointVector.sort(null);//순서대로 정렬

        for (int index = MinIndex; index < MaxIndex; index++) {
            int firstIndex=0;
            int lastIndex=0;

            if (rackedPoint.get(index) == null)
                rackedPoint.put(index, 0);

            if (rackedPoint.get(index) != 1) {//주차가능구역
                for (int i = 0; i < pointVector.size(); i++) {//현재주차할곳에서 작은값
                    if (pointVector.get(i) < index) {
                        firstIndex = pointVector.get(i);
                    }
                    else break;//같거나크면 종료
                }
                for (int i = 0; i < pointVector.size(); i++) {//현재주차할곳에서 큰값
                    if (pointVector.get(i) > index) {
                        lastIndex = pointVector.get(i);
                        break;
                    }
                }
                int num1 = index - firstIndex;
                int num2 = lastIndex - index;
                //여기서 num1과 num2에서 작은값을 최대로 저장하기
                if (num1 <= num2)answer = answer < num1 ? num1 : answer;
                else if (num1 > num2)answer = answer < num2 ? num2 : answer;
            }
        }
        if (answer == 0x80000000)answer = 0;//0인경우

        return answer;
    }

}
