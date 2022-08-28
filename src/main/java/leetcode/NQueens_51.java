package leetcode;

import java.util.Arrays;
import java.util.List;

public class NQueens_51 {

    public static void main(String[] args) {
        NQueens_51 obj = new NQueens_51();

        int n = 4;
        obj.solveNQueens(n);
    }

    public List<List<String>> solveNQueens(int n) {
        int[] pos = new int[n];
        Arrays.fill(pos, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean conflict = checkConflict(pos, i, j);
                if (!conflict) {
                    pos[i] = j;
                    break;
                }

                if (j == n-1) {
                    if (i > 0) {
                        pos[i-1]++;
                        i = i-1;
                    }

                    break;
                }
            }
        }
        System.out.println(Arrays.toString(pos));
        return null;
    }

    private boolean checkConflict(int[] pos, int col, int row) {
        for (int i = 0; i < col ; i++) {
            //check same row
            if (pos[i] == row ) {
                return true;
            }
        }

        for (int i = 0; i < col; i++) {
            int prevCol = i;
            int prevRow = pos[i];
            int k = 1;
            while (true) {
                if (prevRow+k >= pos.length && prevCol+k >= pos.length) {
                    break;
                }
                if (prevRow+k == row && prevCol+k == col) {
                    return false;
                }
                k++;
            }

            k = -1;
            while (true) {
                if (prevRow+k < 0 && prevCol+k < 0) {
                    break;
                }
                if (prevRow+k == row && prevCol+k == col) {
                    return false;
                }
                k--;
            }

            int rowk = 1, colk = -1;
            while (true) {
                if (prevRow+rowk >= pos.length || prevCol+colk < 0) {
                    break;
                }
                if (prevRow+rowk == row && prevCol+colk == col) {
                    return false;
                }
                k--;
            }
        }
        return false;
    }
}
