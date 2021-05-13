package com.hackerrank.interviewkit.dictionaryandhashmap;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestCountTriplet {

    @Test
    public void test_1() {
        List<Long> list = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
        int r = 3;
        CountTriplet triplet = new CountTriplet();
        Assert.assertEquals(6, triplet.count(list, r));
    }

    @Test
    public void test_2() {
        List<Long> list = Arrays.asList(1L, 2L, 2L, 4L);
        int r = 2;
        CountTriplet triplet = new CountTriplet();
        Assert.assertEquals(2, triplet.count(list, r));
    }

    @Test
    public void test_3() {
        List<Long> list = Arrays.asList(1L, 5L, 5L, 25L, 125L);
        int r = 5;
        CountTriplet triplet = new CountTriplet();
        Assert.assertEquals(4, triplet.count(list, r));
    }
    @Test
    public void test_4() {
        List<Long> list = Arrays.asList(1L, 1L, 1L);
        int r = 1;
        CountTriplet triplet = new CountTriplet();
        Assert.assertEquals(1, triplet.count(list, r));
    }
}
