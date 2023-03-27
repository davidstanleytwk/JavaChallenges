package com.stanley;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class DFS {

    int[] parent;
    int[] order;
    int orderIndex=0;

    public void dfsVisit( int[][] graph, int s)
    {
        for( int v : graph[s])
        {
            if( parent[v]!=-1)
            {
                System.out.println("Back edge:"+s+"-"+v);
            }
            else
            {
                parent[v]=s;
                dfsVisit(graph,v);
                order[orderIndex++]=v;
            }
        }


    }

    public void explore(int[][] graph, int start)
    {
        parent=new int[graph.length];
        order=new int[graph.length];
        Arrays.fill(parent,-1);

        parent[start]=start;
        dfsVisit(graph,start);


        String parentStr2  = IntStream
                .range(0,this.parent.length)
                .mapToObj(i->i + ": " +this.parent[i])
                .collect(joining("; "));
        System.out.println("Parents = " + parentStr2);


        StringJoiner joiner = new StringJoiner("; ");
        for (int i = this.order.length-1; i >= 0; i--) {
            String s = Integer.toString(this.order[i]);
            joiner.add(s);
        }
        String order  = joiner.toString();
        System.out.println("Topological Order = " + order);
    }
}
