package leetcode;

public class _1701_AverageWaitingTime {

    public static void main(String[] args) {
        _1701_AverageWaitingTime obj = new _1701_AverageWaitingTime();

        int[][] customers = {{1,2},{2,5},{4,3}};
        System.out.println(obj.averageWaitingTime(customers));
    }

    public double averageWaitingTime(int[][] customers) {
        int nextIdleTime = 0;
        long netWaitTime = 0;

        for (int[] customer : customers) {
            //nextIdleTime = max(nextIdleTime, currCustomerArrivalTime) + preparationTime
            nextIdleTime = Math.max(customer[0], nextIdleTime) + customer[1];

            //waitTime = nextIdleTime(Time at which curr customer order starts or prev customer order ends) - currCustomerArrivalTime
            netWaitTime += nextIdleTime - customer[0];
        }
        return (double) netWaitTime / customers.length;
    }
}
