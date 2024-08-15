package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _860_LemonadeChange {

    public static void main(String[] args) {
        _860_LemonadeChange obj = new _860_LemonadeChange();

        int[] bills = {10,10};
        System.out.println(obj.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> count = new HashMap<>();
        //initialize to avoid NPE
        count.put(5, 0);
        count.put(10, 0);
        count.put(20, 0);

        for (int bill : bills) {
            count.merge(bill, 1, Integer::sum);
            if (bill == 10) {
                if (count.get(5) > 0) {
                    count.merge(5, -1, Integer::sum);
                } else {
                    return false;
                }
            } else if (bill == 20) {
               if (count.get(10) > 0 && count.get(5) > 0) {
                   count.merge(5, -1, Integer::sum);
                   count.merge(10, -1, Integer::sum);
               } else if (count.get(5) >= 3) {
                   count.merge(5, -3, Integer::sum);
               } else {
                   return false;
               }
            }
        }
        return true;
    }
}
