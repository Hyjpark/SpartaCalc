package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드
    private List<Integer> calcResult = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        int result = 0;

        try {
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            System.out.println("결과: " + result);

            // 연산 결과 필드에 저장
            calcResult.add(result);

        } catch (ArithmeticException e) {
            System.out.println("나눗셈 연산에서 분모(두번재 정수)에 0이 입력될 수 없습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 연산자입니다.");
        }

        return result;
    }

    public void removeResult() {
        int firstResult = calcResult.get(0);
        
        calcResult.remove(Integer.valueOf(firstResult));
    }

    // Getter 메서드 구현
    public List<Integer> getCalcResult() {
        return calcResult;
    }

    // Setter 메서드 구현
    public void setCalcResult(List<Integer> calcResult) {
        this.calcResult = calcResult;
    }
}
