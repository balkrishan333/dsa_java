package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2352_EqualRowAndColumnPairs {

    public static void main(String[] args) {
        _2352_EqualRowAndColumnPairs obj = new _2352_EqualRowAndColumnPairs();

        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(obj.equalPairs(grid));
    }

    /*
        Approach: Calculate hash for each row and column and compare them
     */
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rowHashes = new HashMap<>();
        Map<String, Integer> colHashes = new HashMap<>();

        //calculate row hashes
        for (int[] row : grid) {
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                key.append(row[i]).append("#");
            }
            rowHashes.merge(key.toString(), 1, Integer::sum);
        }

        //calculate col hashes
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                key.append(grid[j][i]).append("#");
            }
            colHashes.merge(key.toString(), 1, Integer::sum);
        }

        int answer = 0;

        for(Map.Entry<String, Integer> entry : rowHashes.entrySet()) {
            int count = colHashes.getOrDefault(entry.getKey(), 0);
            answer += entry.getValue() * count; // multiply to account for duplicate row and colum. If 2 rows or columns are same they
            // will have same hash and we need to consider that hash multiple times.
        }
        return answer;
    }
}
