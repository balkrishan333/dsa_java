package leetcode;

public class _1572_MatrixDiagonalSum {

    public static void main(String[] args) {
        _1572_MatrixDiagonalSum obj = new _1572_MatrixDiagonalSum();

        int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(obj.diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int i =0, j =0, k=0, l=n-1;
        int sum = 0;

        for (; i < n && j < n && k < n && l >= 0; i++, j++, k++, l--) {
            sum += mat[i][j];
            sum += mat[k][l];
            if (i == k && j == l) {
                sum -= mat[k][l];
            }
        }
        return sum;
    }
}
