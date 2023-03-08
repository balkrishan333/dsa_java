package leetcode;

public class _875_KokoEatingBananas {

    public static void main(String[] args) {
        _875_KokoEatingBananas obj = new _875_KokoEatingBananas();

        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(obj.minEatingSpeed(piles, h));
    }

    /*
        Approach: Use binary search

        We need to find minimum speed of eating bananas to complete all piles in h hours.

        Min possible is 1 (as it needs to eat at least one to finish the pile)
        max possible is max bananas in a pile

        So, do a binary search between min and max. Consider mid as potential answer and calculate no of hours required
        to finish all piles with mid

        No. of hours required to finish a pile would be Math.ceil(pile/mid).

        If no of hrs are more than h, we need to crease the size, so move right else move left until there is only
        1 element left.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = min;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) /2;
            int totalHrs = 0;
            for (int pile : piles) {
                totalHrs += Math.ceil((double) pile/mid);
            }

            if (totalHrs > h) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
