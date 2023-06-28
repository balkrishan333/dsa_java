package leetcode;

import java.util.*;

public class _1514_PathWithMaximumProbability {

    public static void main(String[] args) {
        _1514_PathWithMaximumProbability obj = new _1514_PathWithMaximumProbability();

        int[][] edges =  {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int n = 3, start = 0, end = 2;

        System.out.println(obj.maxProbability(n, edges, succProb, start, end));
    }

    /*
        Approach: Dijkstra algorithm. See inline comments
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> graph = new HashMap<>();

        //create graph
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];

            graph.computeIfAbsent(edge[0], f -> new ArrayList<>()).add(new Pair(edge[1], prob));
            graph.computeIfAbsent(edge[1], f -> new ArrayList<>()).add(new Pair(edge[0], prob));
        }

        double[] probability = new double[n]; //keep track of max probability for each node
        probability[start] = 1d; //set the probability of start node to 1 otherwise multiplication with 0 will make everything 0.

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> -p.prob)); //negate, since we need max probability
        pq.add(new Pair(start, 1d)); //put start node in priority queue

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.node == end) {
                return curr.prob; //return if we reach destination
            }

            for (Pair next : graph.getOrDefault(curr.node, new ArrayList<>())) {

                //if path from current node to next node increases the probability, only then add to it to queue otherwise no point
                // considering this path
                if (probability[next.node] < probability[curr.node] * next.prob) {
                    probability[next.node] = probability[curr.node] * next.prob;

                    pq.add(new Pair(next.node, probability[next.node]));
                }
            }
        }
        return 0d;
    }

    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
