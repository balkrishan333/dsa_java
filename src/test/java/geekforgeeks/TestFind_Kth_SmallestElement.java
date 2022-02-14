package geekforgeeks;

import geekforgeeks.Find_Kth_SmallestElement;
import org.junit.Assert;
import org.junit.Test;

public class TestFind_Kth_SmallestElement {

    @Test
    public void test_should_return_5() {
        int[] arr = {12,5,787,1,23};
        int k = 2;

        Find_Kth_SmallestElement smallestElement = new Find_Kth_SmallestElement();
        //quick sort
        Assert.assertEquals(5, smallestElement.approach_1_sorting(arr, k));
        //quick select
        Assert.assertEquals(5, smallestElement.approach_4_quickSelect(arr, k));
        //min heap
        Assert.assertEquals(5, smallestElement.approach_2_minHeap(arr, k));
        //max heap
        Assert.assertEquals(5, smallestElement.approach_3_maxHeap(arr, k));
    }

    @Test
    public void test_should_return_3() {
        int[] arr = {10, 5, 7, 4, 2, 1, 3, 6, 8, 9};
        int k = 3;

        Find_Kth_SmallestElement smallestElement = new Find_Kth_SmallestElement();

        //quick sort
        Assert.assertEquals(3, smallestElement.approach_1_sorting(arr, k));
        //quick select
        Assert.assertEquals(3, smallestElement.approach_4_quickSelect(arr, k));
        //min heap
        Assert.assertEquals(3, smallestElement.approach_2_minHeap(arr, k));
        //max heap
        Assert.assertEquals(3, smallestElement.approach_3_maxHeap(arr, k));
    }

    @Test
    public void test_should_return_7() {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        Find_Kth_SmallestElement smallestElement = new Find_Kth_SmallestElement();

        //quick sort
        Assert.assertEquals(7, smallestElement.approach_1_sorting(arr, k));
        //quick select
        Assert.assertEquals(7, smallestElement.approach_4_quickSelect(arr, k));
        //min heap
        Assert.assertEquals(7, smallestElement.approach_2_minHeap(arr, k));
        //max heap
        Assert.assertEquals(7, smallestElement.approach_3_maxHeap(arr, k));
    }

    @Test
    public void test_should_return_15() {
        int[] arr = {7, 10, 4,  20, 15};
        int k = 4;

        Find_Kth_SmallestElement smallestElement = new Find_Kth_SmallestElement();

        //quick sort
        Assert.assertEquals(15, smallestElement.approach_1_sorting(arr, k));
        //quick select
        Assert.assertEquals(15, smallestElement.approach_4_quickSelect(arr, k));
        //min heap
        Assert.assertEquals(15, smallestElement.approach_2_minHeap(arr, k));
        //max heap
        Assert.assertEquals(15, smallestElement.approach_3_maxHeap(arr, k));
    }
}
