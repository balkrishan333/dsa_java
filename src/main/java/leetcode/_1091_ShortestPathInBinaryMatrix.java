package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1091_ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        _1091_ShortestPathInBinaryMatrix obj = new _1091_ShortestPathInBinaryMatrix();

        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(obj.shortestPathBinaryMatrix(grid));
    }

    private final Queue<int[]> queue = new LinkedList<>();
    /*
        Approach: BFS in all 8 possible directions
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        queue.add(new int[]{0,0});
        return bfs(grid, n, visited);
    }

    private int bfs(int[][] grid, int n, boolean[][] visited) {

        int minLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currCell = queue.poll();

                int x = currCell[0];
                int y = currCell[1];

                if (x == n-1 && y == n-1) {
                    return minLength+1;
                }

                for (int[] pair : new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, {-1,-1}, {-1,1},{1,-1}, {1,1}}) {
                    int newX = x + pair[0];
                    int newY = y + pair[1];

                    if(newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && grid[newX][newY]==0) {
                        queue.add(new int[]{newX,newY});
                        visited[newX][newY]=true;
                    }
                }
            }
            minLength++;
        }
        return -1;
    }
}
