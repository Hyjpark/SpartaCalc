package com.example.calculator.lv3;

public class ArithmeticCalculator<T extends Number> {
    private T result;
    
    public <S extends Number> T calculate(S num1, S num2, String operator) {
        try {
            for (OperatorType op : OperatorType.values()) {
                if (op.toString().equals(operator)) {
                    Double tempResult = op.calc(num1, num2);
                    this.result = (T) tempResult;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 연산자입니다.");
        }

        System.out.println("this.result = " + this.result);
        
        return this.result;
    }
}
