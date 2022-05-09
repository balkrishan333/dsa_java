package hackerrank;

import hackerrank.FindRations;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestFindRations {

    @Test
    public void test_1() {
        int[] arr = {2,3,4,5,6};
        FindRations findRations = new FindRations();
        String result = findRations.find(arr);
        assertThat(result, is("4"));
    }

    @Test
    public void test_2() {
        int[] arr = {1,2};
        FindRations findRations = new FindRations();
        String result = findRations.find(arr);
        assertThat(result, is("NO"));
    }

    @Test
    public void test_3() {
        int[] arr = {2,4,6,8};
        FindRations findRations = new FindRations();
        String result = findRations.find(arr);
        assertThat(result, is("0"));
    }

    @Test
    public void test_4() {
        int[] arr = {1,3,5,7};
        FindRations findRations = new FindRations();
        String result = findRations.find(arr);
        assertThat(result, is("4"));
    }
}
