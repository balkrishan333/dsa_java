package leetcode;

import java.util.Arrays;

public class _2976_MinimumCostToConvertString_I {

    public static void main(String[] args) {
        _2976_MinimumCostToConvertString_I obj =
                new _2976_MinimumCostToConvertString_I();

        String source = "abcd";
        String target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'}; 
        int[] cost = {2,5,5,1,2,20};
        
        System.out.println(obj.minimumCost(source, target, original, changed, cost));
    }

    /*
        Approach: Use Floyd-warshall algorithm to find distance from each char to every other char (each char is a node)
        Transformation can be direct or indirect, so we have to consider direct costs given in cost[] and also indirect
        cost (jumping to intermediate char and then to final character)
     */
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int[][] costMatrix = buildCostMatrix(original, changed, cost);
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (u == v) {
                continue;
            }

            //check for half of max value(array was initialized with half of max value to avoid integer overflow during addition) or
            //more than that to inicate path does not exist
            if (costMatrix[u][v] >= Integer.MAX_VALUE/2) {
                return -1;
            }

            totalCost += costMatrix[u][v];
        }
        return totalCost;
    }

    private int[][] buildCostMatrix(char[] original, char[] changed, int[] cost) {
        int[][] costMatrix = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(costMatrix[i], Integer.MAX_VALUE/2); //Half of max to avoid integer overflow during addition
        }

        //Build graph
        int n = changed.length;
        for (int i = 0; i < n; i++) {
            int u = original[i]-'a';
            int v = changed[i]-'a';
            costMatrix[u][v] = Math.min(costMatrix[u][v], cost[i]);
        }

        //Floyd-Warshall: Find all-pairs shortest paths
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (costMatrix[i][j] > costMatrix[i][k] + costMatrix[k][j]) {
                        costMatrix[i][j] = costMatrix[i][k] + costMatrix[k][j];
                    }
                }
            }
        }
        return costMatrix;
    }
}
