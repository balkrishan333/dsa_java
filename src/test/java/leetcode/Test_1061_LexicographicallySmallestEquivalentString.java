package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_1061_LexicographicallySmallestEquivalentString {

    @Test
    public void test1() {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        _1061_LexicographicallySmallestEquivalentString obj = new _1061_LexicographicallySmallestEquivalentString();
        String ans = obj.smallestEquivalentString(s1, s2, baseStr);

        Assertions.assertEquals("makkek", ans);
    }

    @Test
    public void test2() {
        String s1 = "hello", s2 = "world", baseStr = "hold";
        _1061_LexicographicallySmallestEquivalentString obj = new _1061_LexicographicallySmallestEquivalentString();
        String ans = obj.smallestEquivalentString(s1, s2, baseStr);

        Assertions.assertEquals("hdld", ans);
    }

    @Test
    public void test3() {
        String s1 = "leetcode", s2 = "programs", baseStr = "sourcecode";
        _1061_LexicographicallySmallestEquivalentString obj = new _1061_LexicographicallySmallestEquivalentString();
        String ans = obj.smallestEquivalentString(s1, s2, baseStr);

        Assertions.assertEquals("aauaaaaada", ans);
    }
}
