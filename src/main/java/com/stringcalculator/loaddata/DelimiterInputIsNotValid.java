package com.stringcalculator.loaddata;

class DelimiterInputIsNotValid extends RuntimeException {
    static final long serialVersionUID = 3660445966863326181L;

    DelimiterInputIsNotValid(String input) {
        super(String.format("Delimiter input [%s] is not valid", input));
    }
}
