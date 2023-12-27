package leetcode;

import java.util.PriorityQueue;

public class _1578_MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        _1578_MinimumTimeToMakeRopeColorful obj = new _1578_MinimumTimeToMakeRopeColorful();

        String color = "abaacccc";
        int[] neededTime = {1,2,3,4,5,4,3,2};
        System.out.println(obj.minCost(color, neededTime));
    }

    public int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> time = new PriorityQueue<>();

        char prev = colors.charAt(0);
        time.add(neededTime[0]);

        int timeRequired = 0;

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == prev) {
                time.add(neededTime[i]);
            } else {
                timeRequired += calcTime(time);
                prev = colors.charAt(i);
                time.add(neededTime[i]);
            }
        }
        return timeRequired + calcTime(time);
    }

    private int calcTime(PriorityQueue<Integer> time) {
        int timeRequired = 0;
        int last = 0;
        while (!time.isEmpty()) {
            last = time.poll();
            timeRequired += last;
        }
        return timeRequired - last;
    }
}
