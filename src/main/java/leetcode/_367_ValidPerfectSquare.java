package leetcode;

public class _367_ValidPerfectSquare {

    public static void main(String[] args) {
        _367_ValidPerfectSquare obj = new _367_ValidPerfectSquare();

        int num = 104976;
        System.out.println(obj.isPerfectSquare(num));
    }

    /*
        Approach : use binary search
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int low = 1, high = num;

        while (low <= high) {
            int mid = (high-low)/2 + low;
            long square = (long)mid * mid;
            if (square == num) {
                return true;
            }

            if (square < num) {
                low = mid + 1;
            }else {
                high = mid-1;
            }
        }
        return false;
    }
}
