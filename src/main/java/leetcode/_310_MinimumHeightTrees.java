package leetcode;

import java.util.*;

public class _310_MinimumHeightTrees {

    public static void main(String[] args) {
        _310_MinimumHeightTrees obj = new _310_MinimumHeightTrees();
        
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        System.out.println(obj.findMinHeightTrees(n, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            //since edges are bidirectional add for both nodes
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        //identify leaves. Leaves are nodes with degree 1
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) { //there can't be more than 2 Minimum height tree, search more on this ing= gemini
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next(); //it is always 1 for leaves
                adj.get(j).remove(i); //remove the connection of leaf with other node. This will make sure if leaf of removed graph is
                // updates to reflect new state without this leaf

                //is this node the new leaf
                if (adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
