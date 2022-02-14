package crackingcodinginterviewbook.ch1;

import org.junit.Assert;
import org.junit.Test;

public class TestPalindromePermutation_4 {

    @Test
    public void test_1() {
        String str = "tact coa";
        Assert.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_2() {
        String str = "intin";
        Assert.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_3() {
        String str = "bala";
        Assert.assertFalse(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_4() {
        String str = "balal";
        Assert.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }

    @Test
    public void test_5() {
        String str = "balalb";
        Assert.assertTrue(PalindromePermutation_4.checkPermutation(str));
    }
}
