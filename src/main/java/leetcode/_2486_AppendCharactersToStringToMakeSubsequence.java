package leetcode;

public class _2486_AppendCharactersToStringToMakeSubsequence {

    public static void main(String[] args) {
        _2486_AppendCharactersToStringToMakeSubsequence obj = new _2486_AppendCharactersToStringToMakeSubsequence();

        String s = "coaching", t = "coding";
        System.out.println(obj.appendCharacters(s, t));
    }

    /*
        Approach :
     */
    public int appendCharacters(String s, String t) {
        if (s.equals(t)) {
            return 0;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        //i is index to chars in s and j is index to chars in t
        int j = 0;
        for (int i = 0; i < s.length(); i++) { //loop through all characters of s

            //if chars are same at current indexes, then we found a characters in t, so increment index of j(love to next char)
            if (charS[i] == charT[j]) {
                j++;
            }

            //if no. of chars matched are same as length of t, return 0, as no operations are required
            if (j == t.length()) {
                return 0;
            }
        }

        //remove no. of chars matched from length of t
        return t.length() - j;
    }
}
