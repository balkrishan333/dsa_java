package leetcode;

import org.apache.commons.math3.util.Pair;

import java.util.*;

public class _864_ShortestPathToGetAllKeys {

    public static void main(String[] args) {
        _864_ShortestPathToGetAllKeys obj = new _864_ShortestPathToGetAllKeys();

        String[] grid = {"@.a..", "###.#", "b.A.B"};
        System.out.println(obj.shortestPathAllKeys(grid));
    }

    /*
        Approach: BFS

        We can't use normal BFS because with normal BFS we mark a cell visited and never visit again but here we might have to visit the
        cell again to make sure we collect all keys. We might have already visited the cell, but we can visit that again for some other
        key. So we mark a cell as visited for a key i.e. when we mark a cell visited we save some state along with that to indicate for
        which keys this cell has already been visited, and we will not visit that cell again for those keys.
     */
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();

        Queue<int[]> queue = new LinkedList<>();
        int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // key in map is the state of keys seen so far and value is set of cells (row, col pair)
        Map<Integer, Set<Pair<Integer, Integer>>> seen = new HashMap<>();

        int allKeys = 0;
        int startRow = -1, startCol = -1;

        //find the start cell and mark all keys which are present in grid. Track of present keys is kept in an integer by right shifting
        //  1 by index of alphabet (a-0, b-1 etc.)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);
                if (cell >= 'a' && cell <= 'f') {
                    allKeys += (1 << (cell - 'a'));
                }
                if (cell == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // [row, column, key state, distance]
        queue.offer(new int[]{startRow, startCol, 0, 0});
        seen.put(0, new HashSet<>());
        //initially no keys have been seen, so key state is 0
        seen.get(0).add(new Pair<>(startRow, startCol));

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0], curC = cur[1], keys = cur[2], dist = cur[3];
            for (int[] move : moves) {
                int newR = curR + move[0], newC = curC + move[1];

                // If this cell (newR, newC) is reachable and is not a wall
                if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR].charAt(newC) != '#') {
                    char cell = grid[newR].charAt(newC);

                    // If it is a key:
                    if (cell >= 'a' && cell <= 'z') {
                        // If we have collected it before, no need to revisit this cell.
                        if (((1 << (cell - 'a')) & keys) != 0) {
                            continue;
                        }

                        // Otherwise, we can walk to this cell and pick it up.
                        int newKeys = (keys | (1 << (cell - 'a')));

                        // If we collect all keys, return dist + 1.
                        // Otherwise, just add this state to seen and queue.
                        if (newKeys == allKeys) {
                            return dist + 1;
                        }
                        seen.putIfAbsent(newKeys, new HashSet<>());
                        seen.get(newKeys).add(new Pair<>(newR, newC));
                        queue.offer(new int[]{newR, newC, newKeys, dist + 1});
                    }

                    // If it is a lock, and we don't have its key, continue.
                    if (cell >= 'A' && cell <= 'Z' && ((keys & (1 << (cell - 'A'))) == 0)) {
                        continue;
                    }

                    // We can walk to this cell if we haven't been here before with the same key state.
                    else if (!seen.get(keys).contains(new Pair<>(newR, newC))) {
                        seen.get(keys).add(new Pair<>(newR, newC));
                        queue.offer(new int[]{newR, newC, keys, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}
