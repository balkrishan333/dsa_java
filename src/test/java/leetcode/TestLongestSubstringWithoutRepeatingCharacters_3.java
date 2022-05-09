package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLongestSubstringWithoutRepeatingCharacters_3 {

    @Test
    public void test_1() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "abcabcbb";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_2() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "bbbbb";

        Assertions.assertEquals(1, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_3() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "pwwkew";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_4() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "aaaabc";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_5() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = " ";

        Assertions.assertEquals(1, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_6() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "     ";

        Assertions.assertEquals(1, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_7() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "abc";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_8() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "abcabc";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_9() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "dvdf";

        Assertions.assertEquals(3, obj.lengthOfLongestSubstring(s));
    }

    @Test
    public void test_10() {
        LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
        String s = "tmmzuxt";

        Assertions.assertEquals(5, obj.lengthOfLongestSubstring(s));
    }

}
