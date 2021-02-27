package com.stringcalculator;

import com.stringcalculator.calculate.CalculateNumbers;
import com.stringcalculator.loaddata.LoadNumbers;

public class StringCalculator {
    private final LoadNumbers loadNumbers = new LoadNumbers();
    private final CalculateNumbers calculateNumbers = new CalculateNumbers();

    public Object add(String input) {
        return calculateNumbers.process(
                loadNumbers.process(input));
    }
}
