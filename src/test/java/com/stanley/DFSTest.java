package com.stanley;

import org.junit.jupiter.api.Test;

public class DFSTest {
    @Test
    void simpleGraph()
    {
        int[][] graph={{1,2},{5,9},{3,4},{},{},{6,7,8},{},{},{},{}};

        DFS dfs = new DFS();

        dfs.explore( graph,0);

    }


    @Test
    void simpleCyclicGraph()
    {
        int[][] graph={{1},{2},{3},{0}};

        DFS dfs = new DFS();

        dfs.explore( graph,0);

    }

    @Test
    void complexCyclicGraph()
    {
        int[][] graph={{1},{2,0},{3,0},{0}};

        DFS dfs = new DFS();

        dfs.explore( graph,0);

    }
}
