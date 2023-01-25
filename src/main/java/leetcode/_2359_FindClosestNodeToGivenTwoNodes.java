package leetcode;

import java.util.Arrays;

public class _2359_FindClosestNodeToGivenTwoNodes {

    public static void main(String[] args) {
        _2359_FindClosestNodeToGivenTwoNodes obj = new _2359_FindClosestNodeToGivenTwoNodes();

//        int[] edges = {2,2,3,-1};
//        int node1 = 0;
//        int node2 = 1;

        int[] edges = {1,2,-1};
        int node1 = 0;
        int node2 = 2;

        System.out.println(obj.closestMeetingNode(edges, node1, node2));
    }

    /*
        1. Find distance to every node from given nodes
        2. Find intersection of nodes which can be reached from both nodes
        3. At each step
            - Find max distance given nodes
            - Choose Min of all such combinations
     */
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        //calculate distance to each node from given node. Initial though was why we need to calculate for all nodes
        //but this is beneficial in next step when trying to figure out common nodes which can be traversed from
        //given nodes. To find common nodes, we just need to check if dist of any node is default value. If yes
        //node is not reachable from given node.
        dfs(edges, dist1, node1);
        dfs(edges, dist2, node2);

        int max = Integer.MAX_VALUE, node = -1;

        for (int i = 0; i < n; i++) {
            //this being true means nodes is not part of intersection
            if (dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) {
                continue;
            }

            if (max > Math.max(dist1[i], dist2[i])) {
                //Replace max, if new
                max = Math.max(dist1[i], dist2[i]);
                node = i;
            }
        }

        return node;
    }

    private void dfs(int[] edges, int[] dist, int node) {
        dist[node] = 0;
        int i = node;

        while (edges[i] != -1 && dist[edges[i]] == Integer.MAX_VALUE) {
            dist[edges[i]] = dist[i] + 1;
            i = edges[i];
        }
    }
}
