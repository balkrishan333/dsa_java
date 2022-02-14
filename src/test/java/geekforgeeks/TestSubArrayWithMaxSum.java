package geekforgeeks;

import geekforgeeks.SubArrayWithMaxSum;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSubArrayWithMaxSum {

    @Test
    public void test_1() {
        int[] arr = {1, 2, 3,-2,5};
        SubArrayWithMaxSum maxSum = new SubArrayWithMaxSum();
        SubArrayWithMaxSum.Indexes subArray = maxSum.findSubArray(arr);
        int sum = Arrays.stream(Arrays.copyOfRange(arr, subArray.getStartIndex(), subArray.getEndIndex() + 1)).sum();

        assertThat(sum , is(9));
    }

    @Test
    public void test_2() {
        int[] arr = {-1, -2, -3,-4};
        SubArrayWithMaxSum maxSum = new SubArrayWithMaxSum();
        SubArrayWithMaxSum.Indexes subArray = maxSum.findSubArray(arr);
        int sum = Arrays.stream(Arrays.copyOfRange(arr, subArray.getStartIndex(), subArray.getEndIndex() + 1)).sum();

        assertThat(sum , is(-1));
    }

    @Test
    public void test_3() {
        int[] arr = {-1, 2, 3,5};
        SubArrayWithMaxSum maxSum = new SubArrayWithMaxSum();
        SubArrayWithMaxSum.Indexes subArray = maxSum.findSubArray(arr);
        int sum = Arrays.stream(Arrays.copyOfRange(arr, subArray.getStartIndex(), subArray.getEndIndex() + 1)).sum();

        assertThat(sum , is(10));
    }
}
