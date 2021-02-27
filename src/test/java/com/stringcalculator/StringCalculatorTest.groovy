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
        input             | output
        ""                | 0
        "1"               | 1
        "1\n2"            | 3
        "1\n2,3"          | 6
        "1\n2,3\n4"       | 10
        "1\n2,3\n4\n1000" | 1010
    }

    @Unroll
    def "should return sum of numbers separated by provided delimiter [input = #input]"() {
        expect:
        calculator.add(input) == output

        where:
        input                          | output
        ""                             | 0
        "//a\n1"                       | 1
        "//a\n2a1"                     | 3
        "//a\n1a2a3"                   | 6
        "//ab\n1ab2ab3ab4"             | 10
        "//xxx\n1xxx2xxx3xxx4"         | 10
        "//xxx\n1xxx2\n3\n4xxx5\n1000" | 1015
    }

    @Unroll
    def "should ignore numbers greater than 1000 [input = #input]"() {
        expect:
        calculator.add(input) == output

        where:
        input                          | output
        "1\n2,3\n4\n2000"              | 10
        "//xxx\n1xxx2\n3\n4xxx5\n1005" | 15
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

    @Unroll
    def "should throw error when negatives are provided [input = #input]"() {
        when:
        calculator.add(input)

        then:
        final def exception = thrown(NegativesNotAllowed)

        and:
        exception.message == negativesNotAllowedMessage(negatives)

        where:
        input                    | negatives
        "-1"                     | "-1"
        "1\n-2"                  | "-2"
        "//xxx\n1xxx-2xxx-3xxx4" | "-2, -3"
    }

    private static def negativesNotAllowedMessage(String negatives) {
        String.format("Negatives [%s] not allowed", negatives)
    }
}
