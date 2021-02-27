package com.stringcalculator.loaddata;

class RetrieveInputs {
    private final RetrieveDelimiters delimiters = new RetrieveDelimiters();

    InputData retrieve(String input) {
        String firstLine = input.split("\n")[0];
        if (firstLine.startsWith(RetrieveDelimiters.LINE_PREFIX)) {
            return new InputData(delimiters.from(firstLine), dataWithoutDelimiter(input));
        }
        return new InputData(RetrieveDelimiters.DEFAULT, input);
    }

    private String dataWithoutDelimiter(String input) {
        return input.substring(input.indexOf("\n") + 1);
    }

}

