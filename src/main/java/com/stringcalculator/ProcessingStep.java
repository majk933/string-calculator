package com.stringcalculator;

public interface ProcessingStep<Input, Output> {
    Output process(Input input);
}
