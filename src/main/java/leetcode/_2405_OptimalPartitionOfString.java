package leetcode;

import java.util.Arrays;

public class _2405_OptimalPartitionOfString {

    public static void main(String[] args) {
        _2405_OptimalPartitionOfString obj = new _2405_OptimalPartitionOfString();

        String s = "abacaba";
        System.out.println(obj.partitionString(s));
    }

    public int partitionString(String s) {
        int[] charCount = new int[26];

        int count = 0;
        for(char ch : s.toCharArray()) {
            if (charCount[ch - 'a'] > 0) {
                count++;
                Arrays.fill(charCount, 0);
            }
            charCount[ch - 'a']++;

        }
        count += Arrays.stream(charCount).filter(i -> i > 0).count() > 0 ? 1 : 0;
        return count;
    }
}
