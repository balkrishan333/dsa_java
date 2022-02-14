package geekforgeeks;

import geekforgeeks.LeadersInArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestLeadersInArray {

    @Test
    public void test1() {
        int[] arr = {16,17,4,3,5,2};
        LeadersInArray leaders = new LeadersInArray();
        int[] result = leaders.find(arr);
        assertArrayEquals(result, new int[]{17,5,2});
    }

    @Test
    public void test2() {
        int[] arr = {1,2,3,4,0};
        LeadersInArray leaders = new LeadersInArray();
        int[] result = leaders.find(arr);
        assertArrayEquals(result, new int[]{4,0});
    }@Test
    public void test3() {
        int[] arr = {7,4,5,7,3};
        LeadersInArray leaders = new LeadersInArray();
        int[] result = leaders.find(arr);
        assertArrayEquals(result, new int[]{7,7,3});
    }
}
