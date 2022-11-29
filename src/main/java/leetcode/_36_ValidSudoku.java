package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _36_ValidSudoku {

    public static void main(String[] args) {
        _36_ValidSudoku obj = new _36_ValidSudoku();

        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(obj.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && (!seen.add("Element " + board[i][j] + " in row " + i) ||
                    !seen.add("Element " + board[i][j] + " in col " + j) ||
                     !seen.add("Element " + board[i][j] + " in block " + i/3 + "-" + j/3))) {
                    return false;
                }
            }
        }
        return true;
    }
}
