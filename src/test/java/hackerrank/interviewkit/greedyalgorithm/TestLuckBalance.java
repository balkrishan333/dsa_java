package hackerrank.interviewkit.greedyalgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLuckBalance {

    @Test
    public void test_1() {
        int k = 2;
        int[][] contests = {
                {5,1},
                {4,0},
                {6,1},
                {2,1},
                {8,0},
        };

        LuckBalance luckBalance = new LuckBalance();
        Assertions.assertEquals(21, luckBalance.calc(k, contests));
    }

    @Test
    public void test_2() {
        int k = 3;
        int[][] contests = {
                {5,1},
                {2,1},
                {1,1},
                {8,1},
                {10,0},
                {5,0}
        };

        LuckBalance luckBalance = new LuckBalance();
        Assertions.assertEquals(29, luckBalance.calc(k, contests));
    }
    @Test
    public void test_3() {
        int k = 5;
        int[][] contests = {
                {13,1},
                {10,1},
                {9,1},
                {8,1},
                {13,1},
                {12,1},
                {18,1},
                {13,1}
        };

        LuckBalance luckBalance = new LuckBalance();
        Assertions.assertEquals(42, luckBalance.calc(k, contests));
    }

    @Test
    public void test_4() {
        int k = 0;
        int[][] contests = {
                {5,1},
                {4,1},
                {6,1},
                {2,1},
                {8,1},
        };

        LuckBalance luckBalance = new LuckBalance();
        Assertions.assertEquals(-25, luckBalance.calc(k, contests));
    }
}
