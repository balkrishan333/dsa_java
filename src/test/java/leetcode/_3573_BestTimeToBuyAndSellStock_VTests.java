package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _3573_BestTimeToBuyAndSellStock_VTests {

    private _3573_BestTimeToBuyAndSellStock_V obj;

    @BeforeEach
    public void beforeEach() {
        obj = new _3573_BestTimeToBuyAndSellStock_V();
    }

    @Test
    public void test_1() {
        int[] prices = {1,7,9,8,2};
        int k = 2;

        long result = obj.maximumProfit(prices, k);
        assertEquals(14, result);
    }

    @Test
    public void test_2() {
        int[] prices = {12,16,19,19,8,1,19,13,9};
        int k = 3;

        long result = obj.maximumProfit(prices, k);
        assertEquals(36, result);
    }
}
