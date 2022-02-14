package geekforgeeks;

import geekforgeeks.MergeSortedArrays;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class TestMergeSortedArrays {

    @Test
    public void test_1() {
        MergeSortedArrays solution = new MergeSortedArrays();
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0,2,6,8,9};
        solution.merge(arr1, arr2);

        assertThat(arr1.length, CoreMatchers.is(4));
        assertThat(arr2.length, CoreMatchers.is(5));

        assertArrayEquals(new int[]{0,1,2,3}, arr1);
        assertArrayEquals(new int[]{5,6,7,8,9}, arr2);
    }

    @Test
    public void test_2() {
        MergeSortedArrays solution = new MergeSortedArrays();
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {1, 3, 5, 7};
        solution.merge(arr1, arr2);

        assertThat(arr1.length, CoreMatchers.is(4));
        assertThat(arr2.length, CoreMatchers.is(4));

        assertArrayEquals(new int[]{1,1,3,3}, arr1);
        assertArrayEquals(new int[]{5,5,7,7}, arr2);
    }

    @Test
    public void test_3() {
        MergeSortedArrays solution = new MergeSortedArrays();
        int[] arr1 = {20, 21, 22};
        int[] arr2 = {1, 2, 3,4,5,6};
        solution.merge(arr1, arr2);

        assertThat(arr1.length, CoreMatchers.is(3));
        assertThat(arr2.length, CoreMatchers.is(6));

        assertArrayEquals(new int[]{1,2,3}, arr1);
        assertArrayEquals(new int[]{4,5,6,20,21,22}, arr2);
    }

    @Test
    public void test_4() {
        MergeSortedArrays solution = new MergeSortedArrays();
        int[] arr1 = {20,21,22,23,24,25,26};
        int[] arr2 = {1,2,3};
        solution.merge(arr1, arr2);

        assertThat(arr1.length, CoreMatchers.is(7));
        assertThat(arr2.length, CoreMatchers.is(3));

        assertArrayEquals(new int[]{1,2,3,20,21,22,23}, arr1);
        assertArrayEquals(new int[]{24,25,26}, arr2);
    }

    @Test
    public void test_5() {
        MergeSortedArrays solution = new MergeSortedArrays();
        int[] arr1 = {1, 20, 30, 40, 50};
        int[] arr2 = {11, 21, 31, 41, 51};
        solution.merge(arr1, arr2);

        assertThat(arr1.length, CoreMatchers.is(5));
        assertThat(arr2.length, CoreMatchers.is(5));

        assertArrayEquals(new int[]{1,11,20,21,30}, arr1);
        assertArrayEquals(new int[]{31,40,41,50,51}, arr2);
    }
}
