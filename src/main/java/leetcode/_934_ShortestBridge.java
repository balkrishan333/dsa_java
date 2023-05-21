package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _934_ShortestBridge {

    private List<int[]> queue = new ArrayList<>();
    public static void main(String[] args) {
        _934_ShortestBridge obj = new _934_ShortestBridge();

        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(obj.shortestBridge(grid));
    }

    /*
        Approach:

        Step1: identify 2 islands
        step2: From each cell in island 2, try to reach to 2nd island
        Step3: return the shortest distance
     */
    public int shortestBridge(int[][] grid) {

        //identify first land cell (1) in grid
        int firstX = -1, firstY=-1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }

        //DFS and mark all cells of first island as 2 and add them to queue
        dfs(grid, firstX, firstY, grid.length);

        //BFS and find the shortest path to 2nd island
        int distance = 0;
        while (!queue.isEmpty()) {
            List<int[]> queue2 = new ArrayList<>();

            for (int[] ele : queue) {
                int x = ele[0];
                int y = ele[1];

                for(int[] pair : new int[][]{{x+1,y}, {x-1,y}, {x,y+1}, {x,y-1}}) {
                    int currX = pair[0];
                    int currY = pair[1];
                    if (currX >= 0 && currY >= 0 && currX < grid.length && currY < grid.length ) {
                        if (grid[currX][currY] == 1) {
                            return distance;
                        } else if (grid[currX][currY] == 0) {
                            //distance till this cell is distance, in next round we need to check the connectivity from this cell and
                            // distance in next round will be distance+1
                            queue2.add(pair);
                            grid[currX][currY] = -1;
                        }
                    }
                }
            }
            queue = queue2;
            distance++;
        }
        return distance;
    }

    private void dfs(int[][] grid, int x, int y, int n) {
        queue.add(new int[]{x, y});
        grid[x][y] = 2;

        for(int[] pair : new int[][]{{x+1,y}, {x-1,y}, {x,y+1}, {x,y-1}}) {
            int nextX = pair[0];
            int nextY = pair[1];
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && grid[nextX][nextY] == 1) {
                dfs(grid, nextX, nextY, n);
            }
        }
    }
}
