package leetcode;

public class _1482_MinimumNumberOfDaysToMake_M_Bouquets {

    public static void main(String[] args) {
        _1482_MinimumNumberOfDaysToMake_M_Bouquets obj = new _1482_MinimumNumberOfDaysToMake_M_Bouquets();

        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(obj.minDays(bloomDay, m, k));
    }

    /*
        Approach:

        Do a binary search between 0 and the highest value in the array. The highest value is the array indicates the last day flower will
        bloom. With binary search look for no. of consecutive flowers bloomed and hence create the bouquet.

        If required, no.of bouquets are created track backwards to see if there are lesser number of days in which required bouquets can be
         created.

     */
    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;

        for (int day : bloomDay) {
            end = Math.max(end, day);
        }
        int minDays = -1;

        //binary search
        while (start <= end) {
            int mid = (end + start) / 2;
            if (getNoOfBouquets(bloomDay, k, mid) >= m) {
                minDays = mid;
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return minDays;
    }

    private int getNoOfBouquets(int[] bloomDay, int k, int limit) {

        int count = 0, bouquets = 0;
        for (int day : bloomDay) {
            if (day <= limit) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                bouquets++;
                count = 0;
            }
        }
        return bouquets;
    }
}
