package com.stanley;

import java.util.Arrays;

public class MissingPositiveArrays implements MissingPositive{

    @Override
    public int firstMissingPositive(int[] nums)
    {

        Arrays.sort(nums);
        int startPoint = Arrays.binarySearch(nums,0);

        startPoint=startPoint<0?Math.abs(startPoint)-1:startPoint;
        int prev=0;
        for(int i=startPoint; i<nums.length; i++)
        {
            if( nums[i]<0)
            {
                continue;
            }
            if( nums[i]-prev>1)
            {
                break;
            }
            prev=nums[i];
        }


        return prev+1;
    }
}
