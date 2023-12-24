package leetcode;

public class _1758_MinimumChangesToMakeAlternatingBinaryString {

    public static void main(String[] args) {
        _1758_MinimumChangesToMakeAlternatingBinaryString obj = new _1758_MinimumChangesToMakeAlternatingBinaryString();

        String s = "0100";
        System.out.println(obj.minOperations(s));
    }

    /*
        Approach: Check number of operation if string starts with 0 and string starts with 1 and minimum
     */
    public int minOperations(String s) {
        return Math.min(alternateChars('0', s), alternateChars('1', s));
    }

    private int alternateChars(char ch, String s) {
        int operations = 0;

        for (char curr : s.toCharArray()) {
            if (curr != ch) {
                operations++;
            }
            ch = ch == '0' ? '1' : '0';
        }
        return operations;
    }
}
