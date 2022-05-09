package hackerrank.interviewkit.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMergeSort_CountingInversion {

    @Test
    public void test_1(){
        int[] arr = {2, 1, 3, 1, 2};
        MergeSort_CountingInversion countingInversion = new MergeSort_CountingInversion();
        long swaps = countingInversion.count(arr);
        Assertions.assertEquals(4, swaps);
    }

    @Test
    public void test_2(){
        int[] arr = {1,1,1,2,2};
        MergeSort_CountingInversion countingInversion = new MergeSort_CountingInversion();
        long swaps = countingInversion.count(arr);
        Assertions.assertEquals(0, swaps);
    }

    @Test
    public void test_3(){
        int[] arr = {10,9,8,7,6,5,4};
        MergeSort_CountingInversion countingInversion = new MergeSort_CountingInversion();
        long swaps = countingInversion.count(arr);
        Assertions.assertEquals(21, swaps);
    }

    @Test
    public void test_4(){
        int[] arr = {10,9};
        MergeSort_CountingInversion countingInversion = new MergeSort_CountingInversion();
        long swaps = countingInversion.count(arr);
        Assertions.assertEquals(1, swaps);
    }
}
