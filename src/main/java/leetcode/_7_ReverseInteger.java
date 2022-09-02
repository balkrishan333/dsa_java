package leetcode;

public class _7_ReverseInteger {

    public static void main(String[] args) {
        _7_ReverseInteger obj = new _7_ReverseInteger();
        int x = -123;

        System.out.println(obj.reverse(x));
    }

    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int bit = x % 10;
            x= x/10;

            if (ans > Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10) {
                return 0;
            }
            ans = ans * 10 + bit;
        }
        return ans;
    }
}
