package leetcode;

public class _258_AddDigits {

    public static void main(String[] args) {
        _258_AddDigits obj = new _258_AddDigits();

        int num = 38;
        System.out.println(obj.addDigits(num));
    }

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num %10;
                num /= 10;
            }
            num =sum;
        }
        return num;
    }
}
