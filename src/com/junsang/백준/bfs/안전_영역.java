package com.junsang.백준.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.30
 * @DESC       : 안전 영역
 * @see        : https://www.acmicpc.net/problem/2468
 */
public class 안전_영역 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static int[][] dir = { {1,0} , {-1,0} , {0,1} , {0,-1} };
    static boolean[][] visited;

    static int[][] area;
    static int[][] cloneArea;
    static int height = 0;
    static int maxAreaCnt = 0;
    static int curAreaCnt = 0;

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        while (height-- > 0) {

            // 각 높이마다 초기화
            setInit(height);

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if (cloneArea[i][j] != 1)
                        continue;

                    if (visited[i][j])
                        continue;

                    bfs(i, j);      // 탐색
                    curAreaCnt++;   // 안전 영역 플러스
                }
            }


            // 최대 안전 영역 개수 구하기
            if (maxAreaCnt < curAreaCnt)
                maxAreaCnt = curAreaCnt;
        }

        // 정답
        result.append(maxAreaCnt);
    }

    public static void setInit(int height) {
        for(int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                // 클론 지역 초기화
                if (area[i][j] > height)
                    cloneArea[i][j] = 1;
                else
                    cloneArea[i][j] = 0;

                // 방문 체크 초기화
                visited[i][j] = false;

                // 현재 안전 영역 개수 초기화
                curAreaCnt = 0;
            }
        }
    }


    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});

        // 방문 체크
        visited[x][y] = true;

        // 주변 탐색
        while(!que.isEmpty()){
            int curX = que.peek()[0];
            int curY = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++){
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;

                if (cloneArea[nextX][nextY] != 1)
                    continue;

                if (visited[nextX][nextY])
                    continue;

                que.add(new int[]{nextX,nextY});
                visited[nextX][nextY] = true;
            }
        }
    }


    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        cloneArea = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int curHeight = Integer.parseInt(st.nextToken());
                area[i][j] = curHeight;

                if (height < curHeight)
                    height = curHeight;
            }
        }
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}