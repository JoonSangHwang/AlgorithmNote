package com.junsang._20210605_야놀자.Problem;

import org.junit.Assert;
import org.junit.Test;

/**

 아래 모든 요건을 포함하는 JUNIT 4 프레임워크를 사용하여 인버터 클래스의 반전 방법에 대한 일련의 테스트를 제공하는 것이 과제이다.

 invert 메서드는 문자열을 수락하고 문자열을 반환합니다.
 · 문자열이 비어 있으면 빈 문자열을 반환합니다.
 · 메소드에 전달된 인수가 null이면 빈 문자열을 반환합니다.
 · 문자열에 정확히 한 문자가 있으면 동일한 문자열이 반환됩니다. 문자열이 더 길면 반전된 버전이 반환됩니다.

 요건
 · 위에서 설명한 대로 인버터 방법의 가능한 모든 동작을 테스트하는 JUNIT 4에서 테스트 세트를 구현하는 것입니다.
 · 인버트 메서드의 여러 (잘못되고 올바른) 구현에 대해 테스트 집합이 실행됩니다.
 · 모든 테스트는 올바른 구현을 위해 통과해야 합니다. 그렇지 않으면 0%가 수신되므로 작업을 제출하기 전에 모든 테스트가 올바른 테스트에 통과하는지 확인하십시오.
 · 반전 방법의 잘못된 구현의 경우, 하나 이상의 시험 케이스가 실패해야 한다.
 · 주장의 경우, org.junit에서 제공하는 정적 방법을 사용한다.클래스 주장, 즉 동등 주장, Not Equal 주장 등.

 */
public class _2_First {

    /**
     * 만약 빈 문자열이 들어올 경우
     *
     * @return 빈 문자열 반환
     */
    @Test
    public void ifEmptyStr() {
        String inputStr = "";

        try {
            String inverted = Inverter.invert(inputStr);
            Assert.assertEquals("", inverted);
        }  catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * 만약 null 이 들어올 경우
     *
     * @return 빈 문자열 반환
     */
    @Test
    public void ifNull() {
        String inputStr = null;

        try {
            String inverted = Inverter.invert(inputStr);
            Assert.assertEquals("", inverted);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * 만약 입력 문자열이 1글자라면
     *
     * @return 문자열 그대로 반환
     */
    @Test
    public void ifOneCharStr() {
        String inputStr = "a";

        try {
            String inverted = Inverter.invert(inputStr);

            int StrLeng = inputStr.length();
            if (StrLeng == 1)
                Assert.assertEquals(inputStr, inverted);

        } catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * 만약 입력 문자열이 2글자 이상이라면
     *
     * @return 반전 문자열 반환
     */
    @Test
    public void strInvertCheck() {
        String inputStr = "abcd";

        try {
            String inverted = Inverter.invert(inputStr);
            int strLeng = inputStr.length();
            if (strLeng > 1) {

                // 문자열 반전
                StringBuffer sb = new StringBuffer(inputStr);
                String reversedStr = sb.reverse().toString();

                Assert.assertEquals(reversedStr, inverted);
            }

        } catch (Exception e) {
            Assert.fail();
        }
    }

}

class Inverter {

    public static String invert(String inputStr) {
        return inputStr;
    }
}
