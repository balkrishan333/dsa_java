package leetcode;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class _1845_SeatReservationManager {

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5);
    }

    static class SeatManager {

        private final PriorityQueue<Integer> pq;
        private final int capacity;
        public SeatManager(int n) {
            this.capacity = n;
            this.pq = new PriorityQueue<>(n);

            IntStream.range(1, n+1).forEach(pq::offer);
        }

        public int reserve() {
            if (!pq.isEmpty()) {
                return pq.poll();
            }
            throw new IllegalStateException("No more seats available");
        }

        public void unreserve(int seatNumber) {
            if (seatNumber > this.capacity) {
                throw new IllegalStateException("out of range seat number");
            }
            pq.offer(seatNumber);
        }
    }
}
