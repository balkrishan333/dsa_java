package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _3442_MaximumDifferenceBetweenEvenAndOddFrequency_I {

    public static void main(String[] args) {
        _3442_MaximumDifferenceBetweenEvenAndOddFrequency_I obj = new _3442_MaximumDifferenceBetweenEvenAndOddFrequency_I();
        String s = "aaaaabbc";
        System.out.println(obj.maxDifference(s));
    }

    public int maxDifference(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0)+1);
        }

        int oddMax = -1, evenMin = s.length();
        for (Integer count : charCount.values()) {
            if (count % 2 == 0) {
                evenMin = Math.min(evenMin, count);
            } else {
                oddMax = Math.max(oddMax, count);
            }
        }
        return oddMax - evenMin;
    }
}
