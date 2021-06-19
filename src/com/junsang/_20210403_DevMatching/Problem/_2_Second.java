package com.junsang._20210403_DevMatching.Problem;

import java.util.ArrayList;
import java.util.List;

public class _2_Second {


    public static void main(String[] args) {

        solution(6, 6, new int[][]{ {2,2,5,4}, {3,3,6,6}, {5,1,6,3} });     // 답: 8, 10, 25
    }


    public static int[] solution(int rows, int columns, int[][] queries) {

        int[][] map = new int[rows][columns];
        mapInit(map, rows, columns);


        for(int i=0; i<queries.length; i++) {
            
            // 맵 회전
            mapRotate(map, queries[i]);
            
            
            // 가장 작은 수 파악
            minValueCheck(map, queries[i]);

        }



        return new int[] {1,2};
    }

    public static void minValueCheck(int[][] map, int[] query) {
    }

    public static void mapRotate(int[][] map, int[] query) {

        int a = query[0] - 1;
        int b = query[1] - 1;
        int c = query[2] - 1;
        int d = query[3] - 1;


        List list = new ArrayList();


        int centerNum = 0;
        int rotateNum = 0;

        for(int i=0; i<map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (i>=a && i<=c && j>=b && j<=d) {
                    if (i == a || i == c) {
                        rotateNum++;
                    } else {
                        if (j == b || j == d) rotateNum++;
                        else centerNum++;
                    }
                }
            }
        }

        int e = d-b+1;
        int f = rotateNum - e;

        for(int i=0; i<map.length; i++) {


            if (list.size() < e || list.size() >= f) {


                for (int j = 0; j < map[0].length; j++) {

                    if (i>=a && i<=c && j>=b && j<=d) {
                        if (i == a || i == c) {
                            list.add(map[i][j]);
                        } else {
                            if (j == b || j == d) list.add(map[i][j]);
                        }
                    }
                }



            } else {


                for (int j = map[0].length-1; j >= 0; j--) {

                    if (i>=a && i<=c && j>=b && j<=d) {
                        if (i == a || i == c) {
                            list.add(map[i][j]);
                        } else {
                            if (j == b || j == d) list.add(map[i][j]);
                        }
                    }
                }



            }



        }



        List list2 = new ArrayList();
        for(int i=0; i<=list.size(); i++) {
            if (i == 0) {
                list2.add(list.get(list.size()-1));
            } else {
                list2.add(list.get(i-1));
            }
        }

        int listCnt = 0;
        for(int i=0; i<map.length; i++) {


            if (list.size() < e || list.size() >= f) {


                for (int j = 0; j < map[0].length; j++) {

                    if (i>=a && i<=c && j>=b && j<=d) {
                        if (i == a || i == c) {

                            map[i][j] = (int) list2.get(listCnt);
                            listCnt++;


                        } else {
                            if (j == b || j == d) {
                                map[i][j] = (int) list2.get(listCnt);
                                listCnt++;
                            }
                        }
                    }
                }



            } else {


                for (int j = map[0].length-1; j >= 0; j--) {

                    if (i>=a && i<=c && j>=b && j<=d) {
                        if (i == a || i == c) {
                            map[i][j] = (int) list2.get(listCnt);
                            listCnt++;
                        } else {
                            if (j == b || j == d) {
                                map[i][j] = (int) list2.get(listCnt);
                                listCnt++;
                            }
                        }
                    }
                }



            }



        }



        System.out.println("");

    }

    public static void mapInit(int[][] map, int rows, int columns) {

        int cnt = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = cnt;

                cnt++;
            }
        }
    }

}
