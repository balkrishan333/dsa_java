package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2225_FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        _2225_FindPlayersWithZeroOrOneLosses obj = new _2225_FindPlayersWithZeroOrOneLosses();

        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(obj.findWinners(matches));
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100000+1];
        Arrays.fill(losses, -1);

        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            if (losses[winner] == -1) {
                losses[winner]++;
            }

            if (losses[loser] == -1) {
                losses[loser] +=2;
            } else {
                losses[loser]++;
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == 0) {
                zeroLoss.add(i);
            }

            if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }
        return List.of(zeroLoss, oneLoss);
    }
}
