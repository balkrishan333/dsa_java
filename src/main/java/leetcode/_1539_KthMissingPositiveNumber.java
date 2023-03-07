package leetcode;

public class _1539_KthMissingPositiveNumber {

    public static void main(String[] args) {
        _1539_KthMissingPositiveNumber obj = new _1539_KthMissingPositiveNumber();

        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(obj.findKthPositive(arr, k));
    }

    /*


    Need to understand it. Have very high level understanding

    arr[mid]: if there are no missing positives, then the number of positives till mid is arr[mid]
    mid: mid + 1 is the actual number of positives till index mid (+1 is because the positives start from 1)
    arr[mid] - (mid + 1): number of missing positives at index mid
    if the number of missing positives at index mid is less than k (arr[mid] - (mid + 1) < k), it means we didn't find
    the position for kth positive and so left = mid + 1
    The same for arr[mid] - (mid + 1) > k

    The BS helps to find that kth positive is between arr[left - 1] and arr[left]:

    The number of missing positives at index left - 1: arr[left - 1] - (left - 1 + 1) = arr[left - 1] - left
    The number of missing positives from index left - 1 to k: k - (arr[left - 1] - left)
    The actual kth value starting from arr[left - 1]: arr[left - 1] + {k - (arr[left - 1] - l)} = k + left
     */
    public int findKthPositive(int[] arr, int k) {

        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] - 1 - mid < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left + k;
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
