package hackerrank.interviewkit.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
 */
public final class MinimumSwaps {

    private static final Logger logger = LoggerFactory.getLogger(MinimumSwaps.class);

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 2, 4, 5, 6};
        MinimumSwaps swaps = new MinimumSwaps();
        int count = swaps.count(arr);

        logger.info("count = " + count);
    }

    public int count(int[] arr) {
        logger.info("Input arr: " , arr);
        boolean[] fixed = new boolean[arr.length];
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int cycleLength = 0;
            if (!fixed[i]) {
                if (arr[i] == i+1) {
                    fixed[i] = true;
                    continue;
                }
                fixed[i] = true;
                cycleLength++;
                int j = arr[i];
                while (!fixed[j-1]) {
                    cycleLength++;
                    fixed[j-1] = true;
                    j = arr[j-1];
                }
                logger.info("cycleLength : " + cycleLength);
                swaps += (cycleLength - 1);
            }
        }
        return swaps;
    }

}
