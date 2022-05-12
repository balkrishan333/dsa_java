package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestImplementstrStr_28 {

    @Test
    public void test_1() {
        String haystack = "mississippi";
        String needle = "issip";

        ImplementstrStr_28 obj = new ImplementstrStr_28();

        Assertions.assertEquals(4, obj.strStr(haystack, needle));
    }

    @Test
    public void test_2() {
        String haystack = "hello";
        String needle = "ll";

        ImplementstrStr_28 obj = new ImplementstrStr_28();

        Assertions.assertEquals(2, obj.strStr(haystack, needle));
    }
}
