package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_2434_UsingARobotToPrintTheLexicographicallySmallestString {

    @Test
    public void test1() {
        _2434_UsingARobotToPrintTheLexicographicallySmallestString obj = new _2434_UsingARobotToPrintTheLexicographicallySmallestString();
        String s = "zza";
        String result = obj.robotWithString(s);
        Assertions.assertEquals("azz", result);
    }

    @Test
    public void test2() {
        _2434_UsingARobotToPrintTheLexicographicallySmallestString obj = new _2434_UsingARobotToPrintTheLexicographicallySmallestString();
        String s = "bac";
        String result = obj.robotWithString(s);
        Assertions.assertEquals("abc", result);
    }

    @Test
    public void test3() {
        _2434_UsingARobotToPrintTheLexicographicallySmallestString obj = new _2434_UsingARobotToPrintTheLexicographicallySmallestString();
        String s = "bdda";
        String result = obj.robotWithString(s);
        Assertions.assertEquals("addb", result);
    }

}
