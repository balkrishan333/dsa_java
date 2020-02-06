package org.geekforgeeks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestFindMissingNumber {

    @Test
    public void test_1() {
        int[] arr = {1,2,3,5};
        FindMissingNumber missingNumber = new FindMissingNumber();
        int number = missingNumber.find(arr, 5);

        assertThat(number, is(4));
    }

    @Test
    public void test_2() {
        int[] arr = {1,2,3,4,5,6,7,8,10};
        FindMissingNumber missingNumber = new FindMissingNumber();
        int number = missingNumber.find(arr, 10);

        assertThat(number, is(9));
    }
}
