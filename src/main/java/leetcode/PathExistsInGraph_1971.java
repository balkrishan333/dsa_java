package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathExistsInGraph_1971 {

    public static void main(String[] args) {
        int n=3, source=0, destination=2;
        int[][] edges = {{0,1},{1,2},{2,0}};

        System.out.println("Path exits = " + validPath(n, edges, source, destination));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) {
            return true;
        }

        boolean[] visited = new boolean[n];

        Deque<Integer> queue = new ArrayDeque<>();
        //add source to queue
        queue.add(source);

        while (!queue.isEmpty()) {
            //checj each edge involving node and see if it leads to destination
            int node = queue.poll();
            visited[node] = true;

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];

                //since graph is bidirectional, we need to check both nodes of edge
                if (edge[0] == node || edge[1] == node) {
                    if (edge[1] == destination || edge[0] == destination) {
                        return true;
                    }

                    //add both nodes to queue, check if we can add only one
                    //before adding check if node has already been visited or not to guard against cycles
                    if (!visited[edge[0]]) {
                        queue.add(edge[0]);
                    }

                    if (!visited[edge[1]]) {
                        queue.add(edge[1]);
                    }
                }
            }
        }
        return false;
    }
}
