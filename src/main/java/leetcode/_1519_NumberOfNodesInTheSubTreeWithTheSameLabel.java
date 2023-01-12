package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1519_NumberOfNodesInTheSubTreeWithTheSameLabel {

    public static void main(String[] args) {
        _1519_NumberOfNodesInTheSubTreeWithTheSameLabel obj = new _1519_NumberOfNodesInTheSubTreeWithTheSameLabel();

        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        String labels = "abaedcd";

        System.out.println(Arrays.toString(obj.countSubTrees(n, edges, labels)));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        /*List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }*/
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        boolean[] visitedNodes = new boolean[n];

        int[] count = new int[26];

        char[] chars = labels.toCharArray();
        count[chars[0]-97] = 1;

        postOrderTraversal(graph, count, chars, visitedNodes, 0, result);
        return result;
    }

    private void postOrderTraversal(List<Integer>[] graph, int[] count, char[] chars, boolean[] visitedNodes, int node, int[] result) {

        if (!visitedNodes[node]) {

            visitedNodes[node] = true;

            List<Integer> nodes = graph[node];
            if (nodes.size() == 0) {
                result[node] = 1;
            }

            for (int a : nodes) {
                int[] count2 = new int[26];
                count2[chars[a] - 97] = 1;
                postOrderTraversal(graph, count2, chars, visitedNodes, a, result);

                for (int i = 0; i < 26; i++) {
                    count[i] = count[i] + count2[i];
                }
            }

            result[node] = count[chars[node]-97];
        }
    }
}
