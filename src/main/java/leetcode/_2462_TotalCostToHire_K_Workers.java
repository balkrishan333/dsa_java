package leetcode;

import java.util.PriorityQueue;

public class _2462_TotalCostToHire_K_Workers {

    public static void main(String[] args) {
        _2462_TotalCostToHire_K_Workers obj = new _2462_TotalCostToHire_K_Workers();

//        int[] costs = {17,12,10,2,7,2,11,20,8};
//        int k = 3, candidates = 4;
        int[] costs = {25,65,41,31,14,20,59,42,43,57,73,45,30,77,17,38,20,11,17,65,55,85,74,32,84};
        int k = 24, candidates = 8;
        System.out.println(obj.totalCost(costs, k, candidates));
    }

    /*
        Approach: 2 -Priority queue to find minimum
     */
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> headPQ = new PriorityQueue<>();
        PriorityQueue<Integer> tailPQ   = new PriorityQueue<>();

        long cost = 0; int nextHead = candidates, nextTail = n-candidates-1;

        for (int i = 0; i < candidates; i++) {
            headPQ.add(costs[i]);
        }

        //take max of candidates and n-candidates to make sure we add at least candidates elements in PQ
        for (int i = Math.max(candidates, n - candidates); i < n; i++) {
            tailPQ.add(costs[i]);
        }

        while (k > 0) {

            if (tailPQ.isEmpty() || (!headPQ.isEmpty() && headPQ.peek() <= tailPQ.peek())) {
                cost += headPQ.poll();
                if (nextHead <= nextTail) {
                    headPQ.add(costs[nextHead]);
                    nextHead++;
                }
            } else {
                cost += tailPQ.poll();
                if (nextHead <= nextTail) {
                    tailPQ.add(costs[nextTail]);
                    nextTail--;
                }
            }
            k--;
        }
        return cost;
    }
}
