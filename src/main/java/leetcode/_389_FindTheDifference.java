package leetcode;

public class _389_FindTheDifference {

    public static void main(String[] args) {
        _389_FindTheDifference obj = new _389_FindTheDifference();

        String s = "abcd", t = "abcde";
        System.out.println(obj.findTheDifference(s, t));
    }

    public char findTheDifference(String s, String t) {
        int[] charCount = new int[26];

        int j = 0;
        for (int i = 0; i < s.length(); i++, j++) {
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(j)-'a']--;
        }
        charCount[t.charAt(j)-'a']--;

        for (int i = 0; i < 26; i++) {
            if (charCount[i] == -1) {
                return (char)(i + 'a');
            }
        }
        return (char)-1;
    }
}
