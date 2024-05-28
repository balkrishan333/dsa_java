package leetcode;

public class _1208_GetEqualSubstringsWithinBudget {

    public static void main(String[] args) {
        _1208_GetEqualSubstringsWithinBudget obj = new _1208_GetEqualSubstringsWithinBudget();

        String s = "abcd", t = "zyxw";
        int maxCost = 3;
        System.out.println(obj.equalSubstring(s, t, maxCost));
    }

    public int equalSubstring(String s, String t, int maxCost) {

        int maxSize = 0;
        int currCost = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            currCost += Math.abs(s.charAt(i) - t.charAt(i));

            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(startIndex) - t.charAt(startIndex));
                startIndex++;
            }
            maxSize = Math.max(maxSize, i - startIndex + 1);
        }
        return maxSize;
    }
}
