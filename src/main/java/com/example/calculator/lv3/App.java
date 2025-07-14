package com.example.calculator.lv3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        SmartCalculator calculator = new SmartCalculator();
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

                String patternOperator = "[+\\-*/]";
                boolean isValidOperator = Pattern.matches(patternOperator, operator);

                if(!isValidOperator) throw new IllegalArgumentException("지원하지 않는 연산자: "+ operator);

                // 결과 출력
                System.out.println("연산 결과: " + calculator.calculate(num1, num2, operator));

            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("지원하지 않는 연산자입니다. (+, -, *, /) 중 하나를 입력하세요.");
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
            }

            sc.nextLine(); // 개행 제거

            // "exit" 문자열을 입력하면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitStr = sc.nextLine();
            if (exitStr.equals("exit")) break;
        }

        // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
        System.out.println("저장된 연산 결과들: " + calculator.getCalcSaveResult());
        System.out.print("기준값 입력(입력된 값보다 큰 결과를 노출): ");
        Number inputNum = parseNumber(sc.next());
        System.out.println("입력된 값보다 큰 연산 결과 : " + calculator.getResultsAboveInput(inputNum));
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
