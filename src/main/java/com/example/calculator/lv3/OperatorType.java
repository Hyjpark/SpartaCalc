package com.example.calculator.lv3;

// Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리
public enum OperatorType {
    PLUS("+") {
        public int calc(int num1, int num2) { return num1 + num2; }
    },
    MINUS("-") {
        public int calc(int num1, int num2) { return num1 - num2; }
    },
    MULTIPLY("*") {
        public int calc(int num1, int num2) { return num1 * num2; }
    },
    DIVIDE("/") {
        public int calc(int num1, int num2) { return num1 / num2; }
    };

    // 매핑을 위한 필드 값 추가
    private final String operator;

    // 생성자
    OperatorType(String operator) {
        this.operator = operator;
    }

    public abstract int calc(int num1, int num2);

    @Override
    public String toString() {
        return operator;
    }
}
