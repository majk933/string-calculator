package com.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

class CalculateNumbers implements ProcessingStep<List<Integer>, Integer> {

    @Override
    public Integer process(List<Integer> list) {
        validateIfPositives(list);
        return list.stream().reduce(0, Integer::sum);
    }

    private void validateIfPositives(List<Integer> stream) {
        List<Integer> negatives = negatives(stream);
        if (!negatives.isEmpty()) {
            throw new NegativesNotAllowed(negatives);
        }
    }

    private List<Integer> negatives(List<Integer> list) {
        return list.stream()
                .filter(integer -> integer < 0)
                .collect(Collectors.toList());
    }
}
