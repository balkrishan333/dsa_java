package crackingcodinginterviewbook.ch1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStringCompression_6 {

    @Test
    public void test_1() {
        String str = "aabcccccaaa";
        assertEquals("a2b1c5a3", StringCompression_6.compress(str));
    }

    @Test
    public void test_2() {
        String str = "a";
        assertEquals(str, StringCompression_6.compress(str));
    }

    @Test
    public void test_3() {
        String str = "abcdef";
        assertEquals(str, StringCompression_6.compress(str));
    }

    @Test
    public void test_4() {
        String str = "aaaaaaaa";
        assertEquals("a8", StringCompression_6.compress(str));
    }
}
