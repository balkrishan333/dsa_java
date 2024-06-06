package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _846_HandOfStraights {

    public static void main(String[] args) {
        _846_HandOfStraights obj = new _846_HandOfStraights();

        int[] hand = {1,1,2,2,3,3};
        int groupSize = 3;
        System.out.println(obj.isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        int startHand = Integer.MAX_VALUE;

        for (int h : hand) {
            count.merge(h, 1, Integer::sum);
            startHand = Math.min(startHand, h);
        }

        while (!count.isEmpty()) {

            while (count.getOrDefault(startHand, 0) == 0) {
                startHand++;
            }

            for (int i = 0; i < groupSize ; i++) {
                int nextHand = i + startHand;

                if (count.getOrDefault(nextHand, 0) > 0) {
                    count.merge(nextHand, -1, Integer::sum);
                    if (count.get(nextHand) == 0) {
                        count.remove(nextHand);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
