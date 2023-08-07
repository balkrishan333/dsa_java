package leetcode;

public class _74_SearchA2DMatrix {

    public static void main(String[] args) {
        _74_SearchA2DMatrix obj = new _74_SearchA2DMatrix();

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(obj.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = -1;
        int cols = matrix[0].length;

        for(int i = 0; i < matrix.length; i++) {
            if(target >= matrix[i][0] &&
                    target <= matrix[i][cols-1]) {
                row = i;
                break;
            }
        }

        if(row == -1) {
            return false;
        }

        int lo=0,hi=cols-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;

            if(target == matrix[row][mid]) {
                return true;
            }

            if(target < matrix[row][mid]) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return false;
    }
}
