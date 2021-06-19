package com.junsang._20210605_야놀자.Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Task 4
 * 동일한 길이의 N 세그먼트로 구성된 각 레인을 각각 1차선과 2차선을 나타내는 L1 및 L2의 두 문자열이 있는 2차선 도로에 대한 설명을 제공합니다.
 *
 * 1차선의 K-th 세그먼트는 L1[K]로, 2차선의 K-th 세그먼트는 L2[K]로 나타내며,
 * '.' 은 부드러운 도로 구간
 * 'x' 는 구멍
 *
 * 차는 구멍 난 부분 위를 운전할 수 있지만, 오히려 불편하다. 따라서, 가능한 한 많은 구멍들을 수리하는 프로젝트가 제출되었습니다.
 *
 * 한 번에 한 차선의 연속적 확장을 수리할 수 있다.
 * 보상 기간 동안 그 연장선들은 차량 통행이 금지될 것이다.
 * 도로를 개방 상태로 유지해야 하는 경우(즉, 도로의 연장 때문에 도로 한쪽 끝에서 다른 쪽 끝까지 이동하지 않아야 하는 경우) 얼마나 많은 도로 구덩이를 수리할 수 있습니까?
 *
 * 함수 작성
 *  public int solution(String L1, String L2) { }
 *
 * 길이가 N인 두 개의 문자열 L1 및 L2 주어진 경우, 복구할 수 있는 홀이 있는 세그먼트의 최대 수를 반환
 *
 */
public class _4_First {

    //===
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder result = new StringBuilder();
    //===


    static int N;
    static int[][] dir = { {1,0} , {-1,0} , {0,1} };       // 남 북 동

    static int[][] map;
    static boolean[][] visited;
    static int siz;

    public static void main(String[] args) throws Exception{


        solution("..xx.x.", "x.x.x..");

        output();
    }


    public static int solution(String L1, String L2) {

        String[] L1Words = L1.split("");
        String[] L2Words = L2.split("");

        siz = L1.length();


        map = new int[2][L1.length()];
        visited = new boolean[2][L2.length()];

        for(int i=0; i<L1.length(); i++) {
            if (".".equals(L1Words[i]))
                map[0][i] = 0;
            else
                map[0][i] = 1;

            visited[0][i] = false;
        }

        for(int i=0; i<L2.length(); i++) {
            if (".".equals(L2Words[i]))
                map[1][i] = 0;
            else
                map[1][i] = 1;

            visited[1][i] = false;
        }

        //================================================

        bfs(0, 0);      // 탐색


        System.out.println("");




        return 1;
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

                if (nextX < 0 || nextY < 0 || nextX >= siz || nextY >= siz)
                    continue;

                if (map[nextX][nextY] == 1) {
                    int nextNextX = nextX + dir[i][0];
                    int nextNextY = nextY + dir[i][1];

                    if (nextNextX < 0 || nextNextY < 0 || nextNextX >= siz || nextNextY >= siz)
                        continue;

                    if (map[nextNextX][nextNextY] == 1)
                        continue;
                }

                if (visited[nextX][nextY])
                    continue;

                que.add(new int[]{nextX,nextY});
                visited[nextX][nextY] = true;
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
