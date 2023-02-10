package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1162_AsFarFromLandAsPossible {

    public static void main(String[] args) {
        _1162_AsFarFromLandAsPossible obj = new _1162_AsFarFromLandAsPossible();

        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(obj.maxDistance(grid));
    }

    /*
        Approach:
        We need to find water cell with max distance from land cell.

        Use BFS. Start from cells containing 1. Why not start from cells containing 0 because that would mean for
        every cell we have search entire graph. By starting with 1, we are assured that we won't be visiting at least
        0 cells again.

        BFS is level by level traversal. After each level increase the distance by 1. Check in all four directions - left
        right, top, bottom.

     */
    public int maxDistance(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length]; // mark which cells have been already been visited
        Queue<int[]> queue = new LinkedList<>();

        //put 1 cells into queue to start with and mark then visited
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i,j});
                    visited[i][j] = true; //mark cell as visited
                }
            }
        }

        int distance = -1;
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}}; //all possible 4 directions
        while (!queue.isEmpty()) {
            int size = queue.size(); //since this is BFS we need to traverse level by level

            while (size > 0) { //iterate only till nodes in current level
                int[] pair = queue.poll();

                for (int[] direction : directions) { // check in all possible directions
                    int x = pair[0] + direction[0];
                    int y = pair[1] + direction[1];

                    //if target cell is with in bounds and is not visited, add it to queue
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]) {
                        queue.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
                size--;
            }
            distance++; //increment the size only after level traversal is complete
        }

        //this is required because distance can be zero. This is possible if grid contains all 1's and all 1's are
        //consider level 1 as we are starting with them. So, need to return -1
        return distance == 0 ? -1 : distance;
    }
}
