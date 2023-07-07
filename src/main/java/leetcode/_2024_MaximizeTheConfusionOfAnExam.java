package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2024_MaximizeTheConfusionOfAnExam {

    public static void main(String[] args) {
        _2024_MaximizeTheConfusionOfAnExam obj = new _2024_MaximizeTheConfusionOfAnExam();

        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(obj.maxConsecutiveAnswers(answerKey, k));
    }

    /*
        Approach: Sliding window
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, right = 0, maxSize = Integer.MIN_VALUE;
        Map<Character, Integer> count = new HashMap<>();
        count.put('T', 0);
        count.put('F', 0);

        for (; right < answerKey.length(); right++) {
            count.merge(answerKey.charAt(right), 1, Integer::sum);

            while (Math.min(count.get('T'), count.get('F')) > k) {
                count.merge(answerKey.charAt(left++), -1, Integer::sum);
            }
            maxSize = Math.max(maxSize, right -left +1);
        }
        return maxSize;
    }
}
