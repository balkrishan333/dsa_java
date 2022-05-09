package leetcode;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        LongestCommonPrefix_14 obj = new LongestCommonPrefix_14();

//        String[] strs = {"flower","flow","flight"};
        String[] strs = {"cir","car"};
        System.out.println(obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null) {
            return null;
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String s1 = strs[0];
        String s2 = strs[1];

        int endIndex = -1;
        int iteration = s1.length();
        if (s1.length() > s2.length()) {
            iteration = s2.length();
        }

        for (int i = 0; i < iteration; i++) {
            if (!s2.substring(0, i+1).equals(s1.substring(0, i+1))) {
                break;
            }
            endIndex++;
        }

        // +1, because end index is exclusive
        String prefix = s1.substring(0, endIndex+1);

        for (int j = 2; j < strs.length; j++) {
            boolean exists = strs[j].startsWith(prefix);
            if (!exists) {
                for (int k = prefix.length()-1; k >=0 ; k--) {
                    exists = strs[j].startsWith(prefix.substring(0, k));
                    if (exists) {
                        endIndex = k;
                        break;
                    }
                }
                prefix = prefix.substring(0, endIndex);
            }
        }
        return  prefix;
    }
}
