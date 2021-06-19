package com.junsang._20210619_요기요.Problem;


import java.util.ArrayList;
import java.util.List;

public class _2_ {


    public static void main(String[] args) {
        String a =  "admin  -wx 29 Sep 1983        833 source.h\n" +
                    "admin  r-x 23 Jun 2003     854016 blockbuster.mpeg\n" +
                    "admin  --x 02 Jul 1997        821 delete-this.py\n" +
                    "admin  -w- 15 Feb 1971      23552 library.dll\n" +
                    "admin  --x 15 May 1979  645922816 logs.zip\n" +
                    "jane   --x 04 Dec 2010      93184 old-photos.rar\n" +
                    "jane   -w- 08 Feb 1982  681574400 important.java\n" +
                    "admin  rwx 26 Dec 1952   14680064 to-do-list.txt";

        solution(a);
    }


    public static String solution(String S) {
        String[] fileInfo = S.split("\n");

        // 탭을 띄어쓰기로 변경
        List<String> transFileInfo = new ArrayList<>();
        for(int i=0; i< fileInfo.length; i++) {
            String[] curFileInfo = fileInfo[i].split(" ");
            String transStr = "";
            for(int j=0; j<curFileInfo.length; j++) {
                if (!curFileInfo[j].trim().isEmpty())
                    transStr += curFileInfo[j] + " ";
            }

            transFileInfo.add(transStr);
        }

        List<String> passFile = new ArrayList<>();
        for(int i=0; i< transFileInfo.size(); i++) {
            String[] curFileInfo = transFileInfo.get(i).split(" ");

            // 작성자 admin
            if (!"admin".equals(curFileInfo[0]))
                continue;

            // x(실행) 권한
            if (!curFileInfo[1].contains("x"))
                continue;

            // 파일 크기 14200 미만
            if (Integer.parseInt(curFileInfo[5]) >= 14200)
                continue;

            passFile.add(transFileInfo.get(i));
        }

        // 가장 빠른 마지막 수정 날짜
        String minDate = "30000909";
        String ret = "";
        for(int i=0; i< passFile.size(); i++) {
            String[] curFileInfo = passFile.get(i).split(" ");

            String curDate = curFileInfo[4];
            String transDate = "";
            if ("jan".equals(curFileInfo[3]))
                transDate = "01";
            else if ("Feb".equals(curFileInfo[3]))
                transDate = "02";
            else if ("Mar".equals(curFileInfo[3]))
                transDate = "03";
            else if ("Apr".equals(curFileInfo[3]))
                transDate = "04";
            else if ("May".equals(curFileInfo[3]))
                transDate = "05";
            else if ("Jun".equals(curFileInfo[3]))
                transDate = "06";
            else if ("Jul".equals(curFileInfo[3]))
                transDate = "07";
            else if ("Aug".equals(curFileInfo[3]))
                transDate = "08";
            else if ("Sep".equals(curFileInfo[3]))
                transDate = "09";
            else if ("Oct".equals(curFileInfo[3]))
                transDate = "10";
            else if ("Nov".equals(curFileInfo[3]))
                transDate = "11";
            else if ("Dec".equals(curFileInfo[3]))
                transDate = "12";

            curDate += transDate;
            curDate += curFileInfo[2];

            if (Integer.parseInt(minDate) > Integer.parseInt(curDate)) {
                minDate = curDate;
                ret = curFileInfo[2] + " " + curFileInfo[3] + " " + curFileInfo[4];
            }
        }

        System.out.printf("ret");
        return "";
    }
}
