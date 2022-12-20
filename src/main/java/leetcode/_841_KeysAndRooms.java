package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841_KeysAndRooms {

    public static void main(String[] args) {
        _841_KeysAndRooms obj = new _841_KeysAndRooms();
        List<Integer> l1 = List.of(1,3);
        List<Integer> l2 = List.of(3,0,1);
        List<Integer> l3 = List.of(2);
        List<Integer> l4 = List.of(0);

        List<List<Integer>> rooms = List.of(l1, l2, l3, l4);

        System.out.println(obj.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] keyFound = new boolean[rooms.size()];
        keyFound[0] = true;

        Queue<Integer> queue = new LinkedList<>(rooms.get(0));

        while (!queue.isEmpty()) {
            int key = queue.poll();
            keyFound[key] = true;
            for (int key2 : rooms.get(key)) {
                if (key2 != key && !keyFound[key2]) {
                    queue.add(key2);
                }
            }
        }

        for (boolean key : keyFound) {
            if (!key) {
                return false;
            }
        }

        return true;
    }
}
