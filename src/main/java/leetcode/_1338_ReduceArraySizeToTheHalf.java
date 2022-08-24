package leetcode;

import java.util.Arrays;

public class _1338_ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        _1338_ReduceArraySizeToTheHalf obj = new _1338_ReduceArraySizeToTheHalf();

        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(obj.minSetSize(arr));
    }

    public int minSetSize(int[] arr) {
        int[] count = new int[100000];

        //O(n)
        Arrays.stream(arr).forEach(ele -> {
            count[ele]++;
        });

        //O(n log n)
        Arrays.sort(count);

        int result = 0;
        int index = count.length-1;
        int setSize = 0;

        //O(n)
        while (setSize < arr.length/2 && index >= 0) {
            result++;
            setSize += count[index--];
        }
        return result;
    }
}
