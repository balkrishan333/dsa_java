package leetcode;

import java.util.Arrays;

public class _1561_MaximumNumberOfCoinsYouCanGet {

    public static void main(String[] args) {
        _1561_MaximumNumberOfCoinsYouCanGet obj = new _1561_MaximumNumberOfCoinsYouCanGet();

        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(obj.maxCoins(piles));
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int answer = 0;
        for (int i = piles.length/3; i < piles.length; i=i+2) {
            answer += piles[i];
        }
        return answer;
    }
}
