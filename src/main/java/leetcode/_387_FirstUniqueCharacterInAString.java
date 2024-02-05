package leetcode;

public class _387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        _387_FirstUniqueCharacterInAString obj = new _387_FirstUniqueCharacterInAString();

        String s = "leetcode";
        System.out.println(obj.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        int[] charCount = new int[26];

        char[] charArr = s.toCharArray();

        for(char ch : charArr) {
            charCount[ch-97]++;
        }

        for(int i = 0; i < charArr.length; i++) {
            if(charCount[charArr[i]-97] == 1) {
                return i;
            }
        }
        return -1;
    }
}
