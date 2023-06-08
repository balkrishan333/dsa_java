package leetcode;

public class _1351_CountNegativeNumbersInASortedMatrix {

    public static void main(String[] args) {
        _1351_CountNegativeNumbersInASortedMatrix obj = new _1351_CountNegativeNumbersInASortedMatrix();

        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//        int[][] grid = {{1,-1},{-1,-1}};
        System.out.println(obj.countNegatives(grid));
    }

    /*
        Approach: Binary Search
     */
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;

        int count = 0;
        for (int[] row : grid) {
            int left = 0, right = n-1;

            while (left <= right) {
                int mid = (left + right) /2;

                if (row[mid] < 0) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }

            if (left < n) {
                count += n - left;
            }
        }
        return count;
    }
}
