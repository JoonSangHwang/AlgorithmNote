package com.junsang.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 오타맨_고창영 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int siz = Integer.parseInt(br.readLine());
            for(int i=0; i<siz; i++) {
                String[] str = br.readLine().split(" ");
                String[] strSplit = str[1].split("");
                for(int j=0; j<str[1].length(); j++) {
                    if (Integer.parseInt(str[0]) != (j+1) {
                        System.out.print(strSplit[j]);
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}