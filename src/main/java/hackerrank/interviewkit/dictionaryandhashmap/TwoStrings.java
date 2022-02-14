package hackerrank.interviewkit.dictionaryandhashmap;

public class TwoStrings {

    public static void main(String[] args) {
        String s1 = "hi";
        String s2 = "world";

        TwoStrings twoStrings = new TwoStrings();
        String result = twoStrings.checkCommonSubStr(s1, s2);
        System.out.println("result = " + result);
    }

    public String checkCommonSubStr(String s1, String s2) {
        boolean[] chars = new boolean[256];

        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (chars[s2.charAt(i)]) {
                return "YES";
            }
        }
        return "NO";
    }


}
