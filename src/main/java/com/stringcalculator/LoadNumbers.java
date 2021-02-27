package com.stringcalculator;

import java.util.stream.Stream;

public class LoadNumbers implements ProcessingStep<String, Stream<Integer>> {

    private static final String DELIMITERS_REGEXP = "[,\n]";

    @Override
    public Stream<Integer> process(String input) {
        return isEmpty(input) ? Stream.of(0) : summarize(input);
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public Stream<Integer> summarize(String input) {
        return Stream.of(input.split(DELIMITERS_REGEXP))
                .map((Integer::parseInt));
    }


}
