package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {

    private final List<List<String>> answer = new ArrayList<>();

    public static void main(String[] args) {
        _131_PalindromePartitioning obj = new _131_PalindromePartitioning();

        String s = "abcba";
        System.out.println(obj.partition(s));

    }

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return answer;
        }

        backtrack(s, new ArrayList<>());
        return answer;
    }

    private void backtrack(String str, List<String> seq) {
        if (str == null || str.length() == 0) {
            answer.add(new ArrayList<>(seq));
            return;
        }

        /*
            Since index is endIndex and substring method excludes the last character, so need to iterate till str.length
         */
        for (int endIndex = 1; endIndex <= str.length(); endIndex++) {
            String subStr = str.substring(0, endIndex);

            if (!isPalindrome(subStr)) {
                continue;
            }

            seq.add(subStr);
            backtrack(str.substring(endIndex), seq);
            seq.remove(seq.size()-1);
        }
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        int left = 0; int right = str.length()-1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
