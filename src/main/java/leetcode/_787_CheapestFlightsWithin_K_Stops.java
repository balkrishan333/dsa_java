package leetcode;

import java.util.*;

public class _787_CheapestFlightsWithin_K_Stops {

    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        _787_CheapestFlightsWithin_K_Stops obj = new _787_CheapestFlightsWithin_K_Stops();

        int n = 4;
        int src = 0, dst =3, k =1;
        int[][] flights = {{0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };

      /*  int n = 5;
        int src = 2, dst = 1, k = 1;
        int[][] flights = {{0, 1, 100},
                {4, 1, 1},
                {1, 2, 3},
                {0, 3, 2},
                {0, 4, 10},
                {3, 1, 1},
                {1, 4, 3}
        };*/

        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            //initialize all with empty list, to avoid NPE
            graph.put(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            //get existing flights for src from graph and add current
            List<int[]> srcFlights = graph.get(flight[0]);
            srcFlights.add(flight);
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{src, 0});

        int stops = 0;
        while (stops <= k && !pq.isEmpty()) { //iterate while no. of stops are less than k and queue is not empty
            int size = pq.size(); //iterate only for current elements in list and skip newly added in this iteration
            while (size > 0) {
                int[] node = pq.poll();

                int dist = node[1];
                //get all flights
                for (int[] flight : graph.get(node[0])) {
                    int flightCost = flight[2]; // get cost to destination as this is the node to which we are arriving
                    int newCost = dist + flightCost;

                    //if new cost is less current cost, update it and put the node back in queue
                    if (newCost < cost[flight[1]]) {
                        cost[flight[1]] = newCost;
                        pq.add(new int[]{flight[1], newCost});
                    }
                }
                size--;
            }
            stops++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    //Following implementation also seems correct. Passed 35 test cases. Debug to find why test case failed.
    /*public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] flight : flights) {
            List<int[]> srcFlights = graph.get(flight[0]);
            srcFlights.add(flight);
        }

        boolean[] visited = new boolean[n];
        for (int[] flight : graph.get(src)) {
            dfs(flight, k, 0, 0, dst, graph, visited);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(int[] flight, int k, int stops, int cost, int dest, Map<Integer, List<int[]>> graph, boolean[] visited) {

        if (visited[flight[1]] || stops > k) {
            return;
        }

        visited[flight[0]] = true;
        cost += flight[2];

        if (flight[1] == dest) {
            min = Math.min(min, cost);
            return;
        }

        int prevCost = cost;
        for (int[] hopFlight : graph.get(flight[1])) {
            dfs(hopFlight, k, stops + 1, prevCost, dest, graph, visited);
        }
    }*/
}
