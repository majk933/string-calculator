package com.stringcalculator.calculate

import spock.lang.Specification
import spock.lang.Unroll

class CalculateNumbersTest extends Specification {
    private def calculateNumbers = new CalculateNumbers()

    @Unroll
    def "should ignore numbers greater than 1000 [input = #input]"() {
        expect:
        calculateNumbers.process(input) == output

        where:
        input                           | output
        [1, 2, 3, 4, 1005, 2000, 30000] | 10
        [1, 2, 3, 4, 5, 1000]           | 1015
    }

    @Unroll
    def "should throw error when negatives are provided [input = #input]"() {
        when:
        calculateNumbers.process(input)

        then:
        final def exception = thrown(NegativesNotAllowed)

        and:
        exception.message == negativesNotAllowedMessage(negatives)

        where:
        input                | negatives
        [-1]                 | "-1"
        [1, -2]              | "-2"
        [1, -2, -3, 4, 1005] | "-2, -3"
    }

    private static def negativesNotAllowedMessage(String negatives) {
        String.format("Negatives [%s] not allowed", negatives)
    }
}
