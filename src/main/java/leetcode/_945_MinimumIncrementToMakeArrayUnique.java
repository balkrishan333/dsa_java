package leetcode;

public class _945_MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        _945_MinimumIncrementToMakeArrayUnique obj = new _945_MinimumIncrementToMakeArrayUnique();

        int[] nums = {3,2,1,2,1,7};
        System.out.println(obj.minIncrementForUnique(nums));
    }

    public int minIncrementForUnique(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        //why we need an array of size n+max rather than of max, because we might have to go beyond max when trying to remove duplicates
        // and as one of the steps, we shift the duplicates to the next element
        int[] frequencyCount = new int[n + max];
        for (int num : nums) {
            frequencyCount[num]++;
        }

        int minimalIncrement = 0;
        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] > 1) {
                int duplicates = frequencyCount[i] - 1;
                frequencyCount[i+1] += duplicates; //duplicates are shifted to the next element
                frequencyCount[i] = 1;
                minimalIncrement += duplicates;
            }
        }
        return minimalIncrement;
    }
}
