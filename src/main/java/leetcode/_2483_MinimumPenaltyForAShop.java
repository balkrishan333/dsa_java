package leetcode;

public class _2483_MinimumPenaltyForAShop {

    public static void main(String[] args) {
        _2483_MinimumPenaltyForAShop obj = new _2483_MinimumPenaltyForAShop();

        String customers = "YYNY";
        System.out.println(obj.bestClosingTime(customers));
    }

    /*
        Approach: In first pass calculate the penalty assuming shop will be closed on first day itself.

        In 2nd pass, increase the closing window by one step and recalculate the penalty depending upon outing
        character is Y or N
     */
    public int bestClosingTime(String customers) {
        int currPenalty = 0;
        for (char ch : customers.toCharArray()) {
            if (ch == 'Y'){
                currPenalty++;
            }
        }

        int minPenalty = currPenalty;
        int minTime = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                currPenalty--;
            } else {
                currPenalty++;
            }
            if (currPenalty < minPenalty) {
                minPenalty = currPenalty;
                minTime = i+1;
            }
        }
        return minTime;
    }
}
