package leetcode;

import java.util.Arrays;

public class _2037_MinimumNumberOfMovesToSeatEveryone {

    public static void main(String[] args) {
        _2037_MinimumNumberOfMovesToSeatEveryone obj = new _2037_MinimumNumberOfMovesToSeatEveryone();

        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        System.out.println(obj.minMovesToSeat(seats, students));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
}
