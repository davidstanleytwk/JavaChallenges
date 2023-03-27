package com.stanley;

import java.util.StringJoiner;

public class MinHeap {

    int[] heap;
    int heapSize=0;

    //Compare and swap all the way up to the top of the heap

    /*
        Heap structure imp in array
        0..n
                        0
                1              2
            3       4       5       6
          7  8    9
        for any node n
            n.right=(n+1)*2
            n.left=n.right-1
        for any node n
            parent=trunc(n/2)
     */
    void heapify( int n)
    {
        if( n>(heapSize/2)-1 )
        {
            // n is a leaf, ie a node without any children
            return;
        }

        int right= (n+1)*2;
        int left = right-1;
        int swapIndex=0;
        if( right<heapSize)
        {
            swapIndex=heap[left]<heap[right]?left:right;
        }
        else
        {
            swapIndex=left;
        }
        if( heap[n]>heap[swapIndex])
        {
            int temp=heap[swapIndex];
            heap[swapIndex]=heap[n];
            heap[n]=temp;
            heapify(swapIndex);
        }

    }

     MinHeap(int[] heap)
     {
         this.heap=heap;
         this.heapSize=heap.length;

         for( int i=(heapSize/2)-1;i>=0;i--)
         {
             heapify(i);
         }
     }

     int popMin()
     {
         if(heapSize<0)
         {
             return -1;
         }
         int min=heap[0];

         // swap min to end of heap
         heap[0]=heap[heapSize-1];
         heap[heapSize-1]=min;
         heapSize--;
         heapify(0);

         return min;
     }

     int[] getSortedArray()
     {
         StringJoiner sj = new StringJoiner(", ");
        for( int i=0;i< heap.length;i++)
        {
            sj.add(Integer.toString(popMin()));
        }
         System.out.println("Sorted list:"+sj);

        return this.heap;
     }

}
