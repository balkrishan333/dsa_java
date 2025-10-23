package leetcode;

public class _3461_CheckIfDigitsAreEqualInStringAfterOperations_I {

    public static void main(String[] args) {
        _3461_CheckIfDigitsAreEqualInStringAfterOperations_I obj =
                new _3461_CheckIfDigitsAreEqualInStringAfterOperations_I();

        String s = "3902";
        System.out.println(obj.hasSameDigits(s));
    }

    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > 2) {
            for (int i = 0; i < s.length()-1; i++) {
                //48 is ascii code for 0. This is required because we get chars from string not ints
                int newDigit = ( s.charAt(i)-48 + s.charAt(i + 1)-48) % 10;
                sb.append(newDigit);
            }
            s = sb.toString();
            sb.setLength(0);
        }
        return s.charAt(0) == s.charAt(1);
    }
}
