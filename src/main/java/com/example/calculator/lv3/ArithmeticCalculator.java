package com.example.calculator.lv3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    public final Class<T> numType;
    private List<T> saveResult = new ArrayList<>();

    public ArithmeticCalculator(Class<T> numType) {
        this.numType = numType;
    }

    public <S extends Number> T execute(S num1, S num2, String operator) {
        T result = null;
        try {
            for (OperatorType op : OperatorType.values()) {
                if (op.toString().equals(operator)) {
                    Double tempResult = op.calc(num1, num2);
                    result = castResult(tempResult);
                    saveResult.add(result);
                }
            }

            System.out.println("결과 : " + result);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }

        return result;
    }

    private T castResult(Double result) {
        if (numType == Integer.class) {
            return numType.cast(result.intValue());
        } else if (numType == Double.class) {
            return numType.cast(result);
        }
        return numType.cast(result);
    }

    public List<T> getSaveResult() {
        return saveResult;
    }
}
