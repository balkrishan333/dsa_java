package leetcode;

import java.util.*;

public class _1697_CheckingExistenceOfEdgeLengthLimitedPaths {

    private int[] groups;
    private int[] rank;

    public static void main(String[] args) {
        _1697_CheckingExistenceOfEdgeLengthLimitedPaths obj = new _1697_CheckingExistenceOfEdgeLengthLimitedPaths();

//        int n = 3;
//        int[][] edgeList = new int[][]{{1,0,16},{0,1,2},{1,2,4},{2,0,8},};
//        int[][] queries = {{0,1,2},{0,2,5}};

        int n = 5;
        int[][] edgeList = new int[][]{{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}};
        int[][] queries = {{0, 4, 14}, {1, 4, 13}};

        System.out.println(Arrays.toString(obj.distanceLimitedPathsExist(n, edgeList, queries)));
    }

    /*
        Approach - Union Find

        DFS will also work but Time limit exceeded error

        step 1 - sort edge list array by weight
        step 2 - sort queries array by weight and add extra element as original index, this will be required to put answer at correct
        position in result
        step 3 - for each query go through all edges whose weight is less than query.limit and group the nodes
        step 4 - After all edges, if nodes are in same group, retrun true
     */
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
//        UnionFind uf = new UnionFind(n);
        int queriesCount = queries.length;
        boolean[] answer = new boolean[queriesCount];

        // Store original indices with all queries.
        int[][] queriesWithIndex = new int[queriesCount][4];
        for (int i = 0; i < queriesCount; ++i) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }

        // Sort all edges in increasing order of their edge weights.
        Arrays.sort(edgeList, Comparator.comparingInt(edge -> edge[2]));
        // Sort all queries in increasing order of the limit of edge allowed.
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(query -> query[2]));

        groups = new int[n];
        rank = new int[n];
        for (int i = 0; i < groups.length; i++) {
            groups[i] = i;
        }


        int edgesIndex = 0;

        // Iterate on each query one by one.
        for (int queryIndex = 0; queryIndex < queriesCount; queryIndex += 1) {
            int src = queriesWithIndex[queryIndex][0];
            int dest = queriesWithIndex[queryIndex][1];
            int distanceLimit = queriesWithIndex[queryIndex][2];
            int originalIndex = queriesWithIndex[queryIndex][3];

            // We can attach all edges which satisfy the distanceLimit given by the query.
            while (edgesIndex < edgeList.length && edgeList[edgesIndex][2] < distanceLimit) {
                int node1 = edgeList[edgesIndex][0];
                int node2 = edgeList[edgesIndex][1];
                union(node1, node2);
                edgesIndex += 1;
            }

            // If both nodes belong to the same component, it means we can reach them.
            answer[originalIndex] = find(src) == find(dest);
        }

        return answer;
    }

    private int find(int node) {
        if (groups[node] != node) {
            groups[node] = find(groups[node]);
        }
        return groups[node];
    }

    public void union(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);

        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return;
        }

        if (rank[group1] > rank[group2]) {
            groups[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            groups[group1] = group2;
        } else {
            groups[group1] = group2;
            rank[group2] += 1;
        }
    }
}
