package leetcode;

import java.util.Arrays;

public class _455_AssignCookies {

    public static void main(String[] args) {
        _455_AssignCookies obj = new _455_AssignCookies();

        int[] g = {1,2,3}, s = {1,1};
        System.out.println(obj.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int cookieIndex = 0;

        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }
}
