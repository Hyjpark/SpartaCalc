package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmartCalculator {
    private final ArithmeticCalculator iniCalc = new ArithmeticCalculator<>(Integer.class);
    private final ArithmeticCalculator doubleCalc = new ArithmeticCalculator<>(Double.class);

    public Number calculate(Number num1, Number num2, String operator) {
        return selectCalculator(num1, num2, operator).execute(num1, num2, operator);
    }

    private ArithmeticCalculator<? extends Number> selectCalculator(Number num1, Number num2, String operator) {
        boolean isDouble = (num1 instanceof Double || num2 instanceof Double);
        boolean isDivide = operator.equals("/");// double 연산이 될 수 있는 나눗셈 연산 체크

        if (isDouble ||  isDivide) {
            return doubleCalc;
        } else {
            return iniCalc;
        }
    }

    public List<Number> getCalcSaveResult() {
        List<Number> calcSaveResult = new ArrayList<>();
        calcSaveResult.addAll(iniCalc.getSaveResult());
        calcSaveResult.addAll(doubleCalc.getSaveResult());

        return calcSaveResult;
    }

    public List<Number> getResultsAboveInput(Number input) {
        double num = input.doubleValue();
        return getCalcSaveResult().stream()
                .filter(r -> r.doubleValue() > num)
                .collect(Collectors.toList());
    }

}
