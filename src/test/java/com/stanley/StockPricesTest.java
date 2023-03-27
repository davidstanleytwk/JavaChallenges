package com.stanley;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockPricesTest {


    @Test
    void smallPriceList()
    {
        int[] prices={10,4,8,2};

        StockPrices s = new StockPrices();
        assertEquals(4,s.bestProfit(prices));
    }

    @Test
    void mediumPriceList()
    {
        int[] prices={10, 7, 5, 8, 11, 9};

        StockPrices s = new StockPrices();
        assertEquals(6,s.bestProfit(prices));
    }

    @Test
    void largePriceList()
    {
        int[] prices={10, 7, 4, 8, 11, 9,8,7,6,8,12};

        StockPrices s = new StockPrices();
        assertEquals(8,s.bestProfit(prices));
    }
}
