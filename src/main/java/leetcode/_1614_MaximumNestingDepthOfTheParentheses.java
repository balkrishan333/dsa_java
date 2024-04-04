package leetcode;

public class _1614_MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        _1614_MaximumNestingDepthOfTheParentheses obj = new _1614_MaximumNestingDepthOfTheParentheses();

        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(obj.maxDepth(s));
    }

    public int maxDepth(String s) {
        int maxDepth = Integer.MIN_VALUE;
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
            } else if (ch == ')') {
                depth--;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}
