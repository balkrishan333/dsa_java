package leetcode;

import java.util.PriorityQueue;

public class _45_JumpGame_II {

    public static void main(String[] args) {
        _45_JumpGame_II obj = new _45_JumpGame_II();

        int[] nums = {2,3,1,1,4};
        System.out.println(obj.jump(nums));
    }

    /*
        Approach:

        From current index, find out the max we can reach. Consider, current index to max reach as a window.
        Within  a window we can reach in a single step. because from index from which window is starting has a
        value in array which is the max we can reach from that index in n single step.

        Once you have window, explore window by window. Whenever you reach end of current window
        next window end would be max you can reach from current window.

        starting window is 0,0 i.e. start from index 0, and you can go till that only.
     */
    public int jump(int[] nums) {
        int answer = 0, farthestIndexInWindow = 0, currentWindowEnd = 0;

        for (int i = 0; i < nums.length-1; i++) {

            //max we can reach in current window
            farthestIndexInWindow = Math.max(farthestIndexInWindow, i + nums[i]);

            if (i == currentWindowEnd) {
                //if we reach end of current window, for next window end would be farthest we can reach in this window
                answer++; //when increment only when we move away into next window
                currentWindowEnd = farthestIndexInWindow; // end point for next window
            }
        }
        return answer;
    }

    /*
     BFS approach. Works 82/109 test cases passed but Memory limit exceeded error thrown.

     Push 2 element array into Priority queue, first index of array is index of element and 2nd is cost to reach that index
     */
    public int jump_bfs(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] >= nums.length) {
            return 1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            //if cost is same, return the element with lower index
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        pq.add(new int[]{0, 0});

        int answer = 0;
        while (!pq.isEmpty()) {
            int[] ele = pq.poll();

            for (int i = 0; i < nums[ele[0]]; i++) {
                int[] next = new int[2];
                next[0] = ele[0] + i +1;

                // if end of array is reached, this is the answer. clear the queue as we don't want to explore further
                if (next[0] == nums.length-1) {
                    answer = ele[1]+1;
                    pq.clear();
                    break;
                }
                next[1] = ele[1]+1;

                pq.add(next);
            }
        }
        return answer;
    }
}
