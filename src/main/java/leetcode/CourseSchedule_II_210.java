package leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class CourseSchedule_II_210 {

    private Node[] nodes;
    private Set<Integer> order = new LinkedHashSet<>();

    public static void main(String[] args) {
        CourseSchedule_II_210 obj = new CourseSchedule_II_210();

//        int numCourses = 5;
//        int[][]prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        int numCourses = 2;
        int[][]prerequisites = {{1,0}};

        System.out.println(Arrays.toString(obj.findOrder(numCourses, prerequisites)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray();
        }

        nodes = new Node[numCourses]; // create a node for each course

        //initialize each node
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
            nodes[i].val = i;
        }

        //save dependencies of each course as adjacency list
        for (int[] prerequisite : prerequisites) {
            Node node = nodes[prerequisite[1]];
            node.adj.add(prerequisite[0]);
        }

        boolean result = true;
        /*
        1. DFS traversal of each node where status is NOT_STARTED. If during DFS we hit a node with status IN_PROGRESS,
        that means a cycle has been hit and return false.

        2. if adjacency list is empty, it means no dependency and no child nodes to traverse. Mark node COMPLETED
        */
        for (Node node : nodes) {
            if (node.state == State.NOT_STARTED) {
                if (node.adj.size() == 0) { // if node has no adj, mark it visited as nothing for dfs visit
                    order.add(node.val);
                    node.state = State.COMPLETED;
                    continue;
                }
                result = result & dfs(node);
            }
        }
        if (!result) {
            return new int[0];
        }
        int[] res = new int[order.size()];
        Iterator<Integer> iterator = order.iterator();
        for (int i = order.size()-1; i >=0; i--) {
            res[i] = iterator.next();
        }
        return res;
    }

    private boolean dfs(Node node) {
        if (node.state == State.NOT_STARTED) {
            node.state = State.IN_PROGRESS;
            List<Integer> adj = node.adj;

            for (int edge : adj) {
                Node node1 = nodes[edge];
                if (node1.state == State.NOT_STARTED) {
                    boolean res =  dfs(nodes[edge]);
                    if (!res) {
                        return false;
                    }
                } else if (node1.state == State.IN_PROGRESS){
                    return false;
                }
                order.add(node1.val);
                node1.state = State.COMPLETED;
            }
            order.add(node.val);
            node.state = State.COMPLETED;
        }
        return node.state == State.COMPLETED;
    }

     class Node {
        State state;
        List<Integer> adj;
        int val;

        Node() {
            val = Integer.MIN_VALUE;
            state = State.NOT_STARTED;
            adj = new ArrayList<>();
        }

    }

    enum State {
        IN_PROGRESS,
        COMPLETED,
        NOT_STARTED
    }
}
