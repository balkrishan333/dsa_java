package geekforgeeks;

import geekforgeeks.MaximumOfMinimumForEveryWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMaximumOfMinimumForEveryWindow {

    @Test
    public void test_1() {
        int[] arr = {10, 20, 30, 50, 10, 70, 30};

        MaximumOfMinimumForEveryWindow solution = new MaximumOfMinimumForEveryWindow();
        int[] result = solution.findMaximum(arr);

        Assertions.assertArrayEquals(new int[]{70, 30, 20, 10, 10, 10, 10}, result);
    }

    @Test
    public void test_2() {
        int[] arr = {10, 20, 30};

        MaximumOfMinimumForEveryWindow solution = new MaximumOfMinimumForEveryWindow();
        int[] result = solution.findMaximum(arr);

        Assertions.assertArrayEquals(new int[]{30, 20, 10}, result);
    }

    @Test
    public void test_3() {
        int[] arr = {10};

        MaximumOfMinimumForEveryWindow solution = new MaximumOfMinimumForEveryWindow();
        int[] result = solution.findMaximum(arr);

        Assertions.assertArrayEquals(new int[]{10}, result);
    }

    @Test
    public void test_4() {
        int[] arr = {10, 10, 10};

        MaximumOfMinimumForEveryWindow solution = new MaximumOfMinimumForEveryWindow();
        int[] result = solution.findMaximum(arr);

        Assertions.assertArrayEquals(new int[]{10, 10, 10}, result);
    }

    @Test
    public void test_5() {
        int[] arr = {30, 20, 10};

        MaximumOfMinimumForEveryWindow solution = new MaximumOfMinimumForEveryWindow();
        int[] result = solution.findMaximum(arr);

        Assertions.assertArrayEquals(new int[]{30, 20, 10}, result);
    }
}
