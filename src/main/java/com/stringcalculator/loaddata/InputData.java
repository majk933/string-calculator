package com.stringcalculator.loaddata;

import java.util.stream.Stream;

class InputData {
    private final String delimiter;
    private final String input;

    InputData(String delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    Stream<String> stream() {
        return Stream.of(input.split(delimiter));
    }

    boolean isEmpty() {
        return input.isEmpty();
    }
}
