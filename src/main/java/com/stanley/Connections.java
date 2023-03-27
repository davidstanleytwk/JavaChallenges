package com.stanley;

import java.util.*;
import java.util.stream.IntStream;

public class Connections {

    public static int countSpareLinks(int startNode, HashMap<Integer,Node> unvisitedNodes)
    {

        LinkedList<Node> nodesToProcess = new LinkedList<>();
        //PriorityQueue<Node> nodesToProcess =new PriorityQueue<>();
        Node sNode = unvisitedNodes.remove(startNode);
        //Node sNode = unvisitedNodes.get(startNode);
        nodesToProcess.add(sNode);
        int spareLinks=0;

        while (nodesToProcess.size()>0)
        {
            Node nextNode=nodesToProcess.remove();
            //unvisitedNodes.remove(nextNode.n);
            for(Edge e : nextNode.edges)
            {
                // skip if the edge has already been used
                if (e.traversed)
                {
                    continue;
                }
                else
                {
                    e.traversed=true;
                }
                // Check if the  node connected to nextNode via this edge has been visited already
                Node linkedNode = unvisitedNodes.get(e.getConnectNode(nextNode).id);
                if (linkedNode!=null)
                {
                    unvisitedNodes.remove(linkedNode.id);
                    nodesToProcess.add(linkedNode);
                }
                else
                {
                    // already visited so this is a spare link
                    spareLinks++;
                }
            }
        }
        return spareLinks;
    }



    static class Edge {
        Node from;
        Node to;
        boolean traversed=false;

        Edge( Node from, Node to)
        {
            this.from=from;
            this.to=to;
        }
        Node getConnectNode(Node n)
        {
            return n.id==this.from.id?this.to:this.from;
        }
    }
    static class Node implements Comparable<Node>{
        int id;
        ArrayList<Edge> edges = new ArrayList<>();
        Node(int id)
        {
            this.id = id;
        }
        void addEdge(Edge e)
        {
            edges.add(e);
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.id, o.id);
        }
    }

    public static int makeConnected(int n, int[][] connections) {

        HashMap<Integer,Node> unvisitedNodes = new HashMap<>();
        IntStream.range(0,n).forEach(i -> unvisitedNodes.put(i,new Node(i)));

        // populate the graph
        for (int[] c : connections) {
            // add link first - second node
            Node fromNode = unvisitedNodes.get(c[0]);
            Node toNode = unvisitedNodes.get(c[1]);
            Edge e = new Edge(fromNode, toNode);
            fromNode.addEdge(e);
            toNode.addEdge(e);
        }


        int spareLinks = countSpareLinks(0,unvisitedNodes);
        Integer[] unvisitedKeys=unvisitedNodes.keySet().toArray(Integer[]::new);
        int unlinkedNode=0;
        for(Integer k : unvisitedKeys)
        {
            Node nextNode=unvisitedNodes.get(k);
            if( nextNode!=null)
            {
                unlinkedNode++;
                spareLinks=spareLinks+countSpareLinks(k,unvisitedNodes);
            }
        }

        return unlinkedNode>spareLinks?-1:unlinkedNode;
    }

}
