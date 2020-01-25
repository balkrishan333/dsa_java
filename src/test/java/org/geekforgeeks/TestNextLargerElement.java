package org.geekforgeeks;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestNextLargerElement {

    @Test
    public void test_1() {
        long[] arr = {1,3,2,4};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(result, new long[]{3,4,4,-1});
    }

    @Test
    public void test_2() {
        long[] arr = {4,3,2,1};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(result, new long[]{-1,-1,-1,-1});
    }

    @Test
    public void test_3() {
        long[] arr = {4,5,2,25};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(result, new long[]{5,25,25,-1});
    }

    @Test
    public void test_4() {
        long[] arr = {13,7,6,12};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(result, new long[]{-1,12,12,-1});
    }

    @Test
    public void test_5() {
        long[] arr = {10, 3, 12, 4, 2 ,9 ,13, 0, 8, 11, 1, 7, 5, 6};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(new long[]{12, 12, 13, 9, 9, 13, -1, 8, 11, -1, 7, -1, 6, -1}, result);
    }

    @Test
    public void test_6() {
        long[] arr = {11345831};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(new long[]{-1}, result);
    }

    @Test
    public void test_7() {
        long[] arr = {11345835571L};

        NextLargerElement solution = new NextLargerElement();
        long[] result = solution.nextLarger(arr);
        assertArrayEquals(new long[]{-1}, result);
    }

}
