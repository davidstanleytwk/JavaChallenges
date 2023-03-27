package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorderRoutesTest {

    @Test
    void example_one()
    {
        ReorderRoutes r = new ReorderRoutes();
        
        
        int[][] connections ={{0,1},{1,3},{2,3},{4,0},{4,5}};
        int rr= r.minReorder(6,connections);
        assertEquals(3,rr);
        
    }

    @Test
    void example_two()
    {
        ReorderRoutes r = new ReorderRoutes();


        int[][] connections ={{1,0},{1,2},{3,2},{3,4}};
        int rr= r.minReorder(5,connections);
        assertEquals(2,rr);

    }

}
