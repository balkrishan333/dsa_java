package leetcode;

public class _1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

    public static void main(String[] args) {
        _1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold obj =
                new _1292_MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();

        int[][] mat = {
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2},
                {1,1,3,2,4,3,2}
        };
        int threshold = 4;
        System.out.println(obj.maxSideLength(mat, threshold));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefix = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i-1][j-1]
                        + prefix[i-1][j]
                        + prefix[i][j-1]
                        -prefix[i-1][j-1];
            }
        }

        int ans = 0;
        int left = 1;
        int right = Math.min(m,n);

        while (left <= right) {
            int mid = (right + left) / 2;
            boolean found = false;

            //mid is the size of the square
            for (int i = 1; i <= m - mid + 1; i++) {
                for (int j = 1; j <= n - mid + 1; j++) {
                    int sum = prefix[i+mid-1][j+mid-1]
                            - prefix[i-1][j+mid-1]
                            -prefix[i+mid-1][j-1]
                            +prefix[i-1][j-1];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
