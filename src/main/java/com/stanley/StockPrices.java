package com.stanley;

public class StockPrices {

    public int bestProfit(int[] prices)
    {
        int[][] priceDiffs=new int[prices.length][prices.length];

        int maxRet=0;
        for(int i=prices.length-1;i>=0;i--)
        {
            for(int j=i;j<prices.length;j++)
            {
                if( i==j)
                {
                    priceDiffs[i][j] = 0;
                }
                else if( j-i==1)
                {
                    priceDiffs[i][j]=prices[j]-prices[j-1];
                }
                else
                {
                    priceDiffs[i][j]=priceDiffs[i][i+1]+priceDiffs[i+1][j];
                }

                maxRet=Math.max(maxRet,priceDiffs[i][j]);
            }

        }

        return maxRet;

    }
}
