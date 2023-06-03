package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1376_TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        _1376_TimeNeededToInformAllEmployees obj = new _1376_TimeNeededToInformAllEmployees();

        int n = 15, headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
//        int n = 6, headID = 2;
//        int[] manager = {2,2,-1,2,2,2};
//        int[] informTime = {0,0,1,0,0,0};

        System.out.println(obj.numOfMinutes(n, headID, manager, informTime));
    }

    /*
        Approach: DFS
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(i);
        }

        int answer = 0;
        for (int adjacentNode : graph.getOrDefault(headID, new ArrayList<>())) {
            int time = dfs(adjacentNode, graph, informTime);
            answer = Math.max(answer, time);
        }
        return answer + informTime[headID];
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, int[] informTime) {
        int maxTime = 0;

        for (int subordinate : graph.getOrDefault(node, new ArrayList<>())) {
            int time = dfs(subordinate, graph, informTime);
            maxTime = Math.max(time, maxTime);
        }
        return maxTime + informTime[node];
    }
}
