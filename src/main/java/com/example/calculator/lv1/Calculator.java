package com.example.calculator.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 양의 정수(0 포함)를 입력 받기
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();

        // 사칙연산 기호(+, -, *, /)를 입력 받기
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0);

        // 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
        int result = 0;

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
            case  '/':
                result = num1 / num2;
                break;
        }

        System.out.println("결과: " + result);
    }
}
