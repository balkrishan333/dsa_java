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

        char[] chars = labels.toCharArray();

        postOrderTraversal(graph, chars, visitedNodes, 0, result);
        return result;
    }

    private int[] postOrderTraversal(List<Integer>[] graph, char[] chars, boolean[] visitedNodes, int node, int[] result) {

        int[] count = new int[26];
        if (!visitedNodes[node]) {

            visitedNodes[node] = true;
            count[chars[node] - 'a'] = 1;

            List<Integer> nodes = graph[node];

            for (int child : nodes) {
                int[] childNodes = postOrderTraversal(graph, chars, visitedNodes, child, result);

                for (int i = 0; i < 26; i++) {
                    count[i] = count[i] + childNodes[i];
                }
            }
            result[node] = count[chars[node]-'a'];
        }
        return count;
    }
}
