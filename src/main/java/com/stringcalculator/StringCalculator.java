package com.stringcalculator;

import java.util.stream.Stream;

public class StringCalculator {
    private static final String DELIMITER = ",";

    public int add(String input) {
        return isEmpty(input) ? 0 : summarize(input);

    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public int summarize(String input) {
        return Stream.of(input.split(DELIMITER))
                .limit(3)
                .map((Integer::parseInt))
                .reduce(0, Integer::sum);
    }
}
