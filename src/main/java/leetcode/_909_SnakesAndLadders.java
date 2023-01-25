package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _909_SnakesAndLadders {

    public static void main(String[] args) {
        _909_SnakesAndLadders obj = new _909_SnakesAndLadders();

        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        System.out.println(obj.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];

        //explore each cell
        for (int move = 0; !queue.isEmpty(); move++) {
            //for each cell explore all possibilities
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if (visited[num]) {
                    continue;
                }
                visited[num] = true;

                if (num == n * n) {
                    //return if we reach to last cell(top right) on board
                    return move;
                }

                //from each cell there are 6 possibilities, as there are 6 faces on a dice
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i; //by default next is current + dice value
                    int val = getNext(board, next); // check if the next has ladder or snake

                    if (val > 0) {
                        next = val;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    int getNext(int[][] board, int num) {

        int n = board.length;
        int r = (num - 1) / n; //find row
        int row = n - 1 - r; //n-1 because matrix is in reverse order, rows with higher number at top

        // r*n == no of elements in earlier rows
        int col = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[row][col];
    }
}
