package leetcode;

public class _983_MinimumCostForTickets {

    public static void main(String[] args) {
        _983_MinimumCostForTickets obj = new _983_MinimumCostForTickets();

        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        System.out.println(obj.mincostTickets(days, costs));
    }

    /*
        Approach:
        Use DP for memorize the results and find optimal solution
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];

        return find(days, costs, 0, dp);
    }

    private int find(int[] days, int[] costs, int dayIndex, int[] dp) {
        if (dayIndex >= days.length) {
            return 0;
        }

        if (dp[dayIndex] != 0) {
            return dp[dayIndex];
        }

        //op1 - consider 1 day pass
        //op2 - consider 7 days pass
        //op3 - consider 30 days pass
        //find min of op1, op2 and op3 and store result in dp
        int op1 = costs[0] + find(days, costs, dayIndex+1, dp);
        int i = dayIndex;
        for (; i < days.length; i++) {
            if (days[i] >= days[dayIndex]+7) { //to find index of next day check when day is more than 7 from
                // current day
                break;
            }
        }
        int op2 = costs[1] + find(days, costs, i, dp);

        i = dayIndex;
        for (; i < days.length; i++) {
            if (days[i] >= days[dayIndex]+30) { //to find index of next day check when day is more than 30 from
                // current day
                break;
            }
        }
        int op3 = costs[2] + find(days, costs, i, dp);

        int min = Math.min(op1, Math.min(op2, op3));
        dp[dayIndex] = min;

        return min;
    }
}
