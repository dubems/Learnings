package com.nriagudubem.learnings;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Palindrome {

    private Log log = LogFactory.getLog(Palindrome.class);

    public boolean validPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int secondPointer = s.length() - 1;

        for (int firstPointer = 0; firstPointer < s.length() - 1; firstPointer++) {
            if (firstPointer == secondPointer || (secondPointer - firstPointer == 1)) {
                break;
            }
            if (s.charAt(firstPointer) != s.charAt(secondPointer)) {
                return false;
            }
            secondPointer--;
        }

        return true;
    }
}
