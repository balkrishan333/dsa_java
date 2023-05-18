package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1557_MinimumNumberOfVerticesToReachAllNodes {

    public static void main(String[] args) {
        _1557_MinimumNumberOfVerticesToReachAllNodes obj = new _1557_MinimumNumberOfVerticesToReachAllNodes();

        int n = 6;
        List<List<Integer>> edges = List.of(List.of(0,1), List.of(0,2), List.of(2,5),List.of(3,4),List.of(4,2));
        System.out.println(obj.findSmallestSetOfVertices(n, edges));
    }

    /*
        Approach:
        Since graph has no cycles and is directed, Only edges which can't be reached from any other edges are the one's which have no
        incoming edge. We will need to visit at least those number of nodes which have no incoming edge and all other edges can be
        reached from at least anyone of these edges.

        So, we find the nodes with no incoming edges and return.

     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        boolean[] hasInComingEdge = new boolean[n];

        for (List<Integer> edge : edges) {
            hasInComingEdge[edge.get(1)] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!hasInComingEdge[i]) {
                answer.add(i);
            }
        }
        return answer;
    }
}
