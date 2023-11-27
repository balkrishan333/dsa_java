package leetcode;

public class _935_KnightDialer {

    public static void main(String[] args) {
        _935_KnightDialer obj = new _935_KnightDialer();

        int n = 2;
        System.out.println(obj.knightDialer(n));
    }

    private final int MOD = (int)1e9+7;
    private int[][] memo;
    private final int[][] jumps = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {3, 9, 0},
            {},
            {1, 7, 0},
            {2, 6},
            {1, 3},
            {2, 4}
    };
    public int knightDialer(int n) {
        memo = new int[n+1][10];
        int answer = 0;

        for (int square = 0; square < 10; square++) {
            answer = (answer + dp(n-1, square)) % MOD;
        }

        return answer;
    }

    private int dp(int remain, int nextSquare) {
        if (remain == 0) {
            return 1;
        }

        if (memo[remain][nextSquare] != 0) {
            return memo[remain][nextSquare];
        }

        int answer = 0;
        for (int next : jumps[nextSquare]) {
            answer = (answer + dp(remain-1, next)) % MOD;
        }

        memo[remain][nextSquare] = answer;

        return answer;
    }
}
