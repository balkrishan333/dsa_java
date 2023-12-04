package leetcode;

public class _2264_Largest_3_SameDigitNumberInString {

    public static void main(String[] args) {
        _2264_Largest_3_SameDigitNumberInString obj = new _2264_Largest_3_SameDigitNumberInString();

        String num = "6777133339";
        System.out.println(obj.largestGoodInteger(num));
    }

    public String largestGoodInteger(String num) {
        if (num.length() < 3) {
            return "";
        }

        char[] chars = num.toCharArray();
        int answer = Integer.MIN_VALUE;

        for (int i = 2; i < chars.length; i++) {
            if (chars[i] == chars[i-1] && chars[i-1] == chars[i-2]) {
                if (chars[i] > answer) {
                    answer = chars[i];
                }
            }
        }

        if (answer == Integer.MIN_VALUE) {
            return "";
        }

        answer = answer - 48;

        //below expression will return 0, if answer is 0 and answer requires string of length 3, so consider 0 separately
        if (answer == 0) {
            return "000";
        }

        answer = answer *100 + answer*10 + answer;

        return Integer.toString(answer);
    }
}
