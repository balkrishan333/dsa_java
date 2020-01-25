package org.geekforgeeks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class TestSubArrayWithGivenSum {

    @Test
    public void testFindSubArrayWithGivenSum_1() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {1,2,3,7,5};
        int targetSum = 12;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("2 4"));
    }

    @Test
    public void testFindSubArrayWithGivenSum_2() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {1,2,3,4,5,6,7,8,9,10};
        int targetSum = 15;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("1 5"));
    }

    @Test
    public void testFindSubArrayWithGivenSum_FirstElementEqualsTarget() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {1,2,3,7,5};
        int targetSum = 1;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("1 1"));
    }

    @Test
    public void testFindSubArrayWithGivenSum_4() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {135,101,170,125,79,159,163,65,106,146,82,28,162,92,196,143,28,37,192,5,103,154,93,183,22,117,119,96,48,127,172,139,70,113,68,100,36,95,104,12,123,134};
        int targetSum = 468;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("38 42"));
    }

    @Test
    public void testFindSubArrayWithGivenSum_5() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {28,68,142,130,41,14,175,2,78,16,84,14,193,25,2,193,160,71,29,28,85,76,187,99,171,88,48,5,104,22,64,107,164,11,172,90,41,165,143,20,114,192,105,19,33,151,6,176,140,104,23,99,48,185,49,172,65};
        int targetSum = 1562;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("20 37"));
    }

    @Test
    public void testFindSubArrayWithGivenSum_LastElementEqualsTarget() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {1,2,3,7,65};
        int targetSum = 65;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("5 5"));
    }

    @Test
    public void testFindSubArrayWithGivenSum_MiddleElementEqualsTarget() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {1,2,3,4,5,6,205,7,8,9,10};
        int targetSum = 205;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("7 7"));
    }


    @Test
    public void testFindSubArrayWithGivenSum_shouldReturnMinusOne() {
        SubArrayWithGivenSum sum = new SubArrayWithGivenSum();
        int[] inArray = {1,2,3,7,5};
        int targetSum = 50;

        SubArrayWithGivenSum.Index result = sum.findSubArrayWithGivenSum(inArray, targetSum);
        assertThat(result.toString(), is("-1"));
    }
}
