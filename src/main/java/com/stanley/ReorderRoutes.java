package com.stanley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class ReorderRoutes {

    static class Node{
        int id;
        ArrayList<Edge> edges= new ArrayList<>();
        Node(int id)
        {
            this.id=id;
        }
        void addEdge( Edge e)
        {
            this.edges.add(e);
        }
    }

    static class Edge
    {
        Node from;
        Node to;

        boolean traversed=false;

        Edge(Node from, Node to)
        {
            this.from=from;
            this.to=to;
        }
        boolean isToNode(Node n)
        {
            return n.id==this.to.id;
        }

        Node getConnectedNode(Node n)
        {
            return n.id==this.from.id?this.to:this.from;
        }
    }


    private int countReversals(Node startNode)
    {
        LinkedList<Node> nodeQ = new LinkedList<>();
        nodeQ.add(startNode);
        int reverseCount=0;
        while( nodeQ.size()>0)
        {
            Node nextNode=nodeQ.remove();
            for( Edge e : nextNode.edges)
            {
                if(e.traversed)
                {
                    continue;
                }
                else
                {
                    e.traversed=true;
                }
                if( !e.isToNode(nextNode))
                {
                    reverseCount++;
                }
                // add the node that connects via this edge to the Q
                nodeQ.add(e.getConnectedNode(nextNode));
            }

        }

        return reverseCount;
    }


    public int minReorder(int n, int[][] connections)
    {
        //float x = HashMap.DEFAULT_LOAD_FACTOR;
        int initialCapacity=(int)Math.ceil(n/0.75);
        HashMap<Integer,Node> allNodes = new HashMap<>(initialCapacity);
        IntStream.range(0,n)
                .mapToObj(Node::new)
                .forEach(node->allNodes.put(node.id,node));

        for(int[] c : connections)
        {
            Edge e = new Edge(allNodes.get(c[0]),allNodes.get(c[1]));
            // add the edge to both nodes
            e.from.addEdge(e);
            e.to.addEdge(e);
        }

        return countReversals(allNodes.get(0));
    }

}
