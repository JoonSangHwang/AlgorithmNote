package com.junsang.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author     : junsang Hwang
 * @Date       : 2020.10.18
 * @DESC       : FBI
 * @see        : https://www.acmicpc.net/problem/2857
 */
public class FBI {

    static String[]         agents = new String[5];             // Input
    static List<Integer>    answer = new ArrayList<Integer>();  // Output

    public static void main(String[] args) throws IOException {

        input();

        for (int i = 0; i < agents.length; i++) {
            String[] strArray = agents[i].split("");
            for (int j = 0; j < strArray.length; j++) {
                if (strArray[j].equals("F")) {
                    if (strArray[j + 1].equals("B")) {
                        if (strArray[j + 2].equals("I")) {
                            answer.add(i);
                            break;
                        }
                    }
                }
            }
        }

        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fbi = st.nextToken();
            agents[i] = fbi;
        }
    }

    public static void output() {
        if (answer.isEmpty()) {
            System.out.print("HE GOT AWAY!");
        } else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i)+1);

                if (!(i == answer.size()-1)) {
                    System.out.print(" ");
                }
            }
        }
    }
}

