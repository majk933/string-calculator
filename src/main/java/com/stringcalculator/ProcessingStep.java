package com.stringcalculator;

interface ProcessingStep<Input, Output> {
    Output process(Input input);
}
