package com.junsang._20210403_카카오커머스.Problem;

import java.util.ArrayList;
import java.util.List;

public class _2_Second {

    public static void main(String[] args) {
        solution(new int[][] { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} }, 2);



    }

    public static int solution(int[][] needs, int r) {
        int answer = 0;

        int[] arr = new int[needs.length];
        for(int i=0; i<needs.length; i++) {
            arr[i] = i;
        }


        int n = arr.length;
        int[] combArr = new int[n];

        List<int[]> tc = new ArrayList();

        doCombination(combArr, n, r, 0, 0, arr, tc);


        int ret = 0;
        for(int i=0; i<tc.size(); i++) {
            int[] curArr = tc.get(i);

            int mMax = 0;
            for(int j=0; j<needs.length; j++) {
                int cnt = 0;
                for(int k=0; k<needs[0].length; k++) {
                    if (needs[j][k] == 1) {
                        for(int q=0; q<curArr.length; q++) {
                            if (curArr[q] == k) {
                                cnt++;
                                break;
                            }
                        }
                    }

                    if (needs[j][k] == 0) {
                        cnt++;
                    }

                }

                if (cnt == needs[0].length) mMax++;
            }


            if (ret < mMax) {
                ret = mMax;
            }
        }

        answer = ret;


        return answer;
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr, List<int[]> tc){


        // r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
        if(r == 0){
            List temp = new ArrayList<>();
            for(int i=0; i<index; i++)
                temp.add(arr[combArr[i]]);

            int[] array = temp.stream().mapToInt(j-> (int) j).toArray();


            tc.add(array);

            //끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
        }else if(target == n){

            return;

        }else{
            combArr[index] = target;
            // (i) 뽑는 경우
            // 뽑으니까, r-1
            // 뽑았으니 다음 index + 1 해줘야 함
            doCombination(combArr, n, r-1, index+1, target+1, arr, tc);

            //(ii) 안 뽑는경우
            // 안뽑으니까 그대로 r
            // 안뽑았으니, index는 그대로!
            // index를 그대로하면, 예를 들어 현재 1번 구슬을 comArr에 넣엇어도 다음 재귀에 다시 엎어쳐서 결국 1구슬을 뽑지 않게 된다.
            doCombination(combArr, n, r, index, target+1, arr, tc);
        }

    }

}
