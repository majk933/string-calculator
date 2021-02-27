package com.stringcalculator;

import java.util.stream.Stream;

public class StringCalculator {
    private static final String DELIMITERS_REGEXP = "[,\n]";

    public int add(String input) {
        return isEmpty(input) ? 0 : summarize(input);

    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public int summarize(String input) {
        return Stream.of(input.split(DELIMITERS_REGEXP))
                .map((Integer::parseInt))
                .reduce(0, Integer::sum);
    }
}
