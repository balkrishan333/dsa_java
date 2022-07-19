package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _118_Pascal_Triangle {

    public static void main(String[] args) {
        int numRows = 5;
        _118_Pascal_Triangle obj = new _118_Pascal_Triangle();
        System.out.println(obj.generate(numRows));
    }

    /*
        Time - n^2
        Space - 1 - List is for returning result, no other space is used
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        result.add(List.of(1));
        if (numRows == 1) {
            return result;
        }

        result.add(List.of(1,1));
        if (numRows == 2) {
            return result;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);

            List<Integer> prev = result.get(i-1);
            for (int j = 1; j < i; j++) {
                l1.add(prev.get(j-1) + prev.get(j));
            }
            l1.add(1);
            result.add(l1);
        }
        return result;
    }
}
