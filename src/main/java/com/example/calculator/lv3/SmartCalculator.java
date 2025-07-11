package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;

public class SmartCalculator {
    private final ArithmeticCalculator iniCalc = new ArithmeticCalculator<>(Integer.class);
    private final ArithmeticCalculator doubleCalc = new ArithmeticCalculator<>(Double.class);

    public void calculate(Number num1, Number num2, String operator) {
        boolean isDouble = (num1 instanceof Double || num2 instanceof Double);
        boolean isDivide = operator.equals("/");// double 연산이 될 수 있는 나눗셈 연산 체크

        // 연산을 수행하는 클래스 메서드 호출
        if (isDouble || isDivide) {
            doubleCalc.execute(num1, num2, operator);
        } else {
            iniCalc.execute(num1, num2, operator);
        }
    }

    public List<Number> getCalcSaveResult() {
        List<Number> calcSaveResult = new ArrayList<>();
        calcSaveResult.addAll(iniCalc.getSaveResult());
        calcSaveResult.addAll(doubleCalc.getSaveResult());

        return calcSaveResult;
    }

}
