package leetcode;

public class _2492_MinimumScoreOfAPathBetweenTwoCities {

    public static void main(String[] args) {
        _2492_MinimumScoreOfAPathBetweenTwoCities obj = new _2492_MinimumScoreOfAPathBetweenTwoCities();

//        int n = 4;
//        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
//        int n = 6;
//        int[][] roads = {{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{2,4,1885},{2,5,5192},{1,3,4065},{1,4,7357}};
        int n = 20;
        int[][] roads = {{18,20,9207},{14,12,1024},{11,9,3056},{8,19,416},{3,18,5898},{17,3,6779},{13,15,3539},{15,11,
                1451},{19,2,3805},{9,8,2238},{1,16,618},{16,14,55},{17,7,6903},{12,13,1559},{2,17,3693}};
//        int n = 13;
//        int[][] roads = {{2,12,1891},{10,9,4138},{11,3,2007},{1,10,9390},{12,8,1915},{6,2,1098},{5,4,2795},{3,13,
//                4562},{9,7,9202},{4,6,6752},{8,11,1480},{7,5,9827}};
        System.out.println(obj.minScore(n, roads));
    }

    /*
        Approach:

        Use union find algo to create subsets of nodes which are connected. Find the parent for node 1 (because we
        need to find distance between 1st and nth node). Traverse through all roads and if any node in the road is in
         the same subset as of node 1, consider its distance. We need not check for both nodes in a road because we
         know they both will be in same subset.
     */

    public int minScore(int n, int[][] roads) {

        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] road : roads) {
            union(road[0], road[1], parent, rank);
        }

        //identify the graph which has both first and last node
        int root = find(1, parent);

        //find minimum distance in the graph
        int answer = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (find(road[0], parent) == root) {
                answer = Math.min(answer, road[2]);
            }
        }
        return answer;
    }

    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return parent[node];
        }
        return find(parent[node], parent);
    }

    /*
        Using union by rank algo for creating subsets
     */
    private void union(int node1, int node2, int[] parent, int[] rank) {
        int node1Parent = find(node1, parent);
        int node2Parent = find(node2, parent);

        if (node1Parent == node2Parent) {
            return;
        }

        if (rank[node1Parent] < rank[node2Parent]) {
            parent[node1Parent] = node2Parent;
        }else if (rank[node1Parent] > rank[node2Parent]) {
            parent[node2Parent] = node1Parent;
        } else {
            parent[node1Parent] = node2Parent;
            rank[node2Parent]++;
        }
    }
}
