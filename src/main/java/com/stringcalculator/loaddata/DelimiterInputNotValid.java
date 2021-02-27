package com.stringcalculator.loaddata;

class DelimiterInputNotValid extends RuntimeException {
    static final long serialVersionUID = 3660445966863326181L;

    DelimiterInputNotValid(String input) {
        super(String.format("Delimiter input [%s] is not valid", input));
    }
}
