package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AllPathsFromSourceToTarget_797 {

    public static void main(String[] args) {

        int[][] graph = {{1,2}, {3},{3},{}};

        AllPathsFromSourceToTarget_797 obj = new AllPathsFromSourceToTarget_797();
//        List<List<Integer>> result = obj.allPathsSourceTarget(graph);
        List<List<Integer>> result = obj.allPathsSourceTarget_v2(graph);
        System.out.println(result);
    }

    public List<List<Integer>> allPathsSourceTarget_v2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, path, res);
        return res;
    }

    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        path.add(node);
        if (node == graph.length-1) {
            res.add(new ArrayList<>(path));
        } else {
            int[] edges = graph[node];
            for (int i : edges) {
                dfs(graph, i, path, res);
            }
        }
        //remove the last added node, to construct other possible paths
        path.remove(path.size()-1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> initial = new ArrayList<>();
        initial.add(0); // add first element to start
        result.add(initial);

        int freeze = 0;

        while(result.size() > 0 && result.size() > freeze) {

            ListIterator<List<Integer>> iterator = result.listIterator();
            while(iterator.hasNext()) {

                List<Integer> list = iterator.next();

                if(list.get(list.size()-1) == graph.length-1) {
                    continue; // this is freezed item
                }

                iterator.remove(); //remove the intermediate results

                int[] edges = graph[list.get(list.size()-1)]; // get edge of last node in list

                for(int i =0; i<edges.length;i++) {
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(list);
                    newList.add(edges[i]);
                    iterator.add(newList);

                    if(edges[i] == graph.length-1) {
                        freeze++;
                    }
                }
            }
        }
        return result;
    }
}
