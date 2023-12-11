package leetcode;

public class _1287_AppearingMoreThan25_PercentInSortedArray {

    public static void main(String[] args) {
        _1287_AppearingMoreThan25_PercentInSortedArray obj = new _1287_AppearingMoreThan25_PercentInSortedArray();

        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(obj.findSpecialInteger(arr));
    }

    public int findSpecialInteger(int[] arr) {
        int target = arr.length /4 + 1;

        int count = 1;
        int prevElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prevElement) {
                count++;
                if (count >= target) {
                    break;
                }
            } else {
                count = 1;
                prevElement = arr[i];
            }
        }
        return  prevElement;
    }
}
