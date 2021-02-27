package com.stringcalculator;

import java.util.stream.Stream;

class CalculateNumbers implements ProcessingStep<Stream<Integer>, Integer> {

    @Override
    public Integer process(Stream<Integer> stream) {
        return stream.reduce(0, Integer::sum);
    }
}
