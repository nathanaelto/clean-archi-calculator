package org.example.domain.core;

import org.example.domain.models.Operator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculatorLogger {
    static SimpleDateFormat formatter = new SimpleDateFormat("hhmmss:SSSSSS");
    private static String getCurrentTime() {
        return CalculatorLogger.formatter.format(new Date());
    }
    private static String log(String message) {
        return String.format("[%s][log] %s", getCurrentTime(), message);
    }
    public static void logStart() {
        String log = log("started");
        System.out.println(log);
    }

    public static void logOperation(Operator operator) {
        String log;
        switch (operator) {
            case ADDITION:
                log = log("applying operation addition");
                break;
            case SUBTRACTION:
                log = log("applying operation subtraction");
                break;
            case MULTIPLICATION:
                log = log("applying operation multiplication");
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
        System.out.println(log);
    }

    public static void logNumber(Integer number) {
        String log = log(String.format("parsed value = %d", number));
        System.out.println(log);
    }

    public static void logEnd() {
        System.out.println("---------------");
    }
}
