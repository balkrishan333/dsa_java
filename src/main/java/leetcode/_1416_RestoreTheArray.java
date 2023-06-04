package leetcode;

public class _1416_RestoreTheArray {

    public static void main(String[] args) {
        _1416_RestoreTheArray obj = new _1416_RestoreTheArray();

        String s = "1317";
        int k = 2000;
        System.out.println(obj.numberOfArrays(s, k));
    }

    public int numberOfArrays(String s, int k) {
        int[] dp = new int[s.length()+1];
        return count(s, k, dp, 0);
    }

    private int count(String s, int k, int[] dp, int index) {

        if (dp[index] != 0) {
            return dp[index];
        }

        //if current index is last character in string, it can have at max 1 number
        if (index == s.length()) {
            return 1;
        }

        //if first character is 0, return 0, as we can't have any valid numbers in this substring as 0 is not allowed to be first character
        if (s.charAt(index) == '0') {
            return 0;
        }

        int answer = 0;

        //From each index take substring of every length and try to calculate the answer
        for (int i = index; i < s.length(); i++) {
            //if current string value is more than k, break as including more characters will only increase the value
            if (Long.parseLong(s.substring(index, i+1)) > k) {
                break;
            }
            answer = (answer + count(s, k, dp, i+1)) % 1000000007;
        }
        dp[index] = answer;
        return dp[index];
    }
}
