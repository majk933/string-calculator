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
        input    | output
        ""       | 0
        "1"      | 1
        "1,2"    | 3
        "1\n2,3" | 6
    }

    @Unroll
    def "should return sum of numbers separated by provided delimiters [input = #input]"() {
        expect:
        calculator.add(input) == output

        where:
        input                          | output
        ""                             | 0
        "//[a]\n1"                       | 1
        "//[a]\n2a1"                     | 3
        "//[a]\n1a2a3"                   | 6
        "//[ab]\n1ab2ab3ab4"             | 10
        "//[xxx]\n1xxx2xxx3xxx4"         | 10
        "//[xxx]\n1xxx2\n3\n4xxx5\n1000" | 1015
    }

    @Unroll
    def "should ignore numbers greater than 1000 [input = #input]"() {
        expect:
        calculator.add(input) == output

        where:
        input                           | output
        "1\n2,3\n4\n2000"               | 10
        "//[xxx]\n1xxx2\n3\n4xxx5\n10000" | 15
    }

    @Unroll
    def "should throw exception when negative provided"() {
        when:
        calculator.add(input)

        then:
        thrown(RuntimeException)

        where:
        input << ["1\n2,3\n-4\n2000", "//xxx\n1xxx2\n3\n4xxx-5"]
    }
}