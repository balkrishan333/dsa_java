package leetcode;

public class _1539_KthMissingPositiveNumber {

    public static void main(String[] args) {
        _1539_KthMissingPositiveNumber obj = new _1539_KthMissingPositiveNumber();

        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(obj.findKthPositive(arr, k));
    }

    public int findKthPositive(int[] A, int k) {
        int l = 0, r = A.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] - 1 - m < k)
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }

    public int findKthPositive_linear(int[] arr, int k) {
        boolean[] exists = new boolean[1001];

        for (int j : arr) {
            exists[j] = true;
        }

        int i = 1;
        for (; i < exists.length && k > 0; i++) {
            if(!exists[i]) {
                k--;
            }
        }

        //missing element can be more than length arr.length. If k is not zeo, it means we need to look beyond
        //1000 which is restriction of element in array
        if (k > 0) {
            return 1000 + k;
        }

        return i-1;
    }
}
