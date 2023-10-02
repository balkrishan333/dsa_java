package leetcode;

public class _2038_RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    public static void main(String[] args) {
        _2038_RemoveColoredPiecesIfBothNeighborsAreTheSameColor obj = new _2038_RemoveColoredPiecesIfBothNeighborsAreTheSameColor();

        String colors = "ABBBBBBBAAA";
        System.out.println(obj.winnerOfGame(colors));
    }

    /*
        Approach: Moves of 1 player does impact moves of other player, so moves are known before start of game

        Count moves of both player and return the difference. Since alice moves first, for him to win, it needs to have at least 1 more
        move than bob
     */
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;

        for (int i = 1; i < colors.length()-1; i++) {
            if (colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)) {
                if (colors.charAt(i) == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }
        }
        return alice - bob >= 1;
    }
}
