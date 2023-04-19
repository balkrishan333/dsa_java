package leetcode;

public class _11_ContainerWithMostWater {

    public static void main(String[] args) {
        _11_ContainerWithMostWater obj = new _11_ContainerWithMostWater();

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
    }

    /*
        Approach: 2 pointer approach

        start from both ends of array, select minimum of both elements and calculate ares. Move the pointer whose value is less, goal os
        to get a higher value in array to maximise the area.
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;

        int answer = -1;

        while (left < right) {
            int area = (right-left) * Math.min(height[left], height[right]);

            answer = Math.max(answer, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
