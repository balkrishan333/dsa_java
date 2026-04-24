package leetcode;

public class _2833_FurthestPointFromOrigin {

    public static void main(String[] args) {
        _2833_FurthestPointFromOrigin obj = new _2833_FurthestPointFromOrigin();

        String moves = "L_RL__R";
        System.out.println(obj.furthestDistanceFromOrigin(moves));
    }

    public int furthestDistanceFromOrigin(String moves) {
        int leftTurns = 0;
        int rightTurns = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                leftTurns++;
            } else if (moves.charAt(i) == 'R') {
                rightTurns++;
            }
        }

        if (leftTurns >= rightTurns) {
            return moves.length() - rightTurns*2;
        }
        return moves.length() - leftTurns*2;
    }
}
