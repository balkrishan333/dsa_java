package leetcode;

public class _926_FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        _926_FlipStringToMonotoneIncreasing obj = new _926_FlipStringToMonotoneIncreasing();

        String  s = "00110";
        System.out.println(obj.minFlipsMonoIncr(s));
    }

    /*
        Consider 2 windows. Initially, right window contains each character and left is empty
        Right window should have 1's and left window should have 0's

        count no of zeros in strings. Since each character is in right window, no of zero is assigned to answer
        as we need to flip these characters (this is because right window is supposed to have 1's)

        Move each character from right to left, if charter is zero, reduce the answer by 1 nas left window is supposed
        to have zeros, if character is 1, increase the count by 1 as left window is supposed to have zeros and take
        minimum of count and answer.

     */
    public int minFlipsMonoIncr(String s) {

        int zeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeros++;
            }
        }

        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeros--;
                ans = Math.max(ans, zeros);
            } else {
                zeros++;
            }
        }
        return ans;
    }
}
