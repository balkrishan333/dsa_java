package geekforgeeks;


/*
https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatInAMazeProblem_I {

    private static final Map<String, Integer[]> directions = new HashMap<>();

    static {
        directions.put("U", new Integer[]{-1, 0});
        directions.put("D", new Integer[]{1, 0});
        directions.put("L", new Integer[]{0, -1});
        directions.put("R", new Integer[]{0, 1});
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        row1.add(0);
        row1.add(0);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        row2.add(0);
        row2.add(1);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(1);
        row3.add(0);
        row3.add(0);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(0);
        row4.add(1);
        row4.add(1);
        row4.add(1);

        mat.add(row1);
        mat.add(row2);
        mat.add(row3);
        mat.add(row4);

        RatInAMazeProblem_I ratInAMazeProblem_i = new RatInAMazeProblem_I();
        System.out.println(ratInAMazeProblem_i.findPath(mat));

    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();
        ArrayList<String> paths = new ArrayList<>();

        //check if (0,0) is blocked
        if (mat.get(0).get(0) == 0) {
            return paths;
        }
        solveMaze(mat, 0, 0, n, "", paths);
        return paths;
    }

    private void solveMaze(ArrayList<ArrayList<Integer>> mat, int x, int y, int n, String path, List<String> paths) {
        if (isSolved(x, y, n)) {
            paths.add(path);
            return;
        }

        if (isValid(x, y, n, mat)) {
            mat.get(x).set(y, 0); //mark the cell visited

            for (Map.Entry<String, Integer[]> entry :  directions.entrySet()) {
                String direction = entry.getKey();
                Integer[] dir = entry.getValue();
                int newX = x + dir[0];
                int newY = y + dir[1];

                solveMaze(mat, newX, newY, n, path + direction, paths);
            }
            mat.get(x).set(y, 1);
        }
    }

    private boolean isSolved(int x, int y, int n) {
        return x == n-1 && y == n-1;
    }

    private boolean isValid(int x, int y, int n, ArrayList<ArrayList<Integer>> mat) {
        return x >= 0 && x < n && y >= 0 && y < n && mat.get(x).get(y) == 1;
    }
}
