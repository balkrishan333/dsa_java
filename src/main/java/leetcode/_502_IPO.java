package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _502_IPO {

    public static void main(String[] args) {
        _502_IPO obj = new _502_IPO();

        int k = 2, w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println(obj.findMaximizedCapital(k, w, profits, capital));
    }

    /*
        Approach:

        Create 2D array (first element capital and 2nd profit). Sort the array by profit in reverse order (max first)

        Add all projects to the priority queue. take out the top element from queue, if capital is less than  or equal to w
        add the profit, else park it in the list to add it to queue later on (this is required because this project is not
        considered as of now due to less capital but can be considered later on when we have more capital)

        Repeat the above k times.
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits.length == 0 || k == 0) {
            return w;
        }

        //sort by profit in reverse order
        PriorityQueue<int[][]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0][1], o1[0][1]));

        //add all projects to queue
        for (int i = 0; i < capital.length; i++) {
            pq.add(new int[][]{{capital[i], profits[i]}});
        }

        List<int[][]> poped = new ArrayList<>();

        while (!pq.isEmpty() && k > 0) {
            int[][] project = pq.poll();
            //if capital is less than or equal to w, consider the project, decrement k amd add all popped elements
            //that were not considered
            if (project[0][0] <= w) {
                w += project[0][1];
                k--;
                pq.addAll(poped);
                poped.clear();
            } else {
                //element not considered as capital is more than w, park it for adding it to queue later on.
                poped.add(project);
            }
        }
        return w;
    }
}
