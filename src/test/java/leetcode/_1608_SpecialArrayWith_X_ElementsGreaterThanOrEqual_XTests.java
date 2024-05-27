package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _1608_SpecialArrayWith_X_ElementsGreaterThanOrEqual_XTests {

    @Test
    public void test_1() {
        _1608_SpecialArrayWith_X_ElementsGreaterThanOrEqual_X obj = new _1608_SpecialArrayWith_X_ElementsGreaterThanOrEqual_X();
        int[] nums = {0,0};
        int result = obj.specialArray(nums);

        Assertions.assertEquals(-1, result);

    }
}
