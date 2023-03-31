package leetcode;

public class _304_RangeSumQuery2DImmutable {

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

        _304_RangeSumQuery2DImmutable obj = new _304_RangeSumQuery2DImmutable(matrix);
        System.out.println(obj.sumRegion(2,1,4,3));
        System.out.println(obj.sumRegion(1,1,2,2));
        System.out.println(obj.sumRegion(1,2,2,4));
    }

    private final int[][] sum;

    /*
        Approach:
        Calculate sum of each row beforehand.

        Create new 2D array where each element is sum of all previous elements + current element. First element of
        each row is equal to first element in given array

        To find sum of range, find the sum at right index in each row and add to answer and subtract from it sum of
        element which are on left of given range left for each row
     */
    public _304_RangeSumQuery2DImmutable(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            sum[i][0] = matrix[i][0];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sum[i][j] = sum[i][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int answer = 0;
        for (int i = row1; i <= row2; i++) {
            answer += sum[i][col2];
            if (col1 != 0) {
                answer -= sum[i][col1-1];
            }
        }
        return answer;
    }
}
