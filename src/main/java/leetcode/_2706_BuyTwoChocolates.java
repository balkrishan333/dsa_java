package leetcode;

public class _2706_BuyTwoChocolates {

    public static void main(String[] args) {
        _2706_BuyTwoChocolates obj = new _2706_BuyTwoChocolates();

        int[] prices = {3,2,3};
        int money = 3;
        System.out.println(obj.buyChoco(prices, money));
    }

    public int buyChoco(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int price : prices) {
            if(price < min) {
                secondMin = min;
                min = price;
            } else {
                secondMin = Math.min(secondMin, price);
            }
        }
        int leftover = money - (min + secondMin);
        return  leftover >= 0 ? leftover : money;
    }
}
