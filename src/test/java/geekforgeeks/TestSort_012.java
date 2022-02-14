package geekforgeeks;

import geekforgeeks.Sort_012;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestSort_012 {

    @Test
    public void test_1() {
        int[] arr = {0,2,1,2,0};
        Sort_012 solution = new Sort_012();
        solution.sort(arr);
        assertArrayEquals(new int[]{0,0,1,2,2}, arr);
    }

    @Test
    public void test_2() {
        int[] arr = {0,1,0};
        Sort_012 solution = new Sort_012();
        solution.sort(arr);
        assertArrayEquals(new int[]{0,0,1}, arr);
    }
}
