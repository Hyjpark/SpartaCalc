package com.example.calculator.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // 양의 정수(0 포함)를 입력 받기
                System.out.print("첫 번째 숫자를 입력하세요: ");
                Number num1 = parseNumber(sc.next());

                System.out.print("두 번째 숫자를 입력하세요: ");
                Number num2 = parseNumber(sc.next());

                // 사칙연산 기호(+, -, *, /)를 입력 받기
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = sc.next();

                System.out.println(num1 + " " + operator + " " + num2);

                boolean isDouble = (num1 instanceof Double || num2 instanceof Double);
                boolean isDivide = operator.equals("/"); // double 연산이 될 수 있는 나눗셈 연산 체크

                // 연산을 수행하는 클래스 메서드 호출
                if (isDouble || isDivide) {
                    ArithmeticCalculator aritCalc = new ArithmeticCalculator<>(Double.class);
                    aritCalc.calculate(num1, num2, operator);
                } else {
                    ArithmeticCalculator aritCalc = new ArithmeticCalculator<>(Integer.class);
                    aritCalc.calculate(num1, num2, operator);
                }

            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해야 합니다.");
            }

            sc.nextLine(); // 개행 제거

            // "exit" 문자열을 입력하면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitStr = sc.nextLine();
            if (exitStr.equals("exit")) break;
        }
    }

    public static Number parseNumber(String input) {
        // 입력 문자열에 소수점이나 지수 표기가 있으면 실수로 판단
        if (input.contains(".")) {
            return Double.parseDouble(input);
        } else {
            // 정수 범위 내라면 Integer
            return Integer.parseInt(input);
        }
    }
}
