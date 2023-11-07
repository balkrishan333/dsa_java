package leetcode;

import java.util.Arrays;

public class _1921_EliminateNumberOfMonsters {

    public static void main(String[] args) {
        _1921_EliminateNumberOfMonsters obj = new _1921_EliminateNumberOfMonsters();

        int[] dist = {1,3,4};
        int[] speed = {1,1,1};
        System.out.println(obj.eliminateMaximum(dist, speed));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrival);
        int ans = 0;

        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= i) {
                break;
            }

            ans++;
        }

        return ans;
    }
}
