package com.stringcalculator.loaddata;

import java.util.stream.Stream;

class RetrieveDelimiters {
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";
    private static final String DELIMITER = "]\\[";

    static final String LINE_PREFIX = "//";
    static final String DEFAULT = ",|\n";

    String from(String input) {
        String delimiterInput = input.replace(LINE_PREFIX, "");
        validateInput(delimiterInput);
        return asRegExp(delimitersFrom(delimiterInput));
    }

    private String asRegExp(String[] delimiters) {
        return Stream.of(delimiters)
                .reduce("\n", (s, s2) -> s + "|" + s2);
    }

    private String[] delimitersFrom(String delimiterInput) {
        return delimiterInput
                .substring(1, delimiterInput.length() - 1)
                .split(DELIMITER);
    }

    private void validateInput(String delimiterInput) {
        if (!isValid(delimiterInput)) {
            throw new DelimiterInputNotValid(delimiterInput);
        }
    }

    private boolean isValid(String delimiterInput) {
        return delimiterInput.startsWith(PREFIX)
                && delimiterInput.endsWith(POSTFIX);
    }
}
