package leetcode;

public class _1326_MinimumNumberOfTapsToOpenToWaterAGarden {

    public static void main(String[] args) {
        _1326_MinimumNumberOfTapsToOpenToWaterAGarden obj = new _1326_MinimumNumberOfTapsToOpenToWaterAGarden();

        int n = 5;
        int[] ranges = {3,4,1,1,0,0};
        System.out.println(obj.minTaps(n, ranges));
    }

    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[ranges.length];

        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i-ranges[i]);
            int end = Math.min(n, i+ranges[i]);

            maxReach[start] = Math.max(end, maxReach[start]);
        }

        int taps = 0;
        int currEnd = 0;
        int nextEnd = 0;

        for (int i = 0; i <= n; i++) {

            if (i > nextEnd) {
                return -1;
            }

            if (i > currEnd) {
                taps++;
                currEnd = nextEnd;
            }
            nextEnd = Math.max(nextEnd, maxReach[i]);
        }
        return taps;
    }
}
