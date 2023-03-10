package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestCommonPrefix_14 {

    @Test
    public void test_1() {
        String[] strs = {"flower","flow","flight"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("fl", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_2() {
        String[] strs = {"dog","racecar","car"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_3() {
        String[] strs = {"flower","flow","flowight"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("flow", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_4() {
        String[] strs = {"flower","flower","flower"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("flower", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_5() {
        String[] strs = {"falower","flower","fdlower"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("f", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_6() {
        String[] strs = {"flowe","flowr","flows"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("flow", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_7() {
        String[] strs = {"cir","car"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("c", obj.longestCommonPrefix(strs));
    }

    @Test
    public void test_8() {
        String[] strs = {"baab","bacb","b","cbc"};
        _14_LongestCommonPrefix obj = new _14_LongestCommonPrefix();
        Assertions.assertEquals("", obj.longestCommonPrefix(strs));
    }
}
