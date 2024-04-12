package leetcode;

public class _42_TrappingRainWater {

    public static void main(String[] args) {
        _42_TrappingRainWater obj = new _42_TrappingRainWater();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(height));
    }

    public int trap(int[] height) {
        int trappedWater = 0;
        int left = 0, right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
            }
        }
        return trappedWater;
    }
}
