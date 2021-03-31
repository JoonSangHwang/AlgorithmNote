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
 * @Date       : 2021.03.31
 * @DESC       : 빙산
 * @see        : https://www.acmicpc.net/problem/2573
 */
public class 빙산 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N, M, year = 0;
    static int[][] map;
    static int[][] cloneMap;
    static int[][] dir = { {1,0} , {-1,0} , {0,1} , {0,-1} };
    static boolean[][] visited;


    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        while(true) {

            // BFS 루프 카운트
            int loopCnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {

                    // 바다라면 continue
                    if (map[i][j] < 1)
                        continue;

                    // 이미 방문한 빙각이라면 continue
                    if (visited[i][j])
                        continue;

                    bfs(i, j);  // 탐색
                    loopCnt++;  // BFS 루프 카운트 (2번 이상일 경우, break)
                }
            }

            // 녹여 놓은 빙산(=cloneMap)을 일괄 적용
            setCloneMap();

            // BFS 루프 카운트: 빙각이 두 덩어리 이상이라면 break
            if (loopCnt > 1)
                break;


            // 빙각이 한 덩어리인데, 모두 녹아버린 경우 break
            if (loopCnt == 1 && meltCheck()) {
                year = 0;
                break;
            }

            // 다음 연도
            year++;
        }

        // 출력
        result.append(year);
    }


    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int curX = queue.peek()[0];
            int curY = queue.peek()[1];
            queue.poll();

            for(int i=0; i<4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if (visited[nextX][nextY])
                    continue;

                if (map[nextX][nextY] > 0) {
                    queue.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                } else {
                    cloneMap[curX][curY]--;     // 빙산 녹여놓기
                }
            }
        }

    }


    // 녹여 놓은 빙산(=cloneMap)을 일괄 적용
    public static void setCloneMap() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (cloneMap[i][j] <= 0)
                    cloneMap[i][j] = 0;

                map[i][j] = cloneMap[i][j];
                visited[i][j] = false;
            }
        }
    }


    // 빙각이 모두 녹았는지 체크
    public static boolean meltCheck() {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] <= 0)
                    cnt++;
            }
        }

        if (cnt == N*M)
            return true;

        return false;
    }


    public static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cloneMap = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cloneMap[i][j] = map[i][j];
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