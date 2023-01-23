package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _997_FindThTownJudge {

    public static void main(String[] args) {
        _997_FindThTownJudge obj = new _997_FindThTownJudge();

        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(obj.findJudge(n, trust));
    }


    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];

        for (int[] pair : trust) {
            count[pair[0]]--;
            count[pair[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n-1) {
                return i;
            }
        }
        return -1;
    }

    /*
        Take more time compared to above solution
     */
    public int findJudge_v1(int n, int[][] trust) {

        if (n <= 0) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        Map<Integer, Integer> truster = new HashMap<>(); // count no of people trust a person
        boolean[] trusting = new boolean[n+1]; // set true if it trusts anyone

        for (int[] pair : trust) {
            trusting[pair[0]] = true;
            truster.merge(pair[1], 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : truster.entrySet()) {
            if (entry.getValue() == n-1 && !trusting[entry.getKey()]) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
