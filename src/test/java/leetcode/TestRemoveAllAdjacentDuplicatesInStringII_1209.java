package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRemoveAllAdjacentDuplicatesInStringII_1209 {

    @Test
    public void test_1() {
        _1209_RemoveAllAdjacentDuplicatesInStringII obj = new _1209_RemoveAllAdjacentDuplicatesInStringII();
        Assertions.assertEquals("aa", obj.removeDuplicates("deeedbbcccbdaa", 3));
    }

    @Test
    public void test_2() {
        _1209_RemoveAllAdjacentDuplicatesInStringII obj = new _1209_RemoveAllAdjacentDuplicatesInStringII();
        Assertions.assertEquals("abcd", obj.removeDuplicates("abcd", 2));
    }

    @Test
    public void test_3() {
        _1209_RemoveAllAdjacentDuplicatesInStringII obj = new _1209_RemoveAllAdjacentDuplicatesInStringII();
        Assertions.assertEquals("ps", obj.removeDuplicates("pbbcggttciiippooaais", 2));
    }

    @Test
    public void test_4() {
        _1209_RemoveAllAdjacentDuplicatesInStringII obj = new _1209_RemoveAllAdjacentDuplicatesInStringII();
        Assertions.assertEquals("", obj.removeDuplicates("abcd", 1));
    }
}
