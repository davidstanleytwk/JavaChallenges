package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordSearchTest {

    @Test
    void SimpleGridFound()
    {
        WordSearch ws = new WordSearch();

        char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        assertTrue(ws.exist(board,"ABCCED"));

    }

    @Test
    void SimpleGridFoundShort()
    {
        WordSearch ws = new WordSearch();

        char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        assertTrue(ws.exist(board,"SEE"));

    }

    @Test
    void SimpleGridFoundOneLetter()
    {
        WordSearch ws = new WordSearch();

        char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        assertTrue(ws.exist(board,"S"));

    }

        @Test
        void SimpleGridNotFound()
        {
            WordSearch ws = new WordSearch();

            char[][] board=     {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}  ;

            assertFalse(ws.exist(board,"ABCCCD"));

        }

    @Test
    void shortNotFound()
    {
        WordSearch ws = new WordSearch();

        char[][] board=  {{'A','A'}}  ;

        assertFalse(ws.exist(board,"AAA"));

    }

    @Test
    void longFound()
    {
        WordSearch ws = new WordSearch();

        char[][] board= {{'C','A','A'},{'A','A','A'},{'B','C','D'}};

        assertTrue(ws.exist(board,"AAB"));

    }




}
