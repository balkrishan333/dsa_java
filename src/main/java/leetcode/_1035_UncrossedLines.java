package leetcode;

public class _1035_UncrossedLines {

    public static void main(String[] args) {
        _1035_UncrossedLines obj = new _1035_UncrossedLines();

        int[] nums1 = {2,1};
        int[] nums2 = {1,2,1,3,3,2};
        System.out.println(obj.maxUncrossedLines(nums1, nums2));
    }

    /*
        Approach: DP

        If 2 numbers match on same index increase the count and move both indexes else increase one pointer and keep other same and take
        max of both of them.
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                //if both numbers are same increment the count
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    //if numbers at current indexes are not same, increment one index at a time and take max of 2
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
