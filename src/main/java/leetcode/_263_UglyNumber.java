package leetcode;

import java.util.List;

public class _263_UglyNumber {

    public static void main(String[] args) {
        _263_UglyNumber obj = new _263_UglyNumber();

        int n = 6;
        System.out.println(obj.isUgly(n));
    }

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        List<Integer> primeFactors = List.of(2,3,5);
        for (int factor : primeFactors) {
            while (n % factor == 0) {
                n = n /factor;
            }
        }
        return n == 1;
    }
}
