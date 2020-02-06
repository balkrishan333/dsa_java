package org.geekforgeeks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCountTriplets {

    @Test
    public void test_1() {
        int[] arr = {1,2,3,4,5};
        CountTriplets triplets = new CountTriplets();
        int count = triplets.count(arr);

        assertThat(count, is(4));
    }

    @Test
    public void test_2() {
        int[] arr = {1,1,1,2,2};
        CountTriplets triplets = new CountTriplets();
        int count = triplets.count(arr);

        assertThat(count, is(6));
    }

    @Test
    public void test_3() {
        int[] arr = {1,5,3,2};
        CountTriplets triplets = new CountTriplets();
        int count = triplets.count(arr);

        assertThat(count, is(2));
    }

    @Test
    public void test_4() {
        int[] arr = {3,2,7};
        CountTriplets triplets = new CountTriplets();
        int count = triplets.count(arr);

        assertThat(count, is(0));
    }
}
