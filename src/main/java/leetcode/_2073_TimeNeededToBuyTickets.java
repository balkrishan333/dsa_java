package leetcode;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class _2073_TimeNeededToBuyTickets {

    public static void main(String[] args) {
        _2073_TimeNeededToBuyTickets obj = new _2073_TimeNeededToBuyTickets();

        int[] tickets = {2,3,2};
        int k = 2;
        System.out.println(obj.timeRequiredToBuy(tickets, k));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k]-1, tickets[i]);
            }
        }
        return time;
    }
    public int timeRequiredToBuy_v1(int[] tickets, int k) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(new Pair<>(i, tickets[i]));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.remove();
            count++;
            if (curr.getKey() == k && curr.getValue() == 1) {
                return count;
            }
            if (curr.getValue() > 1) {
                curr = new Pair<>(curr.getKey(), curr.getValue()-1);
                queue.offer(curr);
            }
        }
        return count;
    }
}
