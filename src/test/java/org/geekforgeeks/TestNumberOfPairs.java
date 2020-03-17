package org.geekforgeeks;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestNumberOfPairs {

    @Test
    public void test_1() {
        int[] arr1 = {2,1,6};
        int[] arr2 = {1,5};

        NumberOfPairs pairs = new NumberOfPairs();
        long count = pairs.count(arr1, arr2);
        assertThat(count, is(3));
    }

    @Test
    public void test_2() {
        int[] arr1 = {18,25,14,9,21,28};
        int[] arr2 = {15,16,17,18};

        NumberOfPairs pairs = new NumberOfPairs();
        long count = pairs.count(arr1, arr2);
        assertThat(count, is(8));
    }

    @Test
    public void test_3() {
        int[] arr1 = {5};
        int[] arr2 = {0,1,2,3,4};

        NumberOfPairs pairs = new NumberOfPairs();
        long count = pairs.count(arr1, arr2);
        assertThat(count, is(2));
    }

    @Test
    public void test_4() {
        int[] arr2 = {2,1,6};
        int[] arr1 = {1,5};

        NumberOfPairs pairs = new NumberOfPairs();
        long count = pairs.count(arr1, arr2);
        assertThat(count, is(2));
    }

    @Test
    public void test_5() {
        int[] arr1 = {140, 424, 280, 497, 188, 30, 50, 438, 367, 450, 194, 196, 298, 417, 287, 106, 489, 283, 456, 235, 115, 202, 317, 172, 287, 264};
        int[] arr2 = {361, 414, 475, 271, 171, 236, 334, 212, 261, 397, 168, 286, 51, 141, 195, 196, 125, 20, 126, 77, 195, 159, 303, 372, 467, 179, 94, 352, 485, 19, 465, 120, 153, 301, 88 ,61 ,427, 11, 258, 171, 316, 77, 228, 44};

        NumberOfPairs pairs = new NumberOfPairs();
        long count = pairs.count(arr1, arr2);
        assertThat(count, is(443));
    }

    @Test
    public void test_6() {
        int[] arr1 = {3};
        int[] arr2 = {59,144,169,178,120,358,42,392,265,124,416,73,430,342,216,116,37,458,260,201,453,94,242,330,449,228,299,225,325,275,134,386,39,171,363,130,85,410,379,424,86,401,25,194,106,413,266,268,408,178,285,205,291,335,392,122,86,235,191,43,499,87,19,122,425,98,377,255,170,109,428,494,69,367,103,439,101,320,319,291,485,340,57,309,133,479,315,288,240,75,21,328,55,489,442,299,143,3,322,105,447,57,10,334,209,262,34,187,305,386,143,343,261,162,121,344,79,188,114,64,92,435,416,157,262,13,412,460,252,239,371,125,8,8,85,452,102,490,459,442,291,14,413,356,61,94,473,403,177,44,374,267,152,276,29,33,262,470,4,230,108,393,452,454,393,71,20,473,408,495,6,441,384,263,410,108,39,361,472,172,155,448,15,24,230,490,267,388,257,133,471,240,167,23,284};

        NumberOfPairs pairs = new NumberOfPairs();
        long count = pairs.count(arr1, arr2);
        assertThat(count, is(194));
    }
}
