package leetcode;

public class _2048_NextGreaterNumericallyBalancedNumber {

    public static void main(String[] args) {
        _2048_NextGreaterNumericallyBalancedNumber obj =
                new _2048_NextGreaterNumericallyBalancedNumber();

        int n = 1000;
        System.out.println(obj.nextBeautifulNumber(n));
    }

    public int nextBeautifulNumber(int n) {

        //since number is not very large we can follow naive method. Other option was to list all balanced numbers and use binary search
        //to find number greater than n
        for (int i = n+1; i <= 1224444; i++) {
            int[] count = new int[10];
            int num = i;
            while (num > 0) {
                count[num % 10]++;
                num = num /10;
            }

            boolean numberFound = true;
            for (int j = 0; j < 10; j++) {
                if (count[j] > 0 && count[j] != j) {
                    numberFound = false;
                    break;
                }
            }

            if (numberFound) {
                return i;
            }
        }
        return -1;
    }
}
