package leetcode;

public class _1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    public static void main(String[] args) {
        _1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes obj =
                new _1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes();


        String s = "1001";
        System.out.println(obj.checkOnesSegment(s));
    }

    public boolean checkOnesSegment(String s) {
        int groups = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && (i == 0 || s.charAt(i-1) == '0')) {
                groups++;
                if (groups > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
