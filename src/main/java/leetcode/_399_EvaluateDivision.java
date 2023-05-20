package leetcode;

import java.util.*;

public class _399_EvaluateDivision {

    public static void main(String[] args) {
        _399_EvaluateDivision obj = new _399_EvaluateDivision();

        List<List<String>> equations = List.of(List.of("a","b"), List.of("b","c"));
        double[] values = {2,3};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
        System.out.println(Arrays.toString(obj.calcEquation(equations, values, queries)));
    }

    /*
        Approach: Consider as graph problem and use DFS. See inline comments
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // build graph. Treat the equation as un-directional graph. un-directional because we need to edge in both directions, if we
        // don't do this, for any query which is in opposite direction we will have to write separate logic. when adding edge in reverse
        // direction inverse the value
        for (int i = 0; i < equations.size(); i++) {
            String key = equations.get(i).get(0);
            String reverseKey = equations.get(i).get(1);

            graph.putIfAbsent(key, new HashMap<>());
            graph.putIfAbsent(reverseKey, new HashMap<>());

            graph.get(key).put(reverseKey, values[i]);
            //inverse the value when adding edge in opposite direction
            graph.get(reverseKey).put(key, 1/values[i]);
        }

        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            answer[i] = dfs(src, dest, graph, new HashSet<>(), 1);
        }
        return answer;
    }

    private double dfs(String src, String dest, Map<String, Map<String, Double>> graph, Set<String> visited, double result) {

        if (!graph.containsKey(src) || visited.contains(src)) {
            return -1;
        }

        if (src.equals(dest)) {
            return result;
        }
        visited.add(src);

        Map<String, Double> subGraph = graph.get(src);
        for (String key : subGraph.keySet()) {
            double val = dfs(key, dest, graph, visited, result * subGraph.get(key));
            //return only if returned value is not -1 else explore other paths. Only way to get positive value here is when src and dest
            // match i.e. we found the destination.
            if (val != -1) {
                return val;
            }
        }
        return -1;
    }
}
