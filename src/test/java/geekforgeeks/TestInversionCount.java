package geekforgeeks;

import geekforgeeks.InversionCount;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestInversionCount {

    @Test
    public void test_1() {
        int[] arr = {2,4,1,3,5};
        InversionCount solution = new InversionCount();
        long count = solution.count(arr);
        assertThat(count, is(3));
    }

    @Test
    public void test_2() {
        int[] arr = {1,2,3,4,5};
        InversionCount solution = new InversionCount();
        long count = solution.count(arr);
        assertThat(count, is(0));
    }

    @Test
    public void test_3() {
        int[] arr = {5,4,3,2,1};
        InversionCount solution = new InversionCount();
        long count = solution.count(arr);
        assertThat(count, is(10));
    }

    @Test
    public void test_4() {
        int[] arr = {5,4,3};
        InversionCount solution = new InversionCount();
        long count = solution.count(arr);
        assertThat(count, is(3));
    }

    @Test
    public void test_5() {
        int[] arr = {146,282,328,462,492,496,443,328,437,392,105};
        InversionCount solution = new InversionCount();
        long count = solution.count(arr);
        assertThat(count, is(26));
    }
    @Test
    public void test_6() {
        int[] arr = {146,282,328,462,492,496,443,328,437,392,105};
        InversionCount solution = new InversionCount();
        long count = solution.count(arr);
        assertThat(count, is(26));
    }
}
