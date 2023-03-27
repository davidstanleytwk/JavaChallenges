package com.stanley;

public class MissingPositiveHeap implements MissingPositive {


    int[] heap;
    int heapSize;
    @Override
    public int firstMissingPositive(int[] nums) {

        this.heap=nums;
        heapSize=this.heap.length;

        for( int i =(heapSize/2)-1; i>=0;i--)
        {
            heapify(i);
        }
        int prev=0;
        for( int i=0;i<heap.length;i++)
        {
            int next=popMin();
            if( next<0)
            {
                continue;
            }
            if( next-prev>1)
            {
                return prev+1;
            }
            prev=next;
        }

        return prev+1;
    }

    private void heapify(int n)
    {
        if( n>(this.heapSize/2)-1)
        {
            return;
        }
        int r = (n+1)*2;
        int l = r-1;

        int swapInd=0;
        if( r<this.heapSize)
        {
            swapInd=this.heap[l]<this.heap[r]?l:r;
        }
        else
        {
            swapInd=l;
        }

        if( heap[n]>heap[swapInd])
        {
            // swap them
            int temp=heap[n];
            heap[n]=heap[swapInd];
            heap[swapInd]=temp;

            heapify(swapInd);
        }
    }

    int popMin()
    {
        int min=heap[0];
        heap[0]=heap[heapSize-1];
        heap[heapSize-1]=min;

        heapSize--;
        heapify(0);

        return min;
    }

}
