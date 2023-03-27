package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingPositiveSolutionTest {
    @Test
    void simpleList()
    {
        int[] in={2,3,4};
        MissingPositiveSolution mp=new MissingPositiveSolution();
        int i=mp.firstMissingPositive(in);
        assertEquals(1,i);
    }

    @Test
    void simpleNegativeList()
    {
        int[] in={4,3,-1,2};
        MissingPositiveSolution mp=new MissingPositiveSolution();
        int i=mp.firstMissingPositive(in);
        assertEquals(1,i);
    }

    @Test
    void simpleConsequtiveList()
    {
        int[] in={1,2,3,4};
        MissingPositiveSolution mp=new MissingPositiveSolution();
        int i=mp.firstMissingPositive(in);
        assertEquals(5,i);
    }

    @Test
    void startHighList()
    {
        int[] in={8,6,7,9,12,18};
        MissingPositiveSolution mp=new MissingPositiveSolution();
        int i=mp.firstMissingPositive(in);
        assertEquals(1,i);
    }

    @Test
    void zeroAndNegativeList()
    {
        int[] in={4,3,-1,2,0,0,-3};
        MissingPositiveSolution mp=new MissingPositiveSolution();
        int i=mp.firstMissingPositive(in);
        assertEquals(1,i);
    }
}
