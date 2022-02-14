package geekforgeeks;

import geekforgeeks.EquilibriumPoint;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestEquilibriumPoint {

    @Test
    public void test1_shouldReturn_3() {
        int[] arr = {1,3,5,2,2};
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        int result = equilibriumPoint.find(arr);
        assertThat(result, CoreMatchers.is(3));
    }

    @Test
    public void test2_shouldReturn_4() {
        int[] arr = {1,6,8,5,8,6,1};
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        int result = equilibriumPoint.find(arr);
        assertThat(result, CoreMatchers.is(4));
    }

    @Test
    public void test3_shouldReturn_2() {
        int[] arr = {14,8,8,6};
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        int result = equilibriumPoint.find(arr);
        assertThat(result, CoreMatchers.is(2));
    }

    @Test
    public void test4_shouldReturn_minus_1() {
        int[] arr = {32,41,34,26,34,30,10,23,20,10,12,25,5,7,41,7,43,25};
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        int result = equilibriumPoint.find(arr);
        assertThat(result, CoreMatchers.is(-1));
    }

    @Test
    public void test5_shouldReturn_13() {
        int[] arr = {20,17,42,25,32,32,30,32,37,9,2,33,31,17,14,40,9,12,36,21,8,33,6,6,10,37,12,26,21,3};
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        int result = equilibriumPoint.find(arr);
        assertThat(result, CoreMatchers.is(13));
    }

    @Test
    public void test6_shouldReturn_minus_1() {
        int[] arr = {32,41,34,26,34,30,10,11,23,20,10,12,25,5,7,41,7,43,25};
        EquilibriumPoint equilibriumPoint = new EquilibriumPoint();
        int result = equilibriumPoint.find(arr);
        assertThat(result, CoreMatchers.is(-1));
    }
}
