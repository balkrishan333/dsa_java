package leetcode;

import java.util.*;

public class _2101_DetonateTheMaximumBombs {

    public static void main(String[] args) {
        _2101_DetonateTheMaximumBombs obj = new _2101_DetonateTheMaximumBombs();

        int[][] bombs = {{2,1,3},{6,1,4}};
        System.out.println(obj.maximumDetonation(bombs));
    }

    /*
        Approach: Consider location of bombs as nodes adn connection between bombs edges. Count the max nodes reachable from each node
        using dfs and take of all nodes and return as answer.

        Key is how do we connect nodes. How do we know that a node is connected to other node. As per problem statement, if a bomb is in
        range of other bomb they are connected. Use Ecludian's distance formula to find if a node is reachable from  other or not.

        Build a graph of connectivity using Ecludian's distance and use this graph to count the max depth from a node.
     */
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ix = bombs[i][0], iy = bombs[i][1], ir = bombs[i][2];
            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                int jx = bombs[j][0], jy = bombs[j][1];

                /*
                    Ecludian's distance -> (distance)^2 = (x1-x2)^2 + (y1-y2)^2

                    Distance is radius of source node. If LHS is more than equal to RHS, that means nodes are connected.
                 */
                if ((long)ir*ir >=  (long)(ix-jx)*(ix-jx) + (long)(iy-jy)*(iy-jy)) {
                    graph.putIfAbsent(i, new ArrayList<>());
                    graph.get(i).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<>(), graph);
            answer = Math.max(answer, count);
        }
        return answer;
    }

    private int dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        int count = 1;
        visited.add(node);

        for (int adjacentNode : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(adjacentNode)) {
                visited.add(adjacentNode);
                //take cunt as sum of all reach nodes from this node
                count += dfs(adjacentNode, visited, graph);
            }
        }
        return count;
    }
}
