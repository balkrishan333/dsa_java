package com.hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class TestCutTheSticks {

    @Test
    public void test_1() {
        int[] arr = {5, 4, 4, 2, 2, 8};
        CutTheSticks sticks = new CutTheSticks();
        int[] count = sticks.count(arr);
        Assert.assertArrayEquals(new int[]{6,4,2,1}, count);
    }

    @Test
    public void test_2() {
        int[] arr = {1, 2, 3 ,4 ,3 ,3 ,2, 1};
        CutTheSticks sticks = new CutTheSticks();
        int[] count = sticks.count(arr);
        Assert.assertArrayEquals(new int[]{8,6,4,1}, count);
    }

    @Test
    public void test_3() {
        int[] arr = {1,2,3};
        CutTheSticks sticks = new CutTheSticks();
        int[] count = sticks.count(arr);
        Assert.assertArrayEquals(new int[]{3,2,1}, count);
    }

    @Test
    public void test_4() {
        int[] arr = {2,2,2,2,2};
        CutTheSticks sticks = new CutTheSticks();
        int[] count = sticks.count(arr);
        Assert.assertArrayEquals(new int[]{5}, count);
    }
}
