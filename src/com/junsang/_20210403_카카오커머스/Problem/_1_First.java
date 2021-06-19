package com.junsang._20210403_카카오커머스.Problem;

import java.util.ArrayList;
import java.util.List;

public class _1_First {

    public static void main(String[] args) {
        solution(new int[]{4, 5, 3, 2, 1}, new int[]{2, 4, 4, 5, 1});
    }


    public static int solution(int[] gift_cards, int[] wants) {

        List people = new ArrayList();
        List card = new ArrayList();

        // 리스트 초기화
        listInit(people, card, gift_cards, wants);

        // 로직 수행
        boolean breakFlag = false;
        while(true) {

            // 같은게 있는지 체크 후, 삭제
            sameValueRemove(people, card);

            // 선호하는 상품 위치로 바꿔주기
            breakFlag = swap(people, card);

            // 조건에 만족할 경우 break
            if (breakFlag) break;
        }

        // 원하는 상품을 받지 못하는 사람수
        return people.size();
    }

    // 리스트 초기화
    private static void listInit(List people, List card, int[] gift_cards, int[] wants) {
        for(int i=0; i<gift_cards.length; i++) {
            people.add(gift_cards[i]);
            card.add(wants[i]);
        }
    }


    // 같은게 있는지 체크 후, 삭제
    private static void sameValueRemove(List people, List card) {
        for(int i=0; i<people.size(); i++) {
            if (people.get(i) == card.get(i)) {
                people.remove(i);
                card.remove(i);
            }
        }
    }


    // 선호하는 상품 위치로 바꿔주기
    private static boolean swap(List people, List card) {
        for(int i=0; i<people.size(); i++) {
            for(int j=0; j<people.size(); j++) {
                if (people.get(i) == card.get(j)) {
                    people.set(i, people.get(j));
                    people.set(j, card.get(j));
                    return false;
                }
            }
        }

        return true;
    }



}
