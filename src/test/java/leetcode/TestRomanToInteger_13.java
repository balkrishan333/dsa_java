package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRomanToInteger_13 {

    @Test
    public void test_1() {
        _13_RomanToInteger obj = new _13_RomanToInteger();
        Assertions.assertEquals(3, obj.romanToInt("III"));
    }

    @Test
    public void test_2() {
        _13_RomanToInteger obj = new _13_RomanToInteger();
        Assertions.assertEquals(58, obj.romanToInt("LVIII"));
    }

    @Test
    public void test_3() {
        _13_RomanToInteger obj = new _13_RomanToInteger();
        Assertions.assertEquals(1994, obj.romanToInt("MCMXCIV"));
    }
}
