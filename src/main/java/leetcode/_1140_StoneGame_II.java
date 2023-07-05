package leetcode;

public class _1140_StoneGame_II {

    public static void main(String[] args) {
        _1140_StoneGame_II obj = new _1140_StoneGame_II();

        int[] piles = {2,7,9,4,4};
//        int[] piles = {1};
        System.out.println(obj.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length+1][piles.length+1];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= piles.length; j++) {
                for (int k = 0; k <= piles.length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return minimax(true, piles, 0, 1, dp);
    }

    private int minimax(boolean playerAlice, int[] piles, int start, int m, int[][][] dp) {

        if (start == piles.length) {
            return 0;
        }

        int player = playerAlice ? 0 : 1;
        if (dp[player][start][m] != -1) {
            return dp[player][start][m];
        }

        int result = playerAlice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 1; i <= Math.min(2*m, piles.length-start); i++) {
            sum += piles[start+i-1];

            if (playerAlice) {
                result = Math.max(result, sum + minimax(false, piles, start+i, Math.max(i, m), dp));
            } else {
                result = Math.min(result, minimax(true, piles, start+i, Math.max(i, m), dp));
            }
        }

        dp[player][start][m] = result;

        return result;
    }
}
