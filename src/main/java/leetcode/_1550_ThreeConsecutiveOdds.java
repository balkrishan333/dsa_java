package leetcode;

public class _1550_ThreeConsecutiveOdds {

    public static void main(String[] args) {
        _1550_ThreeConsecutiveOdds obj = new _1550_ThreeConsecutiveOdds();

        int[] arr = {2,4,5,1,9};
        System.out.println(obj.threeConsecutiveOdds(arr));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i <= arr.length-3; i++) {
            if (arr[i] %2 == 1 && arr[i+1] % 2 == 1 && arr[i+2] %2 == 1) {
                return true;
            }
        }
        return false;
    }
}
