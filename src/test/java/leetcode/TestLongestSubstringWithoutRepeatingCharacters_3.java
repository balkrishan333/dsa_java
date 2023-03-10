package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestSubstringWithoutRepeatingCharacters_3 {

    @Test
    public void test_1() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_2() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "bbbbb";

        Assertions.assertEquals(1, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_3() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_4() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "aaaabc";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_5() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = " ";

        Assertions.assertEquals(1, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_6() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "     ";

        Assertions.assertEquals(1, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_7() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "abc";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_8() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabc";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_9() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "dvdf";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_10() {
        _3_LongestSubstringWithoutRepeatingCharacters obj = new _3_LongestSubstringWithoutRepeatingCharacters();
        String s = "tmmzuxt";

        Assertions.assertEquals(5, obj.lengthOfLongestSubstring(s));
    }

}
