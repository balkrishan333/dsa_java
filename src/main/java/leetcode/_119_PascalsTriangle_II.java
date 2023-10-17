package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangle_II {

    public static void main(String[] args) {
        _119_PascalsTriangle_II obj = new _119_PascalsTriangle_II();

        System.out.println(obj.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        if(rowIndex == 0) {
            return result;
        }

        if(rowIndex == 1) {
            result.add(1);
            return result;
        }

        List<Integer> prev = getRow(rowIndex-1);

        for(int i =0; i < prev.size()-1; i++) {
            result.add(prev.get(i) + prev.get(i+1));
        }
        result.add(1);

        return result;
    }
}
