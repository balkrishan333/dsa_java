package leetcode;

public class _1608_SpecialArrayWith_X_ElementsGreaterThanOrEqual_X {

    public static void main(String[] args) {
        _1608_SpecialArrayWith_X_ElementsGreaterThanOrEqual_X obj = new _1608_SpecialArrayWith_X_ElementsGreaterThanOrEqual_X();

        int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(obj.specialArray(nums));
    }

    /*
        Approach:
        1. Count the existence of each element
        2. Track the max element
        3. Since all elements are in range 0-1000, so to begin with all elements are greater than or equal to 0. So for x=0, set
        greaterThanX to array.length
        4. Since we need to count all the elements greater or equal to x, so remove the count of previous x as we move forward
     */
    public int specialArray(int[] nums) {
        int[] count = new int[1001];
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            count[num] += 1;
        }

        int greaterThanX = nums.length; // X is zero to begin with. All the elements are greater than or equal to Zero
        for (int i = 0; i <= max; i++) {
            if (greaterThanX == i) {
                return i;
            }
            greaterThanX -= count[i]; //remove the count of current element before moving onto next
        }
        return -1;
    }
}
