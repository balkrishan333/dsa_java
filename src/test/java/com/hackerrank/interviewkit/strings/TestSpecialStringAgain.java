package com.hackerrank.interviewkit.strings;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSpecialStringAgain {

    @Test
    public void test_1() {
        String str = "asabsb";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(8L));
    }

    @Test
    public void test_2() {
        String str = "mnonopoo";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(12L));
    }

    @Test
    public void test_3() {
        String str = "asasd";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(7L));
    }

    @Test
    public void test_4() {
        String str = "abcbaba";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(10L));
    }

    @Test
    public void test_5() {
        String str = "aaaa";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(10L));
    }

    @Test
    public void test_6() {
        String str = "aaasbbb";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(13L));
    }
    @Test
    public void test_7() {
        String str = "aabbccfcc";
        SpecialStringAgain solution = new SpecialStringAgain();
        long count = solution.count(str);

        assertThat(count, is(15L));
    }
}
