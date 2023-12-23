package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1496_PathCrossing {

    public static void main(String[] args) {
        _1496_PathCrossing obj = new _1496_PathCrossing();

        String path = "NESWW";
        System.out.println(obj.isPathCrossing(path));
    }

    public boolean isPathCrossing(String path) {
        Set<String> points = new HashSet<>();
        points.add("0#0");  //add starting point

        int x = 0, y = 0;
        for (char ch : path.toCharArray()) {
            if (ch == 'N') {
                y++;
            } else if (ch == 'S') {
                y--;
            } else if (ch == 'E') {
                x++;
            } else {
                x--;
            }

            if(!points.add(x+"#"+y)) {
                return true; //if set already had this point
            }
        }
        return false;
    }
}
