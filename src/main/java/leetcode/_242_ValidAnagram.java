package leetcode;

public class _242_ValidAnagram {

    public static void main(String[] args) {
        _242_ValidAnagram obj = new _242_ValidAnagram();

//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println(obj.isAnagram(s,t));
    }

    public boolean isAnagram(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        int[] charCnt = new int[26];

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        for (int i = 0; i < sCharArr.length; i++) {
            charCnt[sCharArr[i]-97]++;
        }

        for (int i = 0; i < tCharArr.length; i++) {
            charCnt[tCharArr[i]-97]--;
        }

        for (int i = 0; i < 26; i++) {
            if (charCnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
