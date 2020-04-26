package com.nriagudubem.learnings.hashMap.ReversePolishNotation

import com.nriagudubem.learnings.ReversePolishNotation.ReversePolishNotation
import spock.lang.Shared
import spock.lang.Specification

class ReversePolishNotationSpec extends Specification {

    @Shared
    private ReversePolishNotation reversePolishNotation

    void setupSpec() {
        reversePolishNotation = new ReversePolishNotation()
    }

    def "when tokens length is less than 3, should throw exception"() {
        given:
        String[] tokens = ["3", "4"]

        when:
        reversePolishNotation.evalRPN(tokens)

        then:
        IllegalArgumentException e = thrown(IllegalArgumentException)
        assert e.message == "invalid number of tokens/ operator cannot start the sequence"
    }

    def "when first item in token is an operator, should throw exception"() {
        given:
        String[] tokens = ["+", "9", "8", "*"]

        when:
        reversePolishNotation.evalRPN(tokens)

        then:
        IllegalArgumentException ex = thrown(IllegalArgumentException)
        ex.message == "invalid number of tokens/ operator cannot start the sequence"
    }

    def "test evalRPN method returns correct values"() {
        given:
        String[] tokens = ['4', '2', '5', '*', '+', '1', '3', '2', '*', '+', '/']

        when:
        double result = reversePolishNotation.evalRPN(tokens)

        then:
        assert result == 2


    }

    def "when token contains not supported operator, should throw exception"() {

    }
}
