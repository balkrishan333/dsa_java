package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRomanToInteger_13 {

    @Test
    public void test_1() {
        RomanToInteger_13 obj = new RomanToInteger_13();
        Assertions.assertEquals(3, obj.romanToInt("III"));
    }

    @Test
    public void test_2() {
        RomanToInteger_13 obj = new RomanToInteger_13();
        Assertions.assertEquals(58, obj.romanToInt("LVIII"));
    }

    @Test
    public void test_3() {
        RomanToInteger_13 obj = new RomanToInteger_13();
        Assertions.assertEquals(1994, obj.romanToInt("MCMXCIV"));
    }
}
