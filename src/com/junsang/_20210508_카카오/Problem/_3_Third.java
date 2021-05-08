package com.junsang._20210508_카카오.Problem;

import java.util.*;

public class _3_Third {

    public static void main(String[] args) {
        solution(8, 2, new String[] { "D 2","C","U 3","C","D 4","C","U 2","Z","Z" });
    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Map<String, Integer>> trashCan = new Stack();

        List<Map<String, Integer>> list = new ArrayList<>();
        for(int idx=0; idx<n; idx++) {
            Map map = new HashMap<String, Integer>();
            map.put(idx, idx);
            list.add(map);
        }


        for(int idx=0; idx< cmd.length; idx++) {

            String[] words = cmd[idx].split(" ");

            // UP & DOWN
            if (cmd[idx].length() != 1) {
                int cursorMoveCnt = Integer.parseInt(words[1]);

                // DOWN
                if (words[0].equals("D")) {

                    if (k + cursorMoveCnt >= list.size())
                        k = list.size() - 1;
                    else
                        k += cursorMoveCnt;
                }

                // UP
                else {
                    k -= cursorMoveCnt;
                }
            }

            // C & Z
            else {

                // C
                if (words[0].equals("C")) {

                    Map map = new HashMap<String, Integer>();
                    map.put(k, k);
                    trashCan.add(map);
                    list.remove(k);

                    if (k >= list.size())
                        k -= 1;
                }

                // Z
                else {
                    if (trashCan.isEmpty())
                        continue;


                    Map<String, Integer> map = trashCan.pop();
                    Iterator<String> keys = map.keySet().iterator();
                    while( keys.hasNext() ){
                        String key = String.valueOf(keys.next());

                        Integer any = (Integer)map.get(Integer.valueOf(key));
                        int pushIdx = any.intValue();

                        list.add(pushIdx, map);

                        if (k >= pushIdx)
                            k += 1;
                    }
                }
            }
        }

        int[] arr = new int[n];



        for(int idx=0; idx<list.size(); idx++) {
            Map<String, Integer> resultMap = list.get(idx);
            Iterator<String> keys = resultMap.keySet().iterator();
            while( keys.hasNext() ){
                String key = String.valueOf(keys.next());
                Integer any = (Integer)resultMap.get(Integer.valueOf(key));
                int pushIdx = any.intValue();

                arr[pushIdx]++;
            }
        }


        for(int idx=0; idx<n; idx++) {
            System.out.print(arr[idx]);
        }

        return answer;
    }
}
