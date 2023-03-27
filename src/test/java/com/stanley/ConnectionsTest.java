package com.stanley;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectionsTest {


    @Test
    void simpleNetwork()
    {
        int c = Connections.makeConnected(4,new int[3][2]);
        assertEquals(3,c);
    }

    @Test
    void simpleNetworkNoLinksRequired()
    {
        int[][] links= {{0,1},{1,2}};
        int c = Connections.makeConnected(3,links);
        assertEquals(0,c);
    }
    @Test
    void example_one()
    {
        int[][] links= {{0,1},{0,2},{1,2}};
        int c = Connections.makeConnected(4,links);
        assertEquals(1,c);
    }
    @Test
    void example_two()
    {
        int[][] links={{0,1},{0,2},{0,3},{1,2},{1,3}};
        int c = Connections.makeConnected(6,links);
        assertEquals(2,c);
    }
    @Test
    void example_three()
    {
        int[][] links={{0,1},{0,2},{0,3},{1,2}};
        int c = Connections.makeConnected(6,links);
        assertEquals(-1,c);
    }

    @Test
    void example_four()
    {
        int[][] links={{0,1},{0,2},{0,3},{1,2},{1,3},{4,5},{5,6},{4,6}};
        int c = Connections.makeConnected(8,links);
        assertEquals(2,c);
    }

    @Test
    void example_five()
    {
        int[][] links={{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}};
        int c = Connections.makeConnected(11,links);
        assertEquals(3,c);
    }



    @Test
    void simpleNetworkNoLinks()
    {
        int c = Connections.makeConnected(7,new int[1][2]);
        assertEquals(-1,c);
    }
}
