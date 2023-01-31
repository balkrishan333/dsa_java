package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _909_SnakesAndLadders {

    public static void main(String[] args) {
        _909_SnakesAndLadders obj = new _909_SnakesAndLadders();

        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};

        System.out.println(obj.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];

        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if (visited[num]) {
                    continue;
                }
                visited[num] = true;

                if (num == n * n) {
                    return move;
                }
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int val = getNext(board, next);

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
        int r = (num - 1) / n;

        //n-1 because matrix is in reverse order. r would have worked if the matrix was from top to bottom
        // but input matrix is bottom to up
        int row = n - 1 - r;

        // r*n == no of elements in earlier rows
        int col = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[row][col];
    }
}
