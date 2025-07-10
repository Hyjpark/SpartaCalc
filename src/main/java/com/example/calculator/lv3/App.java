package com.example.calculator.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator aritCalc = new ArithmeticCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // 양의 정수(0 포함)를 입력 받기
                System.out.print("첫 번째 숫자를 입력하세요: ");
                Number num1 = sc.nextInt();

                System.out.print("두 번째 숫자를 입력하세요: ");
                Number num2 = sc.nextInt();

                // 사칙연산 기호(+, -, *, /)를 입력 받기
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = sc.next();

                // 연산을 수행하는 클래스 메서드 호출
                aritCalc.calculate(num1, num2, operator);

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
}
