package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _2477_MinimumFuelCostToReportToTheCapital {

    private long fuel = 0;

    public static void main(String[] args) {
        _2477_MinimumFuelCostToReportToTheCapital obj = new _2477_MinimumFuelCostToReportToTheCapital();

        int[][] roads = {{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        int seats = 2;
        System.out.println(obj.minimumFuelCost(roads, seats));
    }

    /*
        Approach:

        We need to reach top of tree (top os the capital)

        For each subtree, no of edges to traverse is proportional to number of child of subtree however, since seats
        can eb greater than 1, so we might be able to club some nodes and have a combined traversal for them.

        If we combine nodes: no of traversals (fuel) required for that sub tree is:

        ceil(no.of child/seats)

     */
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] graph = new ArrayList[roads.length+1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //build graph for each node from given roads
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        //start from root node i.e 0th node with parent as -1 as there is no parent for this node
        dfs(0, -1, graph, seats);
        return fuel;
    }

    private long dfs(int node, int parent, List<Integer>[] graph, int seats) {

        int children = 1; //initialize the children to 1 to count current node itself
        List<Integer> subtree = graph[node];

        if (subtree.size() == 0) { //if this is leaf node, return the current child count
            return children;
        }

        //iterate of all children
        for (int child : subtree) {
            if (child != parent) { //if any children is equal to parent, skip it
                children += dfs(child, node, graph, seats); //recursively calculate no. of children
            }
        }

        //after child count is done for current node, count fuel required for the subtree
        if (node != 0) { //exclude root, as we need to reach root, so no cost to traverse to itself
            fuel += Math.ceil((double) children/seats);
        }
        return children;
    }
}
