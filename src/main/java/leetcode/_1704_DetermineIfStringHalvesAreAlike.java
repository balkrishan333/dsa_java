package leetcode;

public class _1704_DetermineIfStringHalvesAreAlike {

    public static void main(String[] args) {
        _1704_DetermineIfStringHalvesAreAlike obj = new _1704_DetermineIfStringHalvesAreAlike();

        String s = "textbook";
        System.out.println(obj.halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        int i = 0, j = len-1;
        int firstHalfVowelCnt = 0, secondHalfVowelCnt = 0;

        for (; i < len/2 && j >= len/2 ; i++,j--) {
            if (isVowel(s.charAt(i))) {
                firstHalfVowelCnt++;
            }

            if (isVowel(s.charAt(j))) {
                secondHalfVowelCnt++;
            }
        }
        return firstHalfVowelCnt == secondHalfVowelCnt;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
