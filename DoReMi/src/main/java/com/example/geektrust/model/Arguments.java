package com.example.geektrust.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vishal Malviya
 */
@RequiredArgsConstructor
@Getter
public class Arguments {
    @NonNull
    private Operator operator;
    @NonNull
    private List<String> operands;

    public static Arguments from(String str) {
        try {
            String[] argumentsList = str.split(" ");
            Operator operator = Operator.valueOf(argumentsList[0]);
            List<String> operands = Arrays.stream(argumentsList).skip(1).collect(Collectors.toList());
            Arguments arguments = new Arguments(operator, operands);
            arguments.operandValidator();
            return arguments;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Invalid Command : " + str);
        }
    }

    public void operandValidator() {
        if (this.operator.getNumberOfArguments() != operands.size()) {
            throw new InputMismatchException("Wrong number of arguments.");
        }
    }
}
