package geekforgeeks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/* https://www.geeksforgeeks.org/count-of-subarrays-having-exactly-k-distinct-elements/ */

public final class CountSubArrayWithKDistinctElements {

    private static final Logger logger = LoggerFactory.getLogger(CountSubArrayWithKDistinctElements.class);

    public static void main(String[] args) {
        CountSubArrayWithKDistinctElements elements = new CountSubArrayWithKDistinctElements();
        int[] arr = {2, 1, 2, 1, 6};
        int distinctElements = 2;

        int subArrayCount = elements.count(arr, distinctElements);

        logger.info("subArrayCount = " + subArrayCount);
    }

    int count(int[] array, int noOfDistinctElements) {
        int count = 0;

        for(int i = 0 ; i <= array.length-noOfDistinctElements ; i++) {
            int right = i + noOfDistinctElements;
           int[] subArray = Arrays.copyOfRange(array, i, right);
           int distinctElements = (int)Arrays.stream(subArray).distinct().count();

           if (distinctElements == noOfDistinctElements) {
               count++;
           }

           right++;
           while (right <= array.length) {
               subArray = Arrays.copyOfRange(array, i, right);
               distinctElements = (int)Arrays.stream(subArray).distinct().count();

               if (distinctElements > noOfDistinctElements) {
                   break;
               }

               if (distinctElements == noOfDistinctElements) {
                   count++;
               }
               right++;
           }
        }
        return count;
    }
}
