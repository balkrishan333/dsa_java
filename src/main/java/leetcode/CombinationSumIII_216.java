package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSumIII_216 obj = new CombinationSumIII_216();

        int k = 3, n = 7;
        System.out.println(obj.combinationSum3(k, n));
    }

    /*
        using back track algorithm
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        combinations(k, n, list, 1);
        return ans;
    }

    private void combinations(int k, int n, List<Integer> list, int start) {

        if (k == 0 && n == 0) {
            //classic problem with recursion. To avoid piling all elements to result, clone the list
            List<Integer> list1 = new ArrayList<>(list);
            ans.add(list1);
            return;
        }

        if (k <= 0 || n <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            combinations(k-1, n-i, list, i+1);
            //remove the last element
            list.remove(list.size()-1);
        }
    }
}
