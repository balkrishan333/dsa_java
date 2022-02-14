package geekforgeeks;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import geekforgeeks.MaxSumSubArrayOfSizeK;
import org.junit.Test;

public final class TestMaxSumSubArrayOfSizeK {

    @Test
    public void test_1() {
        int[] arr = {100, 200, 300, 400};
        int k = 2;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(700));
    }

    @Test
    public void test_2() {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(39));
    }

    @Test
    public void test_3() {
        int[] arr = {5, -5, 15};
        int k = 2;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(10));
    }

    @Test
    public void test_4() {
        int[] arr = {-5, -6, -15};
        int k = 2;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(-11));
    }

    @Test
    public void test_5() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 1;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(9));
    }

    @Test
    public void test_6() {
        int[] arr = {5};
        int k = 1;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(5));
    }

    @Test
    public void test_7() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 5;

        MaxSumSubArrayOfSizeK arrayOfSizeK = new MaxSumSubArrayOfSizeK();
        int maxSum = arrayOfSizeK.maxSum(arr, k);
        assertThat(maxSum, is(15));
    }
}
