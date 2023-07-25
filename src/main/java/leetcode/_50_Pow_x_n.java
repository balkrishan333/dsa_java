package leetcode;

public class _50_Pow_x_n {

    public static void main(String[] args) {
        _50_Pow_x_n obj = new _50_Pow_x_n();

        double x = 2.000;
        int n = -2;
        System.out.println(obj.myPow(x, n));
    }

    /*
        Approach: binary multiplication

        2^20 = (2*2)^10

        i.e. multiply the number with itself and half thw power. Do this recursively until you hit base case.

        If number id -ve, take reciprocal
     */
    public double myPow(double x, int n) {
        return binaryPower(x, n);
    }

    private double binaryPower(double x, double n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1/binaryPower(x, -n);
        }

        if (n % 2 == 0) {
            return binaryPower(x*x, n/2);
        } else {
            return x * binaryPower(x*x, (n-1)/2);
        }
    }
}
