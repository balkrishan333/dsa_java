package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2359_FindClosestNodeToGivenTwoNodes {

    public static void main(String[] args) {
        _2359_FindClosestNodeToGivenTwoNodes obj = new _2359_FindClosestNodeToGivenTwoNodes();

        int[] edges = {2,2,3,-1};
        int node1 = 0;
        int node2 = 1;

//        int[] edges = {1,2,-1};
//        int node1 = 0;
//        int node2 = 2;

        System.out.println(obj.closestMeetingNode(edges, node1, node2));
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(node1);
        l2.add(node2);

        traverse(edges, node1, l1);
        traverse(edges, node2, l2);

        int min = -1;
        int answer = -1;
        int aMax = -1, bMax = -1;

        for (int node=0; node <l1.size(); node++) {
            int index = l2.indexOf(l1.get(node));
            if (index != -1) {

                int aTmp = Math.max(aMax, node);
                if (aTmp != aMax) {
                    aMax = aTmp;
                }

                int bTmp = Math.max(bMax, index);
                if (bTmp != bMax) {
                    bMax = bTmp;
                }
                if(min < (node + l2.subList(0, index+1).size()-1)) {
                    answer = l1.get(node);
                    min =  node + l2.subList(0, index+1).size()-1;
                }
            }
        }
        return answer;
    }

    private void traverse(int[] edges, int node, List<Integer> graph) {
        boolean[] visited = new boolean[edges.length];
        int i = node;
        while (edges[i] != -1 && !visited[i]) {
            visited[i] = true;
            graph.add(edges[i]);
            i = edges[i];
        }
    }
}
