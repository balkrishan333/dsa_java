package leetcode;

import java.util.Arrays;

public class _1601_MaximumNumberOfTransferRequests {

    public static void main(String[] args) {
        _1601_MaximumNumberOfTransferRequests obj = new _1601_MaximumNumberOfTransferRequests();

        int n= 5;
        int[][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        System.out.println(obj.maximumRequests(n, requests));
    }

    int answer = 0;

    /*
        Approach: BackTracking

        Use back tracking to consider each transfer. Maintain the state of each building. During any iteration if state of any building
        is not zero, it is an invalid state as after transfers there should be no change in any building
     */
    public int maximumRequests(int n, int[][] requests) {
        int[] state = new int[n];

        calculateMaxRequests(n, requests, state, 0, 0);
        return answer;
    }

    /*
        why do we need to maintain count separately?
        This is required because with index we can't keep track of count as current considered index does not tell you how many past
        requests we have considered.
     */
    private void calculateMaxRequests(int n, int[][] requests, int[] state, int index, int count) {
        if (index == requests.length) {
            //we have considered each request, if state is not valid return
            if (Arrays.stream(state).filter(val -> val != 0).count() != 0) {
                return;
            }
            //else take count if more than current answer
            answer = Math.max(answer, count);
            return;
        }

        //consider this request and move to next index
        state[requests[index][0]]--;
        state[requests[index][1]]++;
        calculateMaxRequests(n, requests, state, index+1, count+1);

        //back track to remove impact of previous consideration
        state[requests[index][0]]++;
        state[requests[index][1]]--;
        //move to next request but don't consider this one
        calculateMaxRequests(n, requests, state, index+1, count);

    }
}
