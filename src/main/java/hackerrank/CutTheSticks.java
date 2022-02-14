package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.hackerrank.com/challenges/cut-the-sticks/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */

public final class CutTheSticks {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};
        CutTheSticks sticks = new CutTheSticks();
        int[] count = sticks.count(arr);
        for (int i = 0 ; i < count.length ; i++) {
            System.out.println(count[i]);
        }
    }

    int[] count(int[] arr) {
        Arrays.sort(arr);

        int shortest;
        List<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] != 0) {
                /*In one iteration no. of sticks cut would be equal to no. of non-zero elements in arr
                   i.e. (length_of_array - index_of_first_non-zero_element)
                 */
                result.add(arr.length - i);
                shortest = arr[i]; //first non-zero element will be next shortest
                for (int j = i ; j < arr.length ; j++) {
                    arr[j] -= shortest;
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
