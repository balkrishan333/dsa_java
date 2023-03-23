package leetcode;

import java.util.*;

public class _1319_NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        _1319_NumberOfOperationsToMakeNetworkConnected obj = new _1319_NumberOfOperationsToMakeNetworkConnected();

//        int n = 4;
//        int[][] connections = {{0,1},{0,2},{1,2}};
        int n = 5;
        int[][] connections = {{0,1},{0,2},{3,4},{2,3}};
        System.out.println(obj.makeConnected(n, connections));
    }

    /*
        Approach: Use union find to find no of sub graphs

        Count number of sub graphs. If graphs are 1 - graph is already connected - return 0
        if graphs are more than 1 but no. of connections are less than n-1, return -1 as there won't be enough wires to connect all nodes
        else return no of graphs -1
     */
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] connection : connections) {
            union(connection[0], connection[1], parent, rank);
        }

        Set<Integer> subGraphParents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            subGraphParents.add(find(i, parent));
        }

        int graphCount = subGraphParents.size();
        if (graphCount == 1) {
            return 0;
        }

        if (connections.length >= n-1) {
            return graphCount-1;
        }

        return -1;
    }

    private void union(int node1, int node2, int[] parent, int[] rank) {
        int node1Parent = find(node1, parent);
        int node2Parent = find(node2, parent);

        if (node1Parent == node2Parent) {
            return;
        }

        if (rank[node1Parent] < rank[node2Parent]) {
            parent[node1Parent] = node2Parent;
        } else if (rank[node1Parent] > rank[node2Parent]) {
            parent[node2Parent] = node1Parent;
        } else {
            parent[node1Parent] = node2Parent;
            rank[node2Parent]++;
        }
    }

    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return parent[node];
        }
        return find(parent[node], parent);
    }
}
