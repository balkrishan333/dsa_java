package geekforgeeks;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import geekforgeeks.CountSubArrayWithKDistinctElements;
import org.junit.Test;

public class TestCountSubArrayWithKDistinctElements {

    @Test
    public void test_success_1() {
        CountSubArrayWithKDistinctElements elements = new CountSubArrayWithKDistinctElements();
        int[] array = {2,1, 2, 1, 6};
        int distinctElements = 2;

        int count = elements.count(array, distinctElements);

        assertThat(count, is(7));
    }

    @Test
    public void test_success_2() {
        CountSubArrayWithKDistinctElements elements = new CountSubArrayWithKDistinctElements();
        int[] array = {1, 1, 1, 2, 6};
        int distinctElements = 2;

        int count = elements.count(array, distinctElements);

        assertThat(count, is(4));
    }

    @Test
    public void test_success_3() {
        CountSubArrayWithKDistinctElements elements = new CountSubArrayWithKDistinctElements();
        int[] array = {1};
        int distinctElements = 2;

        int count = elements.count(array, distinctElements);

        assertThat(count, is(0));
    }

    @Test
    public void test_success_4() {
        CountSubArrayWithKDistinctElements elements = new CountSubArrayWithKDistinctElements();
        int[] array = {1};
        int distinctElements = 1;

        int count = elements.count(array, distinctElements);

        assertThat(count, is(1));
    }

    @Test
    public void test_success_5() {
        CountSubArrayWithKDistinctElements elements = new CountSubArrayWithKDistinctElements();
        int[] array = {1, 2, 3, 4, 5};
        int distinctElements = 5;

        int count = elements.count(array, distinctElements);

        assertThat(count, is(1));
    }
}
