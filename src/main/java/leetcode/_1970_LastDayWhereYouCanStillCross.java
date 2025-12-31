package leetcode;

import java.util.Arrays;

public class _1970_LastDayWhereYouCanStillCross {

    public static void main(String[] args) {
        _1970_LastDayWhereYouCanStillCross obj = new _1970_LastDayWhereYouCanStillCross();

//        int row = 3, col =3;
//        int[][] cells = {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}};
        int row = 2, col =2;
        int [][] cells = {{1,1},{2,1},{1,2},{2,2}};
        System.out.println(obj.latestDayToCross(row, col, cells));
    }

    /*
        Approach: Union Find

        After all cells have been processed all land cells will be converted to water cells.So, we start processing
        cells from end and convert water cells back to land and check when top and bottom row connect. When they
        connect that is the answer. On that day we can cross the grid after that there will be disconnection.

        When we traverse a cell, we see adjacent cells and if any of them is land we union them to be part of same group.

        We keep 2 extra cells, one for top row and one for bottom row and check connectivity for these 2. This helps
        to make sure we don't have to check connectivity of each cell from top row to each cell in bottom row.
     */
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(grid[i], 1);  // 1 = water, 0 = land, Initially everything is water
        }

        UnionFind unionFind = new UnionFind(row*col+2); // 2 extra cells, one for top row and bottom row
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int i = cells.length-1; i >= 0; i--) {
            int currRow = cells[i][0]-1; //-1 because grid is 1 based
            int currCol = cells[i][1]-1; //-1 because grid is 1 based

            /*
                Following step is required to convert 2D array to 1D array because union find works with 1D array
                Each row has col cells and Row r starts after r * col elements. this means a unique id for each cell in the grid

                +1 because top row is placeholder (we added 2 extra cells one at top and one at bottom)
             */
            int currUnionFindIndex = currRow * col + currCol +1;

            grid[currRow][currCol] = 0;
            for (int[] direction : directions) {
                int nextRow = currRow + direction[0];
                int nextCol = currCol + direction[1];

                //union them if next cell is in range and is land cell
                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && grid[nextRow][nextCol] == 0) {
                    int nextUnionFindIndex = nextRow * col + nextCol +1;
                    unionFind.union(currUnionFindIndex, nextUnionFindIndex);
                }

                //if current cell is first row, connect the row with cell representing first row.
                if (currRow == 0) {
                    unionFind.union(0, currUnionFindIndex);
                }
                //if current cell is last row, connect the row with cell representing last row.
                if (currRow == row-1) {
                    unionFind.union(row * col + 1, currUnionFindIndex);
                }
                //if cell representing first and bottom row are in same group, return
                if (unionFind.find(0) == unionFind.find(row * col + 1)) {
                    return i;
                }
            }
        }
        return -1;
    }
    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            rank = new int[n];
        }

        int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return find(parent[node]);
        }

        void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) {
                return;
            }

            if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2;
            } else if (rank[parent2] < rank[parent1]) {
                parent[parent2] = parent1;
            } else {
                parent[parent1] = parent2;
                rank[parent2]++;
            }
        }
    }
}
