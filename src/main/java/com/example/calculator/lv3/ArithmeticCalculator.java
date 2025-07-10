package com.example.calculator.lv3;

public class ArithmeticCalculator<T extends Number> {
    public final Class<T> numType;
    private T result;

    public ArithmeticCalculator(Class<T> numType) {
        this.numType = numType;
    }

    public <S extends Number> T calculate(S num1, S num2, String operator) {
        try {
            for (OperatorType op : OperatorType.values()) {
                if (op.toString().equals(operator)) {
                    Double tempResult = op.calc(num1, num2);
                    this.result = castResult(tempResult);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 연산자입니다.");
        }

        System.out.println("결과 = " + result);
        
        return this.result;
    }

    private T castResult(Double result) {
        if (numType == Integer.class) {
            return numType.cast(result.intValue());
        } else if (numType == Double.class) {
            return numType.cast(result);
        }
        return numType.cast(result);
    }
}
