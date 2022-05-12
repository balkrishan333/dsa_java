package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CountSortedVowelStrings_1641 {

    private static final List<String> VOWELS = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) {
        CountSortedVowelStrings_1641 obj = new CountSortedVowelStrings_1641();

        int n = 2;
        System.out.println(obj.countVowelStrings_v2(n));
    }

    /*
    https://www.mathsisfun.com/combinatorics/combinations-permutations.html
    https://medium.com/i-math/combinations-permutations-fa7ac680f0ac
     */
    public int countVowelStrings_v2(int n) {
        /*
            we need all combinations with repeatations
                (n+r-1)!
              ---------------  ==> r is 5 (no. of vowels)
                r! (n-1)!

                (n+4)!                 (n+4)!                    (n)! *(n+1) * (n+2) *(n+3) *(n+4)
              -------------  ==>     -------------  ==>      ---------------------------------------
                 (n-1)! 5!             (n)! (5-1)!                   (n)! (5-1)!


                 (n+1) * (n+2) *(n+3) *(n+4)
                 --------------------------
                           4!

         */

        return (n+1) * (n+2) * (n+3) * (n+4) / 24;
    }

    public int countVowelStrings(int n) {
        Deque<String> queue = new ArrayDeque<>();
        countVowelStrings(n, queue);

        return queue.size();
    }

    private void countVowelStrings(int n, Deque<String> queue) {
        if (n == 1) {
            queue.addAll(VOWELS);
            return;
        }

        countVowelStrings(n-1, queue);

        int size = queue.size();

        while (size > 0 && queue.peek().length() < n) {
            String s = queue.poll();

            for (String str : VOWELS) {
                if (str.charAt(0) >= s.charAt(0)) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(s);
                    queue.offer(sb.toString());
                }
            }
            size--;
        }
    }
}
