package com.example.calculator.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
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
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

                System.out.println("결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번재 정수)에 0이 입력될 수 없습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 연산자입니다.");
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
