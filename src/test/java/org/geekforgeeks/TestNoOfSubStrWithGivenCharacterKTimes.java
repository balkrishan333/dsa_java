package org.geekforgeeks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestNoOfSubStrWithGivenCharacterKTimes {

    @Test
    public void test_1() {
        String str = "abada";
        char ch = 'a';
        int k = 2;

        NoOfSubStrWithGivenCharacterKTimes solution = new NoOfSubStrWithGivenCharacterKTimes();
        int count = solution.findSubStrCount(str, ch, k);
        assertThat(count, is(4));
    }

    @Test
    public void test_2() {
        String str = "55555";
        char ch = '5';
        int k = 4;

        NoOfSubStrWithGivenCharacterKTimes solution = new NoOfSubStrWithGivenCharacterKTimes();
        int count = solution.findSubStrCount(str, ch, k);
        assertThat(count, is(2));
    }

    @Test
    public void test_3() {
        String str = "abada";
        char ch = 'e';
        int k = 2;

        NoOfSubStrWithGivenCharacterKTimes solution = new NoOfSubStrWithGivenCharacterKTimes();
        int count = solution.findSubStrCount(str, ch, k);
        assertThat(count, is(0));
    }

    @Test
    public void test_4() {
        String str = "ebade";
        char ch = 'e';
        int k = 2;

        NoOfSubStrWithGivenCharacterKTimes solution = new NoOfSubStrWithGivenCharacterKTimes();
        int count = solution.findSubStrCount(str, ch, k);
        assertThat(count, is(1));
    }

    @Test
    public void test_5() {
        String str = "ss";
        char ch = 's';
        int k = 1;

        NoOfSubStrWithGivenCharacterKTimes solution = new NoOfSubStrWithGivenCharacterKTimes();
        int count = solution.findSubStrCount(str, ch, k);
        assertThat(count, is(2));
    }
}
