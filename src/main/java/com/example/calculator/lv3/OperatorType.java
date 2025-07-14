package com.example.calculator.lv3;

// 람다식 구현을 위한 함수형 인터페이스 활용
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리
public enum OperatorType {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-",  (num1, num2) -> num1 - num2),
    MULTIPLY("*",  (num1, num2) -> num1 * num2),
    DIVIDE("/",  (num1, num2) -> {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException();
        }
    });

    // 매핑을 위한 필드 값 추가
    private final String operator;
    private final BiFunction<Double, Double, Double> operation;

    private static final Map<String, OperatorType> OPERATOR_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(OperatorType::getOperator, Function.identity())));

    // 생성자
    OperatorType(String operator, BiFunction<Double, Double, Double> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static OperatorType findOperator(String symbol) {
        return Optional.ofNullable(OPERATOR_MAP.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException("연산자를 찾을 수 없습니다."));
    }

    // 매개변수로 받은 타입 상관 없이 더블로 반환
    public Double calc(Number num1, Number num2) {
        return operation.apply(num1.doubleValue(), num2.doubleValue());
    };

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return operator;
    }
}
