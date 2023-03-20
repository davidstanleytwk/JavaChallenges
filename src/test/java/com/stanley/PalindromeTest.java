package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {

    @Test
    public void simplePali()
    {

        Palindrome p = new Palindrome();

        assertEquals("abba",p.longest("abba"));
    }

    @Test
    public void simpleMiddlePali()
    {

        Palindrome p = new Palindrome();

        assertEquals("abba",p.longest("123abba456"));
    }

    @Test
    public void simpleStartPali()
    {

        Palindrome p = new Palindrome();

        assertEquals("abba",p.longest("abba123"));
    }

    @Test
    public void simpleEndPali()
    {

        Palindrome p = new Palindrome();

        assertEquals("abba",p.longest("123abba"));
    }

    @Test
    public void simpleMultiPali()
    {

        Palindrome p = new Palindrome();

        assertEquals("abba",p.longest("123dd456abba789"));
    }

}
