package com.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoadNumbers implements ProcessingStep<String, List<Integer>> {
    private static final RetrieveInputs RETRIEVE_INPUTS = new RetrieveInputs();

    @Override
    public List<Integer> process(String input) {
        final InputData inputData = RETRIEVE_INPUTS.retrieve(input);
        return inputData.isEmpty() ? List.of(0) : numbers(inputData.stream());
    }

    public List<Integer> numbers(Stream<String> input) {
        return input.map((Integer::parseInt))
                .collect(Collectors.toList());
    }


}
