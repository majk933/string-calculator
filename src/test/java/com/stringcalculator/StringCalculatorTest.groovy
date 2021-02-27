package com.stringcalculator

import spock.lang.Specification
import spock.lang.Unroll

class StringCalculatorTest extends Specification {
    private def calculator = new StringCalculator()

    def "should create calculator"() {
        expect:
        calculator != null
    }

    @Unroll
    def "should return sum of numbers separated by comma [input = #input]"() {
        expect:
        calculator.add(input) == output

        where:
        input     | output
        ""        | 0
        "1"       | 1
        "1,2"     | 3
        "1,2,3"   | 6
        "1,2,3,4" | 6
        "1,2,3,s" | 6
    }

    def "should throw error when invalid input is given"() {
        when:
        calculator.add(input)

        then:
        thrown(NumberFormatException)

        where:
        input << ["1,s", "x", "{", "\n"]
    }
}
