package leetcode;

import java.util.*;

public class _1424_DiagonalTraverse_II {

    public static void main(String[] args) {
        _1424_DiagonalTraverse_II obj = new _1424_DiagonalTraverse_II();

        List<List<Integer>> nums = List.of(List.of(1,2,3,4,5), List.of(6,7), List.of(8), List.of(9,10,11), List.of(12,13,14,15,16));
        System.out.println(Arrays.toString(obj.findDiagonalOrder(nums)));
    }

    /*
        Approach: DFS
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();

        queue.offer(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            answer.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new int[]{row+1, col});
            }

            if (col+1 < nums.get(row).size()) {
                queue.offer(new int[]{row, col+1});
            }
        }

        int[] result = new int[answer.size()];
        int i = 0;

        //If following loop is replaced with fori, solution times out
        for (int num : answer) {
            result[i] = num;
            i++;
        }
        return result;
    }
}
