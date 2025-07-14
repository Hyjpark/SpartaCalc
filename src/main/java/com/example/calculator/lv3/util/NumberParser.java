package com.example.calculator.lv3.util;

public class NumberParser {
    public static Number parse(String input) {
        // 입력 문자열에 소수점이나 지수 표기가 있으면 실수로 판단
        if (input.contains(".")) {
            return Double.parseDouble(input);
        } else {
            // 정수 범위 내라면 Integer
            return Integer.parseInt(input);
        }
    }
}
