package leetcode;

public class _3005_CountElementsWithMaximumFrequency {

    public static void main(String[] args) {
        _3005_CountElementsWithMaximumFrequency obj = new _3005_CountElementsWithMaximumFrequency();

        int[] nums = {1,2,2,3,1,4};
        System.out.println(obj.maxFrequencyElements(nums));
    }

    public int maxFrequencyElements(int[] nums) {
        int maxFrequency = 0;
        int elementsWithMaxFrequency = 0;
        int[] frequency = new int[101];

        for (int num : nums) {
            frequency[num]++;
            if (frequency[num] > maxFrequency) {
                maxFrequency = frequency[num];
                elementsWithMaxFrequency = 1;
            } else if (frequency[num] == maxFrequency) {
                elementsWithMaxFrequency++;
            }
        }
        return maxFrequency * elementsWithMaxFrequency;
    }
}
