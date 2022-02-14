package crackingcodinginterviewbook.ch1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOneAway_5 {

    @Test
    public void test_1() {
        String s1 = "pale";
        String s2 = "ple";
        assertTrue(OneAway_5.checkDistance(s1, s2));
    }

    @Test
    public void test_2() {
        String s1 = "pale";
        String s2 = "pales";
        assertTrue(OneAway_5.checkDistance(s1, s2));
    }

    @Test
    public void test_3() {
        String s1 = "pale";
        String s2 = "bale";
        assertTrue(OneAway_5.checkDistance(s1, s2));
    }

    @Test
    public void test_4() {
        String s1 = "pale";
        String s2 = "bake";
        assertFalse(OneAway_5.checkDistance(s1, s2));
    }

    @Test
    public void test_5() {
        String s1 = "abcd";
        String s2 = "ab";
        assertFalse(OneAway_5.checkDistance(s1, s2));
    }

    @Test
    public void test_6() {
        String s1 = "abccd";
        String s2 = "abcd";
        assertTrue(OneAway_5.checkDistance(s1, s2));
    }

}
