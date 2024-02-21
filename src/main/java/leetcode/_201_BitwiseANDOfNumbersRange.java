package leetcode;

public class _201_BitwiseANDOfNumbersRange {

    public static void main(String[] args) {
        _201_BitwiseANDOfNumbersRange obj = new _201_BitwiseANDOfNumbersRange();

        int left = 0, right = 1;
        System.out.println(obj.rangeBitwiseAnd(left, right));
    }

    public int rangeBitwiseAnd(int left, int right) {
        /*
            Bitwise-AND of any two numbers will always produce a number less than or equal to the smaller number.
            So, we can skip the numbers in between
         */
        while (right > left) {
            right = right & (right -1); //Take bitwise AND of right and a number 1 less than that and use the result as next right i.e.
            // we are skipping the numbers between (right-1) and result of (right-1) & right
        }
        return right & left;
    }
}
