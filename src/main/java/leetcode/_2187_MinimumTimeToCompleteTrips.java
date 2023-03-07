package leetcode;

public class _2187_MinimumTimeToCompleteTrips {

    public static void main(String[] args) {
        _2187_MinimumTimeToCompleteTrips obj = new _2187_MinimumTimeToCompleteTrips();

        int[] time = {1,2,3};
        int totalTrips = 5;
        System.out.println(obj.minimumTime(time, totalTrips));
    }

    /*
        Approach: Minimum time would be 1
        max time (worst case) : no. of trips * max time of one vehicle

        Max time is possible, if vehicle with max time has to make all the trips. this is possible when either
        all vehicles have same time or there is only 1 vehicle

        with min and max defined, do a binary search over this timeline. For each iteration of binary search
        iterate over array to calculate how many trip are made by each vehicle in this time, sum it up.

        based on sum decided direction of binary search until you have only 1 element left. that is answer
     */
    public long minimumTime(int[] time, int totalTrips) {

        int max = 0;

        //find max time of vehicles
        for (int t : time) {
            max = Math.max(max, t);
        }

        long left = 1;
        long right = totalTrips * (long)max; // calculate right

        //Binary search over timeline
        while (left < right) {
            long mid = left + (right-left)/2;

            long count = 0;
            for(int t1 : time) {
                count += mid/t1;
            }

            //if no.of trips are more than or equal to totalTrips, check first half else 2nd half
            if (count >= totalTrips) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}
