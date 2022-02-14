package hackerrank.strings;

/*
https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        TwoStrings twoStrings = new TwoStrings();
        String hasCommonString = twoStrings.checkCommonString(s1, s2);
        System.out.println("hasCommonString = " + hasCommonString);
    }

    private String checkCommonString(String s1, String s2) {
        boolean[] s1Chars = new boolean[26];

        for(int i = 0; i < s1.length() ; i++) {
            s1Chars[s1.charAt(i)-97] = true;
        }

        for(int i = 0; i < s2.length() ; i++) {
            if(s1Chars[s2.charAt(i)-97]){
                return "YES";
            }
        }
        return "NO";
    }
}
