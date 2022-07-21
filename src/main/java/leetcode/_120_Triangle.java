package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _120_Triangle {

    public static void main(String[] args) {
        _120_Triangle obj = new _120_Triangle();

        List<List<Integer>> triangle = new ArrayList<>();

//        triangle.add(List.of(2));
//        triangle.add(List.of(3,4));
//        triangle.add(List.of(6,5,7));
//        triangle.add(List.of(4,1,8,3));

        triangle.add(List.of(-1));
        triangle.add(List.of(2,3));
        triangle.add(List.of(1,-1,-3));

        System.out.println(obj.minimumTotal(triangle));
    }

    /*
      Bottom up approach.
      Create an array of size, triangle.size() +1, +1 to take care of last row like in DP
      For each element of each row find min of adjacent elements and add element to it.

      For last row elements, lower row would be all zero (initial state of mins array)

     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] mins = new int[triangle.size()+1];
        for(int i = triangle.size()-1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size() ; j++){
                mins[j] = Math.min(mins[j],mins[j+1])+triangle.get(i).get(j);
            }
        }
        return mins[0];
    }
}
