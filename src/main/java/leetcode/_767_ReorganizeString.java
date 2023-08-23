package leetcode;

public class _767_ReorganizeString {

    public static void main(String[] args) {
        _767_ReorganizeString obj = new _767_ReorganizeString();

        String s = "vvvlo";
        System.out.println(obj.reorganizeString(s));
    }

    public String reorganizeString(String s) {
        int[] charCount = new int[26];

        for (char ch : s.toCharArray()) {
            charCount[ch-'a']++;
        }

        int maxCount = 0;
        char maxCountChar = 'a';
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > maxCount) {
                maxCount = charCount[i];
                maxCountChar = (char)(i + 'a');
            }
        }

        //if max count is more than half the string length return empty string
        if (maxCount > (s.length()+1)/2) {
            return "";
        }

        char[] chArr = new char[s.length()];
        int index = 0;
        for (int i = 0 ; i < maxCount ; i++) {
            chArr[index] = maxCountChar;
            charCount[maxCountChar-'a']--;
            index += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                chArr[index] = (char)(i+'a');
                index += 2;
                charCount[i]--;
            }
        }
        return new String(chArr);
    }
}
