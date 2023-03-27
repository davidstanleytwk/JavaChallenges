package com.stanley;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingPositiveHeapTest {


    static MissingPositive[] mpImps;
    @BeforeAll
    static void init()
    {
        mpImps = new MissingPositive[3];
        mpImps[0]=MissingPostiveFactory.getMissPositiveClass("heap");
        mpImps[1]=MissingPostiveFactory.getMissPositiveClass("solution");
        mpImps[2]=MissingPostiveFactory.getMissPositiveClass("arrays");

    }

    static void runTestForEachMp(int[] t, int expRes)
    {
        for(MissingPositive mp: mpImps)
        {
            assertEquals(expRes,mp.firstMissingPositive(t));
        }
    }

    @Test
    void simpleList()
    {
        int[] in={2,3,4};
        runTestForEachMp(in,1);
//        MissingPositiveHeap mp=new MissingPositiveHeap();
//        int i=mp.firstMissingPositive(in);
//        assertEquals(1,i);
    }

    @Test
    void simpleNegativeList()
    {
        int[] in={4,3,-1,2};

        runTestForEachMp(in,1);
//        MissingPositive mp= MissingPostiveFactory.getMissPositiveClass("heap");
//        int i=mp.firstMissingPositive(in);
//        assertEquals(1,i);
    }

    @Test
    void simpleConsequtiveList()
    {
        int[] in={1,2,3,4};

        runTestForEachMp(in,5);
    }

    @Test
    void mostlyConsequtiveList()
    {
        int[] in={1,2,3,4,5,6,7,9};

        runTestForEachMp(in,8);
    }

    @Test
    void startHighList()
    {
        int[] in={8,6,7,9,12,18};
        runTestForEachMp(in,1);

    }

    @Test
    void zeroAndNegativeList()
    {
        int[] in={4,3,-1,2,0,0,-3};
        runTestForEachMp(in,1);
    }

    @Test
    void allNegativeList()
    {
        int[] in={-4,-3,-1,-2,0,0,-3};
        runTestForEachMp(in,1);
    }


}
