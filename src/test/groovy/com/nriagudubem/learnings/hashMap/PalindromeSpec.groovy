package com.nriagudubem.learnings.hashMap

import com.nriagudubem.learnings.Palindrome
import spock.lang.Specification
import spock.lang.Unroll

class PalindromeSpec extends Specification {

    private Palindrome palindrome

    void setup() {
        palindrome = new Palindrome()
    }

    @Unroll("test validPalindrome when input is #input should return #isPalindrome")
    def 'test validPalindrome when input is palindrome should return true'() {
        expect:
        palindrome.validPalindrome(input) == isPalindrome

        where:
        input    | isPalindrome
        'level'  | true
        'maddam' | true
    }


    def 'test validPalindrome when input is not palindrome should return false'() {
        given:
        String input = 'notapalindromestring'

        when:
        boolean isPalindrome = palindrome.validPalindrome(input)

        then:
        assert !isPalindrome
    }

    def 'test validPalindrome when input is a single char should return true'() {
        given:
        String input = 'a'

        when:
        boolean isPalindrome = palindrome.validPalindrome(input)

        then:
        assert isPalindrome
    }

    def 'test validPalindrome when input is null should return false'() {
        given:
        String input = null

        when:
        boolean isPalindrome = palindrome.validPalindrome(input)

        then:
        assert !isPalindrome
    }

    def 'test validPalindrome when input is an empty string should return false'() {
        given:
        String input = ''

        when:
        boolean isPalindrome = palindrome.validPalindrome(input)

        then:
        assert !isPalindrome

    }
}
