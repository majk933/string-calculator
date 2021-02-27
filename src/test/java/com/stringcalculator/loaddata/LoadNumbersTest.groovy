package com.stringcalculator.loaddata

import spock.lang.Specification
import spock.lang.Unroll

class LoadNumbersTest extends Specification {
    private def loadNumbers = new LoadNumbers()

    @Unroll
    def "should return collection of number separated by comma [input = #input]"() {
        expect:
        loadNumbers.process(input).containsAll(output)

        where:
        input             | output
        ""                | [0]
        "1"               | [1]
        "1\n2"            | [1, 2]
        "1\n2,3"          | [1, 2, 3]
        "1\n2,3\n4"       | [1, 2, 3, 4]
        "1\n2,3\n4\n1000" | [1, 2, 3, 4, 1000]
    }

    @Unroll
    def "should collection of numbers separated by provided delimiter [input = #input]"() {
        expect:
        loadNumbers.process(input).containsAll(output)

        where:
        input                             | output
        ""                                | [0]
        "//[a][b]\n1"                     | [1]
        "//[a]\n2a1"                      | [1, 2]
        "//[a]\n1a-2a3"                   | [1, -2, 3]
        "//[ab][b][c]\n1ab2b3c-4"         | [1, 2, 3, -4]
        "//[xxx][yy]\n1xxx2yy3xxx-4"      | [1, 2, 3, -4]
        "//[xxx]\n1xxx2\n3\n4xxx5\n10000" | [1, 2, 3, 4, 5, 10000]
    }

    def "should throw error when invalid input is given [input = #input]"() {
        when:
        loadNumbers.process(input)

        then:
        thrown(NumberFormatException)

        where:
        input << ["1\ns", "x", "{", "1,2,3,s",
                  "//[xxx]\n1xx2",
                  "//[xxx]\n1xxx2xxy3",
                  "//[xxx][yyy]\n1xxx2yyy3yy4"
        ]
    }

}
