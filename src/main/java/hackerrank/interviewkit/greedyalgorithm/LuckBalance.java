package hackerrank.interviewkit.greedyalgorithm;

import java.util.Map;
import java.util.TreeMap;

public final class LuckBalance {

    public static void main(String[] args) {
        /*int k = 3;
        int[][] contests = {
                {5,1},
                {2,1},
                {1,1},
                {8,1},
                {10,0},
                {5,0}
        };*/
        int k = 2;
        int[][] contests = {
                {5,1},
                {4,0},
                {6,1},
                {2,1},
                {8,0},
        };

        LuckBalance luckBalance = new LuckBalance();
        int luck = luckBalance.calc(k, contests);
        System.out.println("luck = " + luck);
    }

    public int calc(int k, int[][] contests) {
        int luck = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        int countOfLostImportantContest = 0;

        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 0) { //always add if contest is not important
                luck += contests[i][0];
            } else {
                if (k == 0) { // if no imortant event can be lost
                    luck -= contests[i][0];
                    continue;
                }
                if (countOfLostImportantContest < k) {
                    luck += contests[i][0];
                    map.merge(contests[i][0], 1, Integer::sum);
                    countOfLostImportantContest++;
                } else if (countOfLostImportantContest == k) {
                    int smallest = map.keySet().iterator().next();
                    if (smallest < contests[i][0]) {
                        luck += contests[i][0];
                        luck -= 2*smallest;
                        map.merge(contests[i][0], 1, Integer::sum);
                        map.merge(smallest, -1, Integer::sum);
                        if (map.get(smallest) == 0) {
                            map.remove(smallest);
                        }
                    } else {
                        luck -= contests[i][0];
                    }
                }
            }
        }
        return luck;
    }
}
