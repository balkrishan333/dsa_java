package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {

    public static void main(String[] args) {
        _202_HappyNumber obj = new _202_HappyNumber();

        int n = 19;
        System.out.println(obj.isHappy(n));
    }

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        //4 happens to be loop point
        while (n > 4) {
            int sum = 0;
            while (n > 0) {
                int mod = n%10;
                n = n/10;
                sum = sum + mod * mod;
            }

            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
