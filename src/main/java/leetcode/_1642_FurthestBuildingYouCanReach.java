package leetcode;

import java.util.PriorityQueue;

public class _1642_FurthestBuildingYouCanReach {

    public static void main(String[] args) {
        _1642_FurthestBuildingYouCanReach obj = new _1642_FurthestBuildingYouCanReach();

        int[] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 10, ladders = 2;

        System.out.println(obj.furthestBuilding(heights, bricks, ladders));
    }

    /*
        if new building is greater than previous
        - Add the difference to queue
        - Keep on adding until difference is less than ladders. Idea is ladder should be used for largest differences
        - if size of queue is more than ladders, that means, we don't have sufficient queues and need to use bricks
        - Remove the top of queue and reduce the no of bricks

        Why removing top from queue works

        When adding to queue, the smallest element will be at top of queue, as it's a priority queue
        This element is there in queue that means, there are 2 building with this difference
        and these many bricks can be used.

     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i-1];
            if (diff > 0) {
                queue.offer(diff);

                if (queue.size() > ladders) {
                    bricks -= queue.poll();
                }
                if (bricks < 0) {
                    return i-1;
                }
            }
        }
        return heights.length-1;
    }
}
