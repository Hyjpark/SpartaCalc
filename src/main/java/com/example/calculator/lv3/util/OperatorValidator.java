package com.example.calculator.lv3.util;

import java.util.regex.Pattern;

public class OperatorValidator {
    public static final String OPERATOR_PATTERN = "[+\\-*/]";

    public static void isValidOperator(String operator) {
        boolean isValid = Pattern.matches(OPERATOR_PATTERN, operator);
        if (isValid) throw new IllegalArgumentException("지원하지 않는 연산자: "+ operator);
    }
}
