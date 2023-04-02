package leetcode;

import java.util.Arrays;

public class _2300_SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        _2300_SuccessfulPairsOfSpellsAndPotions obj = new _2300_SuccessfulPairsOfSpellsAndPotions();

        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;

        System.out.println(Arrays.toString(obj.successfulPairs(spells, potions, success)));
    }

    /*
        Approach:
        For any potion if spell[i] * potion is greater than success then this potion and all potions greater than potion are part of
        answer. So, we sort the potions and find minPotion for which product of spell and potion is greater than success.

        How having minPotion, need to find all tle elements in potions which are greater than or equal to minPotion, that is the answer.

     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] answer = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {

            /*
                find minPotion for which the required property holds true
                spell * minPotion ≥ success
                minPotion ≥ success / spell
                minPotion = ceil(success / spell)
             */
            int minPotion = (int)Math.ceil((double) success/spells[i]);

            if (potions[potions.length-1] < minPotion) {
                answer[i] = 0;
                continue;
            }

            //Use Binary search to find index of element less than minPotion
            int lo = 0, hi = potions.length-1;
            while (lo < hi) {
                int mid = lo + (hi - lo)/2;
                if (potions[mid] < minPotion) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            answer[i] = potions.length - lo;
        }
        return answer;
    }
}
