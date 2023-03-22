package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_2492_MinimumScoreOfAPathBetweenTwoCities {

    @Test
    public void test_case_1() {
        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};

        _2492_MinimumScoreOfAPathBetweenTwoCities obj = new _2492_MinimumScoreOfAPathBetweenTwoCities();
        int result = obj.minScore(n, roads);

        Assertions.assertEquals(5, result);
    }
}
