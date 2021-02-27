package com.stringcalculator.calculate;

import java.util.Arrays;
import java.util.Collection;

class NegativesNotAllowed extends RuntimeException {
    static final long serialVersionUID = 8868670203128958771L;

    NegativesNotAllowed(Collection<Integer> negatives) {
        super(String.format("Negatives %s not allowed", Arrays.toString(negatives.toArray())));
    }
}
