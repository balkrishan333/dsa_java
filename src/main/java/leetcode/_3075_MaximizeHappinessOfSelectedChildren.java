package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _3075_MaximizeHappinessOfSelectedChildren {

    public static void main(String[] args) {
        _3075_MaximizeHappinessOfSelectedChildren obj = new _3075_MaximizeHappinessOfSelectedChildren();

        int[] happiness = {1,2,3};
        int k = 2;
        System.out.println(obj.maximumHappinessSum(happiness, k));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : happiness) {
            maxHeap.offer(num);
        }

        int i = 0;
        long answer = 0L;
        while (!maxHeap.isEmpty() && i < k) {
            int curr = maxHeap.poll() - i;
            answer = answer + (Math.max(curr, 0));
            i++;
        }
        return answer;
    }
}
