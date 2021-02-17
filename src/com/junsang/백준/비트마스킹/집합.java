package com.junsang.백준.비트마스킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합 {

    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // 출력을 위한 객체
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int loopCnt = Integer.parseInt(br.readLine());
        int bitMask =0;

        while (loopCnt-- > 0) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            if (op.contains("add")) {
                int num = Integer.parseInt(st.nextToken());
                bitMask = bitMask | 1<<(num-1);
            }

            else if(op.contains("remove")) {
                int num = Integer.parseInt(st.nextToken());
                bitMask = bitMask & ~(1<<(num-1));
            }

            else if(op.contains("check")) {
                int num = Integer.parseInt(st.nextToken());
                result.append(((bitMask & 1<<(num-1)) == 1<<(num-1) ? 1:0)+"\n");
            }

            else if(op.contains("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                bitMask = bitMask ^ 1<<(num-1);
            }

            else if(op.contains("all")) {
                bitMask = ~0;
            }

            else if(op.contains("empty")) {
                bitMask = 0;
            }
        }
        bw.write(result.toString()); // 출력 가능한 String 형태로 변환

        bw.flush();         // 성능을 위해 buffer 에 저장, flush 되거나 close 되었을 때 한번에 출력
//        bw.newLine();     // 줄바꿈이 필요할 경우 사용합니다.
        bw.close();         // 버퍼 닫기
        br.close();
    }
}
