package com.stringcalculator;

import java.util.stream.Stream;

class RetrieveInputs {
    private static final String DEFAULT_DELIMITER = "[,\n]";

    public InputData retrieve(String input) {
        String firstLine = input.split("\n")[0];
        if (firstLine.startsWith("//")) {
            return new InputData(firstLine.replace("//", ""), input.substring(input.indexOf("\n") + 1));
        }
        return new InputData(DEFAULT_DELIMITER, input);
    }
}

class InputData {
    private final String delimiter;
    private final String input;

    public InputData(String delimiter, String input) {
        this.delimiter = delimiter;
        this.input = input;
    }

    public Stream<String> stream() {
        return Stream.of(input.split(delimiter));
    }


    public boolean isEmpty() {
        return input.isEmpty();
    }
}