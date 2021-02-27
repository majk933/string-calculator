package com.stringcalculator;

import java.util.stream.Stream;

public class LoadNumbers implements ProcessingStep<String, Stream<Integer>> {
    private static final RetrieveInputs RETRIEVE_INPUTS = new RetrieveInputs();

    @Override
    public Stream<Integer> process(String input) {
        final InputData inputData = RETRIEVE_INPUTS.retrieve(input);
        return inputData.isEmpty() ? Stream.of(0) : summarize(inputData.stream());
    }

    public Stream<Integer> summarize(Stream<String> input) {
        return input.map((Integer::parseInt));
    }


}
