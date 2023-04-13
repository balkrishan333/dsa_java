package leetcode;

import java.util.*;

public class _1857_LargestColorValueInADirectedGraph {

//    private int answer = 0;

    public static void main(String[] args) {
        _1857_LargestColorValueInADirectedGraph obj = new _1857_LargestColorValueInADirectedGraph();

        String colors = "abaca";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
//        String colors = "bbbhb";
//        int[][] edges = {{0,2},{3,0},{1,3},{4,1}};
        System.out.println(obj.largestPathValue(colors, edges));
    }

    /*
        Approach: Use topological sort to find cycle in graph. If cycle exists return -1 else return count.

        See inline comments
     */
    public int largestPathValue(String colors, int[][] edges) {
        int[] inDegree = new int[colors.length()];

        //build graph and calculate in degree of each node for topological sort
        List<Integer>[] graph = buildGraph(colors, edges, inDegree);

        return findAnswer(graph, inDegree, colors);
    }

    private List<Integer>[] buildGraph(String colors, int[][] edges, int[] inDegree) {
        int nodes = colors.length();
        List<Integer>[] graph = new List[nodes];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]); // since graph is directed, add edge only in one direction, src -> dest
            inDegree[edge[1]]++; // increase degree of dest node
        }
        return graph;
    }

    private int findAnswer(List<Integer>[] graph, int[] inDegree, String colors) {
        Queue<Integer> queue = new LinkedList<>();
        int nodesCount = 0; //count of nodes seen with degree zero

        //find nodes with degree 0 and add to queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                nodesCount++; //increase node count as degree is zero
            }
        }

        int answer = 0;
        int[][] count = new int[colors.length()][26]; //2D array to keep count of each character for each node

        while (!queue.isEmpty()) {
            int node = queue.poll();

            count[node][colors.charAt(node)- 'a']++; //increase char count for current node
            answer = Math.max(answer, count[node][colors.charAt(node)- 'a']); //find max so far

            List<Integer> edges = graph[node];
            for (int edge : edges) {

                //for all nodes, update char count to include char from parent and take max
                for (int i = 0; i < 26; i++) {
                    count[edge][i] = Math.max(count[node][i], count[edge][i]);
                }

                inDegree[edge]--;
                if (inDegree[edge] == 0) { //if new degree is zero add to queue
                    queue.add(edge);
                    nodesCount++; //increase node count as degree is zero
                }
            }
        }

        //if graph has no cycle, all nodes will have degree 0 at some point. If no. of nodes with degree 0 are less than total nodes,
        // graph has cycle, return -1
        return nodesCount < colors.length() ? -1 : answer;
    }
}
