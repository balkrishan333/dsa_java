package geekforgeeks;

import geekforgeeks.MinimumPlatforms;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestMinimumPlatforms {

    @Test
    public void test1_shouldReturn_3() {
        int[] arrival = {900,  940, 950,  1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(3));
    }

    @Test
    public void test2_shouldReturn_1() {
        int[] arrival = {900, 1100, 1235};
        int[] departure = {1000, 1200, 1240};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(1));
    }

    @Test
    public void test3_unsorted_shouldReturn_3() {
        int[] arrival = {940, 900,  1100, 950,  1800, 1500};
        int[] departure = {1200, 910, 1130, 1120, 2000, 1900};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(3));
    }

    @Test
    public void test4_shouldReturn_2() {
        int[] arrival = {900, 910,  920, 930};
        int[] departure = {910, 920, 930, 940};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(2));
    }

    @Test
    public void test5_overlapping_window_shouldReturn_3() {
        int[] arrival = {900, 905,  912, 918, 925,930,935};
        int[] departure = {910,915,922,928,935,940,940};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(3));
    }

    @Test
    public void test6_overlapping_window_shouldReturn_4() {
        int[] arrival = {900, 905,  912, 918, 925,930,935,935};
        int[] departure = {910,915,922,928,935,940,940,940};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(4));
    }

    @Test
    public void test7_overlapping_window_shouldReturn_3() {
        int[] arrival = {900, 905,  912, 918, 922,925,930,935};
        int[] departure = {910,915,922,928,929,935,940,940};

        MinimumPlatforms platforms = new MinimumPlatforms();
        int count = platforms.count(arrival, departure);
        assertThat(count, CoreMatchers.is(3));
    }
}
