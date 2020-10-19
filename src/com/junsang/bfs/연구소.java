package com.junsang.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @author     : junsang Hwang
 * @Date       : 2020.10.19
 * @DESC       : 연구소
 * @see        : https://www.acmicpc.net/problem/14502
 */
public class 연구소 {

    static int[][] dir = { {1,0} , {-1,0} , {0,1} , {0,-1} };
    static int[][] map;
    static int[][] cloneMap;
    static int M, N, CNT, MAX = 0;
    static Queue<Dot> que = new LinkedList<Dot>();
    static Vector<Dot> vec = new Vector<Dot>();

    public static void main(String[] args) throws IOException {

        input();

        // 바이러스가 퍼지지 않은 지역 Queue 삽입
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    que.add(new Dot(i,j));
                    vec.add(new Dot(i,j));
                }
            }
        }

        Dot wall_1 = new Dot();
        Dot wall_2 = new Dot();
        Dot wall_3 = new Dot();
        for (int i=0; i<vec.size()-2; i++) {
            for (int j=i+1; j<vec.size()-1; j++) {
                for (int k=j+1; k<vec.size(); k++) {
                    //== 기둥 3개 세우기
                    wall_1 = vec.get(i);
                    wall_2 = vec.get(j);
                    wall_3 = vec.get(k);

                    map[wall_1.x][wall_1.y] = 1;
                    map[wall_2.x][wall_2.y] = 1;
                    map[wall_3.x][wall_3.y] = 1;

                    //== 연구소 Clone
                    for (int i2 = 0; i2<N; i2++) {
                        for (int j2=0; j2<M; j2++) {
                            cloneMap[i2][j2] = map[i2][j2];
                        }
                    }

                    //== 바이러스 지역을 Vector 에 삽입
                    Vector<Dot> v2 = new Vector<Dot>();
                    Dot virousArea;
                    for (int i2 = 0; i2<N; i2++) {
                        for (int j2=0; j2<M; j2++) {
                            if (cloneMap[i2][j2] == 2) {
                                v2.add(new Dot(i2, j2));
                            }
                        }
                    }

                    //== [S] 바이러스가 퍼진 곳이 하나 이상 일 경우
                    if (!v2.isEmpty()) {
                        // 바이러스 퍼진 곳만큼 루프
                        for (int i3=0; i3<v2.size(); i3++) {
                            virousArea = v2.get(i3);

                            for (int j3=0; j3<4; j3++) {
                                int nextX = virousArea.x + dir[j3][0];
                                int nextY = virousArea.y + dir[j3][1];

                                if ( 0 <= nextX && nextX < N && 0 <= nextY && nextY < M ) {
                                    if (cloneMap[nextX][nextY] == 0) {
                                        cloneMap[nextX][nextY] = 2;
                                        v2.add(new Dot(nextX, nextY));
                                    }
                                }
                            }
                        }

                        // 바이러스가 퍼지지 않은 영역 수
                        for (int i3 = 0; i3 < N; i3++) {
                            for (int j3 = 0; j3 < M; j3++) {
                                if (cloneMap[i3][j3] == 0) {
                                    CNT++;
                                }
                            }
                        }

                        // 지역의 안전영역이 최대인 지점 구하기
                        if (MAX < CNT) {
                            MAX = CNT;
                        }
                        CNT = 0;

                        v2.clear();
                    }
                    //== [E] 바이러스가 퍼진 곳이 하나 이상 일 경우

                    map[wall_3.x][wall_3.y] = 0;
                }
                map[wall_2.x][wall_2.y] = 0;
            }
            map[wall_1.x][wall_1.y] = 0;
        }


        output();
    }

    public static void mapReset() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                cloneMap[i][j] = map[i][j];
            }
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];
        cloneMap = new int[N][M];
        for (int i=0; i<N; i++) {
            str = br.readLine().split(" ");
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                cloneMap[i][j] = Integer.parseInt(str[j]);
            }
        }
    }

    public static void output() {
        System.out.println(MAX);
    }
}

class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Dot() {

    }
}