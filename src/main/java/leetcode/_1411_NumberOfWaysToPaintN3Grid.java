package leetcode;

public class _1411_NumberOfWaysToPaintN3Grid {

    public static void main(String[] args) {
        _1411_NumberOfWaysToPaintN3Grid obj =
                new _1411_NumberOfWaysToPaintN3Grid();

        int n = 5000;
        System.out.println(obj.numOfWays(n));
    }

    /*
        Approach: There are 2 types of possible patterns in a row which satisfy the contraints
        1.) ABC - All 3 colors are different
        2.) ABA - 1st and 3rd colors are same and 2nd is different

         For type A there are 6 possible patterns - 3x2x1 = 6
         For type B there are 6 possible patterns - 3x2 = 6 (no 3rd position as only 2 colors will be selected and one of them will be
         used twice in 1st and 3rd position)

         Do, row 1 will have 12 possible patterns

         When moving from 1 row to next no. of possible transitions depend on Type of pattern

         From Type A --> Type A == 2 possible patterns
         From Type A --> Type B == 2 possible patterns
         From Type B --> Type A == 2 possible patterns
         From Type B --> Type B == 3 possible patterns

         so, when moving from 1 row to next row, no. of possible patterns would be

         newA = A*2 + B*2
         newB = A*2 + B*3
     */

    public int numOfWays(int n) {
        int MOD = 1_000_000_007;
        long typeATransitions = 6;
        long typeBTransitions = 6;

        for (int i = 1; i < n; i++) {
            long newTypeATransitions = (typeATransitions *2 + typeBTransitions*2) % MOD;
            long newTypeBTransitions = (typeATransitions *2 + typeBTransitions*3) % MOD;

            typeATransitions = newTypeATransitions;
            typeBTransitions = newTypeBTransitions;
        }
        return (int)(typeATransitions + typeBTransitions) % MOD;
    }
}
