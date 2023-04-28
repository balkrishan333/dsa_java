package leetcode;

public class _879_ProfitableSchemes {

    public static void main(String[] args) {
        _879_ProfitableSchemes obj = new _879_ProfitableSchemes();

        int n = 10;
        int minProfit = 5;
        int[] group = {2,3,5};
        int[] profit = {6,7,8};

        System.out.println(obj.profitableSchemes(n, minProfit, group, profit));
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int answer = 0;
        for (int i = 0; i < profit.length; i++) {
            for (int j = i+1; j < profit.length; j++) {
                for (int k = 1; k <= profit.length; k++) {
                    int sum = 0, grpSize = 0;
                    StringBuilder sb = new StringBuilder();
                    for (int l = i; l < k; l++) {
                        sb.append(profit[l] + ":" + group[l] + ",");
                        sum += profit[l];
                        grpSize += group[l];
                    }
                    System.out.println(sb);
                    if (sum >= minProfit && grpSize <= n) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
