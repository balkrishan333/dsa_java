package leetcode;

import java.util.*;

public class _332_ReconstructItinerary {

    public static void main(String[] args) {
        _332_ReconstructItinerary obj = new _332_ReconstructItinerary();

        List<List<String>> tickets = new LinkedList<>();

        tickets.add(List.of("JFK","SFO"));
        tickets.add(List.of("JFK","ATL"));
        tickets.add(List.of("SFO","ATL"));
        tickets.add(List.of("ATL","JFK"));
        tickets.add(List.of("ATL","SFO"));

        System.out.println(obj.findItinerary(tickets));
    }

    private final LinkedList<String> result = new LinkedList<>();
    private final Map<String, PriorityQueue<String>> adjacencyList = new HashMap<>();

    /*
        Approach: DFS
     */
    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            adjacencyList.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        dfs("JFK");
        return result;
    }

    private void dfs(String node) {
        PriorityQueue<String> adjacentNodes = adjacencyList.getOrDefault(node, new PriorityQueue<>());
        while (!adjacentNodes.isEmpty()) {
            dfs(adjacentNodes.poll());
        }
        result.addFirst(node);
    }
}
