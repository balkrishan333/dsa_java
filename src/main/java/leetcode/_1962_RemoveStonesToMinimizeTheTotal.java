package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class _1962_RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        _1962_RemoveStonesToMinimizeTheTotal obj = new _1962_RemoveStonesToMinimizeTheTotal();

        int[] piles = {5,4,9};
        int k = 2;
        System.out.println(obj.minStoneSum(piles, k));
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < piles.length; i++) {
            pq.add(piles[i]);
        }

        for (int i = 0; i < k; i++) {
            int next = pq.poll();
            pq.add(next - (int)Math.floor(next/2));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        return answer;
    }
}
