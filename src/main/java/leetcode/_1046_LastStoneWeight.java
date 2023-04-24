package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class _1046_LastStoneWeight {

    public static void main(String[] args) {
        _1046_LastStoneWeight obj = new _1046_LastStoneWeight();

        int[] stones = {2,7,4,1,8,1};
        System.out.println(obj.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() >= 2) {
            int w1 = pq.poll();
            int w2 = pq.poll();

            if (w1 != w2) {
                pq.add(w1-w2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
