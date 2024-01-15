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
        Arrays.fill(losses, -1); // -1 indicates that player has not played any match

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            //make losses to zero to separate it from player who has played a match and the one who has not played a match
            if (losses[winner] == -1) {
                losses[winner]++;
            }

            //first time increase by 2 to make loss 1 (-1 indicates player has not played a match), 2nd time onwards increase by 1 only
            if (losses[loser] == -1) {
                losses[loser] += 2;
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
