package leetcode;

public class _605_CanPlaceFlowers {

    public static void main(String[] args) {
        _605_CanPlaceFlowers obj = new _605_CanPlaceFlowers();

        int[] flowerbed = {1,0,0,0,1};
        int n = 2;
        System.out.println(obj.canPlaceFlowers(flowerbed, n));
    }

    /*
        Approach: Count the no of pots that can be planted and if that number is more than or equals to n return true.

        We need to make sure if a pot is empty, it can be filled only if left and right side are empty, so need to check left and right
        First and last element need special handle because first won't have any left and last won't have any right
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean leftSideEmpty = (i == 0 || flowerbed[i-1] == 0);
                boolean rightSideEmpty = (i == flowerbed.length-1 || flowerbed[i+1] == 0);

                if (leftSideEmpty && rightSideEmpty) {
                    flowerbed[i] =1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
