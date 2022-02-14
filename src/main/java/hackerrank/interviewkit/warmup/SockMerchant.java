package hackerrank.interviewkit.warmup;

/*
https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
 */
public final class SockMerchant {

    public static void main(String[] args) {

//        int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int[] arr = {1, 2, 1, 2, 1, 3, 2};

        SockMerchant sockMerchant = new SockMerchant();
        int count = sockMerchant.countPairs(arr);
        System.out.println("count = " + count);
    }

    int countPairs(int[] arr) {
        int[] elementCount = new int[101];
        int result = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (++elementCount[arr[i]] %2 == 0) {
                result++;
            }
        }
        return result;
    }
}
