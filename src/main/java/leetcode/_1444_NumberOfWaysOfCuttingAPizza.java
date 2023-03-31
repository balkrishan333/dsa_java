package leetcode;

public class _1444_NumberOfWaysOfCuttingAPizza {

    private long count = 0;

    public static void main(String[] args) {
        _1444_NumberOfWaysOfCuttingAPizza obj = new _1444_NumberOfWaysOfCuttingAPizza();

        String[] pizza = {"A..","AAA","..."};
        int k = 3;
        System.out.println(obj.ways(pizza, k));
    }

    /*
        Approach: Use dynamic programming

        See inline comments
     */
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();

        int[][][] dp = new int[k][rows][cols];
        int[][] apples = new int[rows+1][cols+1];

        //count the no. of apples. We count the no. of apples on bottom up manner because we can't cut from bottom we
        // can cut from top only so, after every cut we need to make sure remaining pizza reflects the correct no of
        // apples which are there. To achieve this we start in bottom up manner
        for (int row = rows-1; row >=0 ; row--) {
            for (int col = cols-1; col >=0 ; col--) {

                apples[row][col] = (pizza[row].charAt(col) == 'A' ? 1 : 0) + //if apple is present take 1
                                        apples[row+1][col] + // add no. of apples from row below
                                        apples[row][col+1] - //add no. of apples from right column
                                    apples[row+1][col+1]; //subtract the apples which were added twice in above 2 steps

                //Base case for DP array. if we reach at this row column with zero cut remaining, we check if no of
                // apples are more than zero we mark the cell as one because with no cut remaining there is only 1
                // way to allocate it to user.
                dp[0][row][col] = apples[row][col] > 0 ? 1: 0;
            }
        }

        final int mod = 1000000007; //take mod of this number as mentioned in question

        // We need to make k-1 cuts (to divide the pizza into k parts), iterate one less than k and for each row and
        // each column combination, we check the possibilities. For each cut we need to check each row/col
        // combination because we need to count all possibilities.
        for (int cut = 1; cut < k; cut++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {

                    // for each remaining row, since we are going to allocate the top row to user and work with below
                    // part for rest of the exercise, we check if no of apples are greater than zero and only then
                    // take the rest of pizza into consideration.
                    for (int next_row = row+1; next_row < rows; next_row++) {
                        if (apples[row][col] - apples[next_row][col] > 0) {
                            dp[cut][row][col] += dp[cut-1][next_row][col]; //add the count from previous cut
                            dp[cut][row][col] %= mod;                      //take mode to make sure no if in check
                        }
                    }

                    // for each remaining column, since we are going to allocate the left column to user and work with
                    // right part for rest of the exercise, we check if no of apples are greater than zero and only then
                    // take the rest of pizza into consideration.
                    for (int next_col = col+1; next_col < cols; next_col++) {
                        if (apples[row][col]- apples[row][next_col] > 0) {
                            dp[cut][row][col] += dp[cut-1][row][next_col]; //add the count from previous cut
                            dp[cut][row][col] %= mod;                      //take mode to make sure no if in check
                        }
                    }
                }
            }
        }
        return dp[k-1][0][0];
    }

    /*
        Approach:
        Recursive approach - Does not pass all test cases. Need to debug.

        Break the pizza horizontally and vertically for each cut and count the no of possibilities. Base case for
        recursion is when remaining no of cuts are 0. At that point we check if remaining pizza has at least one
        apple, if yes increase the count
     */
    public int ways_v1(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        char[][] pizzaChar = new char[rows][cols];

        int row = 0, col=0;
        for (String str : pizza) {
            for (char ch : str.toCharArray()) {
                pizzaChar[row][col++] = ch;
            }
            row++;
            col = 0;
        }
        cutPizza(0,0, k-1, pizzaChar, rows, cols);
        return (int)(count % 1000000007);
    }

    private void cutPizza(int topR, int topC, int cuts, char[][] pizza, int rows, int cols) {

        if (topR >= pizza.length || topC >= pizza[0].length) {
            return;
        }

        if (cuts == 0) {
            for (int i = topR; i < pizza.length; i++) {
                for (int j = topC; j < pizza[0].length; j++) {
                    if (pizza[i][j] == 'A') {
                        count++;
                        return;
                    }
                }
            }
            return;
        }

        //horizontal cut
        for (int i = topC; i < cols; i++) {
            if (pizza[topR][i] == 'A') {
                cutPizza(topR+1, topC, cuts-1, pizza, rows-1, cols);
            }
        }

        //vertical cut
        for (int i = topR; i < rows; i++) {
            if (pizza[i][topC] == 'A') {
                cutPizza(topR, topC+1, cuts-1, pizza, rows, cols-1);
            }
        }
    }
}
