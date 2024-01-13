package leetcode;

public class _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main(String[] args) {
        _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram obj = new _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram();

        String s = "leetcode", t = "practice";
        System.out.println(obj.minSteps(s,t));
    }

    public int minSteps(String s, String t) {
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];

        for (char ch : s.toCharArray()) {
            sCharCount[ch-'a']++;
        }

        for (char ch : t.toCharArray()) {
            tCharCount[ch-'a']++;
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (tCharCount[i] < sCharCount[i]) {
                answer += sCharCount[i] - tCharCount[i];
            }
        }
        return answer;
    }
}
