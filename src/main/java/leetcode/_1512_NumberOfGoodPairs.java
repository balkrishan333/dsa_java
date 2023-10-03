package leetcode;

public class _1512_NumberOfGoodPairs {

    public static void main(String[] args) {
        _1512_NumberOfGoodPairs obj = new _1512_NumberOfGoodPairs();

        int[] nums = {1,1,1,1};
        System.out.println(obj.numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];

        for (int num : nums) {
            count[num]++;
        }

        int answer = 0;
        for (int cnt : count) {
            if (cnt > 1) {
                answer += cnt*(cnt-1)/2;
            }
        }
        return answer;
    }
}
