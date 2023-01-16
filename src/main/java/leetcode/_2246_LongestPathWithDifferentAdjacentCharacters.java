package leetcode;

import java.util.*;

public class _2246_LongestPathWithDifferentAdjacentCharacters {

    private int longestPath = 1;

    public static void main(String[] args) {
        _2246_LongestPathWithDifferentAdjacentCharacters obj = new _2246_LongestPathWithDifferentAdjacentCharacters();

//        int[] parent = {-1, 0, 0, 0};
//        String s = "aabc";
        int[] parent = {-1, 0, 0, 1, 1, 2};
        String s = "abacbe";
//        int[] parent = {-1,0,1};
//        String s = "aab";
        System.out.println(obj.longestPath(parent, s));
    }

    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i < parent.length; i++) {
            graph.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }

        dfs(graph, 0, s);
        return longestPath;

    }

    private int dfs(Map<Integer, List<Integer>> graph, int node, String s) {

        if (!graph.containsKey(node)) {
          return 1;
        }

        List<Integer> children = graph.get(node);

        /*
            why we need secondLongestChain.
            while traversing the graph, we can only traverse 2 branches of a node because visiting 3rd branch would
            need traversing the parent again. So we need to maintain only 2 longest chains
         */
        int longestChain = 0, secondLongestChain = 0;
        for(int child : children) {

            int childPathLength = dfs(graph, child, s);

            if (s.charAt(child) == s.charAt(node)) {
                continue;
            }

           if (childPathLength > longestChain) {
               secondLongestChain = longestChain;
               longestChain = childPathLength;
           } else if (childPathLength > secondLongestChain ){
               secondLongestChain = childPathLength;
           }

        }

        System.out.println("longestChain = " + longestChain);
        System.out.println("secondLongestChain = " + secondLongestChain);
        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }

    /*
    Solution times out
     */
    /*public int longestPath_v1(int[] parent, String s) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[parent.length];

        for (int i = 1; i < parent.length; i++) {
            if (graph.containsKey(parent[i])) {
                List<Integer> children = graph.get(parent[i]);
                children.add(i);
            } else {
                List<Integer> children = new ArrayList<>();
                children.add(i);
                graph.put(parent[i], children);
            }
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < parent.length; i++) { // add leaf nodes to queue to start off
            if (!graph.containsKey(i)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                queue.add(list);
            }
        }

        int longestPath = 1;
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            if (path.size() > longestPath) {
                longestPath = path.size();
            }

            int node = path.get(path.size() - 1);
            if (!visited[node]) {
                int nodeParent = parent[node];
                List<Integer> nodeChildren = graph.get(node);

                // if parent is eligible, only then siblings are eligible, because path to sibling is via parent
                if (nodeParent != -1 && s.charAt(nodeParent) != s.charAt(node) && !path.contains(nodeParent)) {
                    List<Integer> parentPath = new ArrayList<>(path);
                    parentPath.add(nodeParent);
                    queue.add(parentPath);

                    List<Integer> siblings = graph.get(nodeParent);
                    for (int sibling : siblings) {
                        if (!parentPath.contains(sibling) && s.charAt(sibling) != s.charAt(parentPath.get(parentPath.size() - 1))
                                && !parentPath.contains(sibling)) {
                            parentPath.add(sibling);
                            queue.add(parentPath);
                        }
                    }
                }

                List<Integer> newPath2 = new ArrayList<>(path);
                if (nodeChildren != null) {
                    for (int child : nodeChildren) {
                        if (!newPath2.contains(child) && s.charAt(child) != s.charAt(node) && !newPath2.contains(child)) {
                            newPath2.add(child);
                            queue.add(newPath2);
                        }
                    }
                }
                visited[node] = true;
            }
        }
        return longestPath;
    }*/
}
