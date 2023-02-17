package org.example;

import org.example.domain.core.Calculator;
import org.example.domain.models.Arguments;
import org.example.infra.arguments.ArgumentsParser;
import org.example.infra.files.FileParser;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Arguments arguments = ArgumentsParser.parse(args);
        // System.out.println(arguments);
        List<Integer> numbers = FileParser.parse(arguments.getFileName());
        // System.out.println(numbers);
        Calculator calculator = new Calculator(arguments, numbers);
        Integer result = calculator.calculate();
        System.out.println(String.format("Total : %d", result));
    }
}
