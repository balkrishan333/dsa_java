package leetcode;

public class _877_StoneGame {

    public static void main(String[] args) {
        _877_StoneGame obj = new _877_StoneGame();

        int[] piles = {5,3,4,5};
        System.out.println(obj.stoneGame(piles));
    }

    /*
        Approach: Use Dynamic programming

        Recursion logic: For both players, take max of choosing first vs last, adjust the start or end accordingly and pass the turn to
        other player.

        use minimax algorithm.
     */
    public boolean stoneGame(int[] piles) {
        int[][][] dp = new int[2][piles.length][piles.length];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < piles.length; j++) {
                for (int k = 0; k < piles.length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return stoneGame(0, piles.length-1, piles, 0, dp) > 0;
    }

    private int stoneGame(int start, int end, int[] piles, int player, int[][][] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[player][start][end] != -1) {
            return dp[player][start][end];
        }

        //For both players, take max of choosing first vs last and adjust the start or end accordingly
        if (player == 0) {
            int st = piles[start] + stoneGame(start+1, end, piles, 1, dp);
            int en = piles[end] + stoneGame(start, end-1, piles, 1, dp);

            //since we are using minimax algorithm, we need to take min for 2nd player and max for first player
            dp[0][start][end] = Math.max(st, en);

        } else {
            //since we are using same variable for both players, first one increases the count and second decreases (that's why -ve sign)
            // and then we check for greater than zero condition
            int st = -piles[start] + stoneGame(start+1, end, piles, 0, dp);
            int en = -piles[end] + stoneGame(start, end-1, piles, 0, dp);

            //since we are using minimax algorithm, we need to take min for 2nd player and max for first player
            dp[1][start][end] = Math.min(st, en);

        }
        return dp[player][start][end];
    }
}
