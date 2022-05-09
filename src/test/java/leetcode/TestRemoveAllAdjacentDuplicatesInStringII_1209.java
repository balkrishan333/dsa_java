package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRemoveAllAdjacentDuplicatesInStringII_1209 {

    @Test
    public void test_1() {
        RemoveAllAdjacentDuplicatesInStringII_1209 obj = new RemoveAllAdjacentDuplicatesInStringII_1209();
        Assertions.assertEquals("aa", obj.removeDuplicates("deeedbbcccbdaa", 3));
    }

    @Test
    public void test_2() {
        RemoveAllAdjacentDuplicatesInStringII_1209 obj = new RemoveAllAdjacentDuplicatesInStringII_1209();
        Assertions.assertEquals("abcd", obj.removeDuplicates("abcd", 2));
    }

    @Test
    public void test_3() {
        RemoveAllAdjacentDuplicatesInStringII_1209 obj = new RemoveAllAdjacentDuplicatesInStringII_1209();
        Assertions.assertEquals("ps", obj.removeDuplicates("pbbcggttciiippooaais", 2));
    }

    @Test
    public void test_4() {
        RemoveAllAdjacentDuplicatesInStringII_1209 obj = new RemoveAllAdjacentDuplicatesInStringII_1209();
        Assertions.assertEquals("", obj.removeDuplicates("abcd", 1));
    }
}
