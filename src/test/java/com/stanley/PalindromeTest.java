package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeTest {

    @Test
    void simplePali()
    {

        Palindrome p = new Palindrome();

        assertEquals("abba",p.longest("abba"));
    }

//    @Test
//    void simpleMiddlePali()
//    {
//
//        Palindrome p = new Palindrome();
//
//        assertEquals("abba",p.longest("123abba456"));
//    }
//
//    @Test
//    void simpleStartPali()
//    {
//
//        Palindrome p = new Palindrome();
//
//        assertEquals("abba",p.longest("abba123"));
//    }
//
//    @Test
//    void simpleEndPali()
//    {
//
//        Palindrome p = new Palindrome();
//
//        assertEquals("abba",p.longest("123abba"));
//    }
//
//    @Test
//    void simpleMultiPali()
//    {
//
//        Palindrome p = new Palindrome();
//
//        assertEquals("abba",p.longest("123dd456abba789"));
//    }

}
