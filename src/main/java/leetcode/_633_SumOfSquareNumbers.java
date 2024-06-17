package leetcode;

public class _633_SumOfSquareNumbers {

    public static void main(String[] args) {
        _633_SumOfSquareNumbers obj = new _633_SumOfSquareNumbers();

        int c = 5;
        System.out.println(obj.judgeSquareSum(c));
    }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);

            //check if the number is int or not
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
