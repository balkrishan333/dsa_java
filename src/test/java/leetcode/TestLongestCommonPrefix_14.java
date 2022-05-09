package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestCommonPrefix_14 {

    @Test
    public void test_1() {
        String[] strs = {"flower","flow","flight"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("fl", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_2() {
        String[] strs = {"dog","racecar","car"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_3() {
        String[] strs = {"flower","flow","flowight"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("flow", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_4() {
        String[] strs = {"flower","flower","flower"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("flower", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_5() {
        String[] strs = {"falower","flower","fdlower"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("f", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_6() {
        String[] strs = {"flowe","flowr","flows"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("flow", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_7() {
        String[] strs = {"cir","car"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("c", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_8() {
        String[] strs = {"baab","bacb","b","cbc"};
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();
        Assertions.assertEquals("", obj.longestCommonPrefix(strs));
    }
}
