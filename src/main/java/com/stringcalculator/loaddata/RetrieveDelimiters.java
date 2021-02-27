package com.stringcalculator.loaddata;

class RetrieveDelimiters {
    private static final String DEFAULT_DELIMITER = ",|\n";

    String from(String firstLine) {
        return String.format("%s|\n", firstLine.replace("//", ""));
    }

    String defaultDelimiter() {
        return DEFAULT_DELIMITER;
    }
}
