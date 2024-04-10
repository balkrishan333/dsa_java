package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _950_RevealCardsInIncreasingOrder {

    public static void main(String[] args) {
        _950_RevealCardsInIncreasingOrder obj = new _950_RevealCardsInIncreasingOrder();

        int[] deck = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(obj.deckRevealedIncreasing(deck)));
    }

    /*
        Approach: Simulate the process using queue. Put all indexes in queue and take out the next index at which to store next element.

        When taking out next index from queue, push next index from queue to end.

        In a nutshell, take out 2 indexes from queue, at first index store next element and push second index at back end of queue.
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }

        Arrays.sort(deck);

        for (int i = 0; i < deck.length && !queue.isEmpty(); i++) {
            result[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }
        return result;
    }
}
