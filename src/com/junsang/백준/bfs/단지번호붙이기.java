package com.junsang.백준.bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2021.03.29
 * @DESC       : 단지번호붙이기
 * @see        : https://www.acmicpc.net/problem/2667
 */
public class 단지번호붙이기 {
    //===
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));;
    static StringBuilder result = new StringBuilder();
    static StringTokenizer st;
    //===

    static int N;
    static int[][] map;
    static int[][] dir = { {1,0} , {-1,0} , {0,1} , {0,-1} };
    static boolean[][] visited;

    static int danjiNum;
    static int[] danji = new int[25*25];

    public static void main(String[] args) throws Exception {
        input();

        solution();

        output();
    }

    public static void solution() throws Exception {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 집이 있는지 체크
                if (map[i][j] != 1)
                    continue;

                // 방문한 적이 없는지 체크
                if (visited[i][j])
                    continue;

                // 깊이 탐색
                bfs(i,j);
                danjiNum++;
            }
        }

        // 정렬
        Arrays.sort(danji);

        // 출력
        result.append(danjiNum +"\n");
        for(int i=0; i<danji.length; i++){
            if (danji[i] != 0)
                result.append(danji[i] + "\n");
        }
    }


    public static void bfs(int x, int y) {
        visited[x][y] = true;       // 방문 체크
        danji[danjiNum]++;          // 단지 번호 붙이기

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});

        while(!que.isEmpty()){
            int curX = que.peek()[0];
            int curY = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++){
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;

                if (map[nextX][nextY] != 1)
                    continue;

                if (visited[nextX][nextY])
                    continue;

                que.add(new int[]{nextX,nextY});
                visited[nextX][nextY] = true;
                danji[danjiNum]++;
            }
        }
    }


    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        visited = new boolean[N][N];
    }

    public static void output() throws Exception {
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}