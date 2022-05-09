package hackerrank;

import hackerrank.MinimumDistanceBetweenSameElements;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestMinimumDistanceBetweenSameElements {

    @Test
    public void test_1() {
        int[] arr = {7, 1, 3, 4, 1, 7};
        MinimumDistanceBetweenSameElements elements = new MinimumDistanceBetweenSameElements();
        int minDistance = elements.findDistance(arr);

        assertThat(minDistance, is(3));
    }

    @Test
    public void test_2() {
        int[] arr = {7, 1, 3, 4, 2, 7};
        MinimumDistanceBetweenSameElements elements = new MinimumDistanceBetweenSameElements();
        int minDistance = elements.findDistance(arr);

        assertThat(minDistance, is(5));
    }

    @Test
    public void test_3() {
        int[] arr = {7};
        MinimumDistanceBetweenSameElements elements = new MinimumDistanceBetweenSameElements();
        int minDistance = elements.findDistance(arr);

        assertThat(minDistance, is(-1));
    }

    @Test
    public void test_4() {
        int[] arr = {7, 4};
        MinimumDistanceBetweenSameElements elements = new MinimumDistanceBetweenSameElements();
        int minDistance = elements.findDistance(arr);

        assertThat(minDistance, is(-1));
    }

    @Test
    public void test_5() {
        int[] arr = {4, 4, 4};
        MinimumDistanceBetweenSameElements elements = new MinimumDistanceBetweenSameElements();
        int minDistance = elements.findDistance(arr);

        assertThat(minDistance, is(1));
    }
}
