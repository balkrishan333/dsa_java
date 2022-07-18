package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _283_MoveZerosTests {

    @Test
    public void test_1() {
        int[] nums = {0,1,0,3,12};

        _283_MoveZeros obj = new _283_MoveZeros();
        obj.moveZeroes(nums);

        Assertions.assertArrayEquals(new int[]{1,3,12,0,0}, nums);
    }
}
