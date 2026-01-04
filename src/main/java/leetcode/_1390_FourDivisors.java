package leetcode;

public class _1390_FourDivisors {

    public static void main(String[] args) {
        _1390_FourDivisors obj =
                new _1390_FourDivisors();

        int[] nums = {21,4,7};
        System.out.println(obj.sumFourDivisors(nums));
    }

    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            int count = 0;
            int sum = 0;

            //loop only till sqrt(num), since sqrt can return double, square the other side
            for (int i = 1; i*i <= num; i++) {
                if (num % i == 0) {
                    count++;
                    sum += i;

                    int divisor1 = i;
                    int divisor2 = num/i;

                    //this is done because divisors are found in pairs. Eg if 21/3=7, then 21/7=3, so in one step we find 2 divisors
                    if (divisor1 != divisor2) {
                        count++;
                        sum += divisor2;
                    }

                    if (count > 4) {
                        break;
                    }
                }
            }
            if (count == 4) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}
