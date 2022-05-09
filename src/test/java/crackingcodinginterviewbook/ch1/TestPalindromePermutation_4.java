package crackingcodinginterviewbook.ch1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPalindromePermutation_4 {

    @Test
    public void test_1() {
        String str = "tact coa";
        Assertions.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_2() {
        String str = "intin";
        Assertions.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_3() {
        String str = "bala";
        Assertions.assertFalse(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_4() {
        String str = "balal";
        Assertions.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_5() {
        String str = "balalb";
        Assertions.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }
}
