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
        input       | output
        ""          | 0
        "1"         | 1
        "1\n2"      | 3
        "1\n2,3"    | 6
        "1\n2,3\n4" | 10
    }

    @Unroll
    def "should return sum of numbers separated by provided delimiter [input = #input]"() {
        expect:
        calculator.add(input) == output

        where:
        input                    | output
        ""                       | 0
        "//a\n1"                 | 1
        "//a\n2a1"               | 3
        "//a\n1a2a3"             | 6
        "//ab\n1ab2ab3ab4"       | 10
        "//xxx\n1xxx2xxx3xxx4"   | 10
        "//xxx\n1xxx2\n3\n4xxx5" | 15
    }

    def "should throw error when invalid input is given [input = #input]"() {
        when:
        calculator.add(input)

        then:
        thrown(NumberFormatException)

        where:
        input << ["1\ns", "x", "{", "1,2,3,s",
                  "//xxx\n1xx2",
                  "//xxx\n1xxx2xxy3"
        ]
    }
}
