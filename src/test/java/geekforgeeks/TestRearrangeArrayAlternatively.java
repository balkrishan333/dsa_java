package geekforgeeks;

import geekforgeeks.RearrangeArrayAlternatively;
import org.junit.Assert;
import org.junit.Test;

public class TestRearrangeArrayAlternatively {

    @Test
    public void test_1() {
        long[] arr = {1,2,3,4,5,6};
        RearrangeArrayAlternatively solution = new RearrangeArrayAlternatively();
        long[] result = solution.rearrange(arr);
        Assert.assertArrayEquals(new long[]{6,1,5,2,4,3}, result);
    }

    @Test
    public void test_2() {
        long[] arr = {10,20,30,40,50,60,70,80,90,100,110};
        RearrangeArrayAlternatively solution = new RearrangeArrayAlternatively();
        long[] result = solution.rearrange(arr);
        Assert.assertArrayEquals(new long[]{110,10,100,20,90,30,80,40,70,50,60}, result);
    }
}
