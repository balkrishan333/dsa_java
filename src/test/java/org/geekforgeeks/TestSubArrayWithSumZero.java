package org.geekforgeeks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSubArrayWithSumZero {

    @Test
    public void test_1() {
        int[] arr = {4, 2, -3, 1, 6};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("Yes"));
    }

    @Test
    public void test_2() {
        int[] arr = {4, 2, 0, 1, 6};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("Yes"));
    }

    @Test
    public void test_3() {
        int[] arr = {-4, -2, -9, -1, -6};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("No"));
    }

    @Test
    public void test_4() {
        int[] arr = {0};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("Yes"));
    }

    @Test
    public void test_5() {
        int[] arr = {4,3,2,-4};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("No"));
    }

    @Test
    public void test_6() {
        int[] arr = {-21, 21};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("Yes"));
    }

    @Test
    public void test_7() {
        int[] arr = {23, 12, 20, 46, 31, -45, -25};
        SubArrayWithSumZero arrayWithSumZero = new SubArrayWithSumZero();
        String result = arrayWithSumZero.find(arr);
        assertThat(result, is("No"));
    }
}
