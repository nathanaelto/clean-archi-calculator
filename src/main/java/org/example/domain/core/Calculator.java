package org.example.domain.core;

import org.example.domain.models.Arguments;

import java.util.List;

public class Calculator {
    final Arguments arguments;
    final List<Integer> numbers;

    public Calculator(Arguments arguments, List<Integer> numbers) {
        this.arguments = arguments;
        this.numbers = numbers;
    }

    public Integer calculate() {
        Integer accumulator = 0;
        boolean first = true;
        if (arguments.isWithLog()) {
            CalculatorLogger.logStart();
            CalculatorLogger.logOperation(arguments.getOperation());
        }
        for (Integer number : numbers) {
            if (arguments.isWithLog()) {
                CalculatorLogger.logNumber(number);
            }
            switch (arguments.getOperation()) {
                case ADDITION:
                    accumulator = doAdd(accumulator, number);
                    break;
                case SUBTRACTION:
                    accumulator = doSubtraction(accumulator, number);
                    break;
                case MULTIPLICATION:
                    accumulator = doMultiply(accumulator, number);
                    break;
                default:
                    throw new RuntimeException("Invalid operation");
            }
            defaultLog(accumulator, number, first);
            if (first) first = false;
        }

        CalculatorLogger.logEnd();
        return accumulator;
    }

    public Integer doAdd(Integer accumulator, Integer number) {
        return accumulator + number;
    }

    public Integer doSubtraction(Integer accumulator, Integer number) {
        return accumulator - number;
    }

    public Integer doMultiply(Integer accumulator, Integer number) {
        return accumulator * number;
    }

    public void defaultLog(Integer accumulator, Integer number, boolean isFist) {
        if (isFist) {
            System.out.println(accumulator);
            return;
        }
        switch (arguments.getOperation()) {
            case ADDITION:
                System.out.println(String.format("+%s (=%s)", number, accumulator));
                break;
            case SUBTRACTION:
                System.out.println(String.format("-%s (=%s)", number, accumulator));
                break;
            case MULTIPLICATION:
                System.out.println(String.format("*%s (=%s)", number, accumulator));
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
