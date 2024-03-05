package leetcode;

public class _1750_MinimumLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        _1750_MinimumLengthOfStringAfterDeletingSimilarEnds obj = new _1750_MinimumLengthOfStringAfterDeletingSimilarEnds();

        String s = "cabaabac";
        System.out.println(obj.minimumLength(s));
    }

    public int minimumLength(String s) {
        int start = 0, end = s.length()-1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) { //if prefix and suffix start from same character
                while (end - start > 1 && s.charAt(start+1) == s.charAt(start)) {
                    start++;
                }
                while (end - start > 1 && s.charAt(end-1) == s.charAt(end)) {
                    end--;
                }
            } else {
                return end - start + 1;
            }
            start++;
            end--;
        }
        return end - start + 1;
    }
}
