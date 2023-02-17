package org.example.infra.arguments;

import org.example.domain.models.Arguments;
import org.example.domain.models.Operator;

import java.util.Arrays;

public class ArgumentsParser {

    public static Arguments parse(String[] args) {
        return new ArgumentsParser().parseArguments(args);
    }

    public Arguments parseArguments(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("No arguments provided");
        }

        String fileNames = args[0];
        Operator operation = this.parseOperation(args[1]);
        if (args.length == 3) {
            boolean withLog = this.parseWithLog(args[2]);
            return new Arguments(operation, fileNames, withLog);
        } else {
            return new Arguments(operation, fileNames, false);
        }
    }

    public Operator parseOperation(String operation) {
        switch (operation) {
            case "+":
                return Operator.ADDITION;
            case "-":
                return Operator.SUBTRACTION;
            case "*":
                return Operator.MULTIPLICATION;
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

    public boolean parseWithLog(String withLog) {
        if (withLog.equals("-log")) {
            return true;
        } else {
            throw new RuntimeException("Invalid withLog");
        }
    }
}
