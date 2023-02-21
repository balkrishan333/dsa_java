package leetcode;

public class _540_SingleElementInASortedArray {

    public static void main(String[] args) {
        _540_SingleElementInASortedArray obj = new _540_SingleElementInASortedArray();

        int[] nums = {1,1,3,3,4,4,8,8,10};
        System.out.println(obj.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int answer = -1;

        //iterate till length-1, as need to check next element as well
        for(int i = 0; i < nums.length-1; i=i+2) {

            //if current and next element are equal, continue
            if(nums[i] == nums[i+1]) {
                continue;
            }

            //if pair is not equal, we get the element, break out of loop
            answer = nums[i];
            break;
        }

        //boundary case, when single element is last element, loop  will break out before reaching last element
        //as loop checks for i < length-1
        if (answer == -1) {
            return nums[nums.length-1];
        }

        return answer;
    }
}
