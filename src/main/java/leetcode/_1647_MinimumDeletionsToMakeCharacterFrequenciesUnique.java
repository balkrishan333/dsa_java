package leetcode;

import java.util.Arrays;

public class _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique obj = new _1647_MinimumDeletionsToMakeCharacterFrequenciesUnique();

        String s = "ceabaacb";
        System.out.println(obj.minDeletions(s));
    }

    /*
        Approach: Calculate the no of characters to retain and subtract that from string length to get minimum no of chars to remove

        See inline comments fro more details
     */
    public int minDeletions(String s) {
        int[] charCount = new int[26];

        //count char frequency
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        //sort in ascending order, ideally in descending order because we need to traverse from largest to lowest value
        Arrays.sort(charCount);

        //take the max chars to retain
        int charsToRetain = charCount[25];
        int prev = charCount[25];

        for (int i = 24; i >= 0 && prev > 0; i--) {

            //at each step we need to make sure no of characters are at least 1 less than the prev, so we take prev-1 characters to
            // retain. Math.min is required because, next count might be lesser than (prev-1), so need to make sure that we take min of
            // both. Eg: [5,5,5] for this array we don't need min but for [5,3,1] we need min as (prev-1) will give incorrect result
            prev = Math.min(charCount[i], prev - 1);
            charsToRetain += prev;
        }
        return s.length() - charsToRetain;
    }
}