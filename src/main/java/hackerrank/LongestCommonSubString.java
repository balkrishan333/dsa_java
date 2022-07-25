package hackerrank;

public class LongestCommonSubString {

    public static void main(String[] args) {
        LongestCommonSubString obj = new LongestCommonSubString();
        String s1 = "adac", s2 = "adadac";

        System.out.println(obj.findCommonSubString(s1, s2));
    }

    public String findCommonSubString(String s1, String s2) {
        int i = 0, j=0, start = -1, end = -1;
        String common = "";

        for (; i < s1.length() && j < s2.length(); ) {
            if (s2.indexOf(s1.charAt(i)) != -1) {
                start = i;
                j = s2.indexOf(s1.charAt(i));
                end = i;

                while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                    end++;
                    j++;
                    i++;
                }
                String subString = s1.substring(start, end);
                common = subString.length() > common.length() ? subString : common;
            }
            i++;
        }

        return common;
    }
}
