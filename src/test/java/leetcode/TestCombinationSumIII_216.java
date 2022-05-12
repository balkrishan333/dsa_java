package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCombinationSumIII_216 {

    @Test
    public void test_1() {
        CombinationSumIII_216 obj = new CombinationSumIII_216();
        List<List<Integer>> result = obj.combinationSum3(9, 45);

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);

        expected.add(list1);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        CombinationSumIII_216 obj = new CombinationSumIII_216();
        List<List<Integer>> result = obj.combinationSum3(3, 7);

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);

        expected.add(list1);

        Assertions.assertEquals(expected, result);
    }
}
