package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Calculator 인스턴스 생성
        Calculator calculator = new Calculator();

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

                // 연산을 수행하는 클래스 메서드 호출
                calculator.calculate(num1, num2, operator);

            } catch (InputMismatchException e) {
                System.out.println("정수를 입력해야 합니다.");
            }

            sc.nextLine(); // 개행 제거

            // "exit" 문자열을 입력하면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exitStr = sc.nextLine();
            if (exitStr.equals("exit")) break;
        }

        // Getter, Setter 활용
        System.out.println("저장된 연산 결과 : " + calculator.getCalcResult());

        // 가장 먼저 저장된 데이터를 삭제
        calculator.removeResult();

        System.out.println("가장 먼저 저장된 데이터를 삭제 후 : " + calculator.getCalcResult());

        List<Integer> replaceList = new ArrayList<>();
        replaceList.add(1);
        replaceList.add(2);
        replaceList.add(3);

        calculator.setCalcResult(replaceList);

        System.out.println("Setter로 바뀐 연산 결과 : " + calculator.getCalcResult());
    }
}
