package leetcode;

public class _1523_CountOddNumbersInAnIntervalRange {

    public static void main(String[] args) {
        _1523_CountOddNumbersInAnIntervalRange obj = new _1523_CountOddNumbersInAnIntervalRange();

        int low = 3, high = 7;
        System.out.println(obj.countOdds(low, high));
    }

    public int countOdds(int low, int high) {
        int answer = (high - low)/2;

        if(low % 2 == 1 || high % 2 == 1) {
            return answer +1;
        }
        return answer;
    }
}
