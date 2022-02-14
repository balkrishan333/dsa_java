package crackingcodinginterviewbook.ch1;

public final class OneAway_5 {

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "ple";

        boolean zeroOrOneDistance = checkDistance(s1, s2);
        System.out.println(zeroOrOneDistance);
    }

    /*
        Tweak: Can characters in 2 strings made same in o or 1 edit.
     */
    public static boolean checkDistance(String s1, String s2) {

        if (s1.length() - s2.length() > 1) {
            return false;
        }

        int[] charCountS1 = new int[26];
        int[] charCountS2 = new int[26];

        for (char ch : s1.toCharArray()) {
           charCountS1[ch -'a']++;
        }

        for (char ch : s2.toCharArray()) {
            charCountS2[ch -'a']++;
        }

        int distance = 0;
        for (int i = 0; i < 26; i++) {
            distance += Math.abs(charCountS1[i] - charCountS2[i]);
            if (s1.length() == s2.length() && distance > 2) {
                return false;
            }

            if (s1.length() != s2.length() && distance > 1) {
                return false;
            }
        }

        return true;
    }
}
