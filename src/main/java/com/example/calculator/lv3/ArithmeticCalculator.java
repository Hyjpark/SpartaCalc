package com.example.calculator.lv3;

public class ArithmeticCalculator  {
    public int calculate(int num1, int num2, String operator) {
        int result = 0;
        try {
            for (OperatorType op : OperatorType.values()) {
                System.out.println(op.toString().equals(operator));
                if (op.toString().equals(operator)) {
                    result = op.calc(num1, num2);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 연산자입니다.");
        }
        return result;
    }
}
