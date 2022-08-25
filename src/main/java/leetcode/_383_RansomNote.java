package leetcode;

public class _383_RansomNote {

    public static void main(String[] args) {
        _383_RansomNote obj = new _383_RansomNote();

        String  ransomNote = "aa", magazine = "ab";
        System.out.println(obj.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null || magazine == null) {
            return false;
        }

        int[] magazineCharCnt = countChars(magazine);
        int[] ransomCharCnt = countChars(ransomNote);

        for (int i = 0; i < 26; i++) {
            if (magazineCharCnt[i] < ransomCharCnt[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] countChars(String magazine) {
        int[] magazineCharCnt = new int[26];

        char[] magazineCharArr = magazine.toCharArray();
        for (char c : magazineCharArr) {
            magazineCharCnt[c - 97]++;
        }
        return magazineCharCnt;
    }
}
