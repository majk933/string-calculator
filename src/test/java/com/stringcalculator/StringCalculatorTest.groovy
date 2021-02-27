package com.stringcalculator

import spock.lang.Specification

class StringCalculatorTest extends Specification {
    private def calculator = new StringCalculator()

    def "should create calculator"() {
        expect:
        calculator != null
    }

    def "should return constant for each request "() {
        expect:
        calculator.add("s148104715fada") == 0

        where:
        input << ["s148104715fada", "5", "n"]
    }
}
