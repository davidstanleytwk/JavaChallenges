package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinHeapTest {

    @Test
    void simpleList()
    {
        MinHeap mh = new MinHeap(new int[] {12,20,13,42,5,16});

        int[]r =mh.getSortedArray();

        assertArrayEquals(new int[]{42,20,16,13,12,5},r);
    }

    @Test
    void emptyList()
    {
        MinHeap mh = new MinHeap(new int[] {});

        int[]r =mh.getSortedArray();

        assertArrayEquals(new int[]{},r);
    }

    @Test
    void oneEleList()
    {
        MinHeap mh = new MinHeap(new int[] {1});

        int[]r =mh.getSortedArray();

        assertArrayEquals(new int[]{1},r);
    }
    @Test
    void twoEleList()
    {
        MinHeap mh = new MinHeap(new int[] {1,6});

        int[]r =mh.getSortedArray();

        assertArrayEquals(new int[]{6,1},r);
    }

}
