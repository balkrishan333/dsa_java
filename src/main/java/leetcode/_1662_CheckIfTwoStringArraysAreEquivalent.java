package leetcode;

public class _1662_CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        _1662_CheckIfTwoStringArraysAreEquivalent obj = new _1662_CheckIfTwoStringArraysAreEquivalent();

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(obj.arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(String s : word1) {
            s1.append(s);
        }

        for(String s : word2) {
            s2.append(s);
        }

        return s1.toString().equals(s2.toString());
    }
}
