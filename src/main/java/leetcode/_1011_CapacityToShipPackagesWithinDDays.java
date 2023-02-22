package leetcode;

import java.util.Arrays;

public class _1011_CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        _1011_CapacityToShipPackagesWithinDDays obj = new _1011_CapacityToShipPackagesWithinDDays();

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(obj.shipWithinDays(weights, days));
    }

    /*
        Approach: Minimum weight required will be maximum size of any element in array (even if that element goes alone
        weight can't be less than that) and maximum weight will be sum of all elements in array
        (in case all packages need to be shipped in 1 day)

        Do a binary search between min and max to find optimal weight. Continue finding optimal weight until window
        size is reduced to one. We need to do this because finding a weight which fits according to given criteria
        is the optimal weight and we might find a weight less than that which still qualifies the criteria.
     */
    public int shipWithinDays(int[] weights, int days) {
        int sum = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();

        int left = max, right = sum;

        while (left != right) {
            int mid = (left+right)/2;

            if (check(mid, weights, days)){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean check(int mid, int[] weights, int days) {
        int daysReq = 1, currSum = 0;
        for (int weight : weights) {
            if (currSum + weight > mid) {
                daysReq++;
                if (daysReq > days) {
                    return false;
                }
                currSum = weight;
            } else {
                currSum += weight;
            }
        }
        return daysReq <= days;
    }
}
