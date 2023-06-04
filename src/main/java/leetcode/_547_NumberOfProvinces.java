package leetcode;

import java.util.Arrays;

public class _547_NumberOfProvinces {

    public static void main(String[] args) {
        _547_NumberOfProvinces obj = new _547_NumberOfProvinces();

//        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(obj.findCircleNum(isConnected));
    }

    private int[] parent;
    private int[] rank;
    private int answer;
    /*
        Approach: Union-Find
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        answer = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        union(isConnected, n);
        return answer;
    }

    private void union(int[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            int[] edges = graph[i];
            for (int j = i+1; j < n; j++) {
                if (edges[j] == 1) {
                    int group1 = find(i);
                    int group2 = find(j);

                    if (group1 == group2) {
                        continue;
                    }

                    /* decrement this everytime we merge two nodes. It has 2 benefits.
                        1. At the end we don't have to calculate the number of groups as this variable we keep track of number of groups
                        for us. We start with no. of groups equal to no. of nodes(usual approach with union find each node is its own
                        parent and hence no. of groups equal to no. of nodes)

                        2. we don't have to update the group of all nodes in case of indirect edge. For eg:  1->2->3
                        1 has indirect edge to 3. Initially 1 and 2 will be in same group but after that 2and 3 will be in same group (as
                        they have direct edge) and 1 will be in different group. Ideally there is one group but if we count by parent
                        there will be 2 groups, to avoid this situation we need to update group of 1 as well when group of any node in
                        its group is changed.
                     */
                    answer--;
                    if (rank[group1] < rank[group2]) {
                        parent[group1] = group2;
                    } else if (rank[group2] < rank[group1]) {
                        parent[group2] = group1;
                    } else {
                        parent[group1] = group2;
                        rank[group2]++;
                    }
                }
            }
        }
    }

    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent[node]);
    }
}
