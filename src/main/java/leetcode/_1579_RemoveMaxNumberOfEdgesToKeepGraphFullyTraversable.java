package leetcode;

public class _1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static void main(String[] args) {
        _1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable obj = new _1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();

        int n = 4;
        int[][] edges = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        System.out.println(obj.maxNumEdgesToRemove(n, edges));
    }

    /*
        Approach: Union Find

        Create 2 union find graphs, one for alice and for bob. Consider edges of type 3 first as they are bidirectional and will reduce
        the number of edges. When traversing edges of type 1 or 2, consider them only if nodes the edge is connecting to are part of
        different groups else edge is not required.

        Calculate the no. of required edges and answer would be totalEdges - requiredEdges
     */
    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int requiredEdges = 0;
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        //consider bidirectional edges before uni-directional
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int count = alice.union(edge[1], edge[2]) + bob.union(edge[1], edge[2]);
                if (count >= 1) { //since edge is bidirectional, we don't have to consider it twice.  if it is required in any of the
                    // graphs we need to consider it only once
                    requiredEdges++;
                }
            }
        }

        //consider uni-directional edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                requiredEdges += alice.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                requiredEdges += bob.union(edge[1], edge[2]);
            }
        }

        //if no.of groups in both graphs are one, that means graphs are connected/
        if (alice.groupCount == 1 && bob.groupCount == 1) {
            return edges.length - requiredEdges;
        }
        //if graphs are not connected return -1, i.e. we can't remove any edge
        return -1;
    }

    static class UnionFind {
        private final int[] groups;
        private final int[] rank;
        private int groupCount; //count the number of groups, start with n and reduce the count when 2 nodes are merged (union method)

        UnionFind(int n) {
            groupCount = n;
            groups = new int[n+1];
            for (int i = 0; i < n; i++) {
                groups[i] = i;
            }
            rank = new int[n+1];
        }

        private int union(int node1, int node2) {
            int group1 = find(node1);
            int group2 = find(node2);

            if (group1 == group2) {
                //node already in same group, edge not required
                return 0;
            }

            if (rank[group1] < rank[group2]) {
                groups[group1] = group2;
            } else if (rank[group2] < rank[group1]) {
                groups[group2] = group1;
            } else {
                groups[group2] = group1;
                rank[group1]++;
            }
            groupCount--;

            return 1; //edge required as both nodes were part of different groups
        }

        private int find(int node) {
            if (groups[node] == node) {
                return node;
            }
            return find(groups[node]);
        }
    }
}
