package leetcode;

public class _1975_MaximumMatrixSum {

    public static void main(String[] args) {
        _1975_MaximumMatrixSum obj =
                new _1975_MaximumMatrixSum();

        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(obj.maxMatrixSum(matrix));
    }

    /*
        Approach: Though the problem talk about flipping adjacent cells, but since the number of operations are unlimited adjacency
        condition is trivial as with multiple operations -ve sign can be shifted so that both are adjacent.

        Only invariant is, -ve values should maintain their parity.

        if parity of -ve values is even, all can be converted to +ve
        if parity of -ve values is odd, we should keep 1 -ve value and in order to maximize the sum that should be minimum value in matrix.
     */
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negativeCount = 0;
        int minAbsNum = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int num : row) {
                int absNum = Math.abs(num);
                sum += absNum;
                if (num < 0) {
                    negativeCount++;
                }
                minAbsNum = Math.min(minAbsNum, absNum);
            }
        }

        if (negativeCount % 2 == 0) {
            return sum;
        }
        return sum - 2L *minAbsNum; //this is multiplied by 2 because, not only we lose one +ve, we introduce the same -ve as well, so
        // double loss
    }
}
