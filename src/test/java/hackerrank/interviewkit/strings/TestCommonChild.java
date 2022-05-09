package hackerrank.interviewkit.strings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TestCommonChild {

    @Test
    public void test_1() {
        String str1 = "AA";
        String str2 = "BB";

        CommonChild commonChild = new CommonChild();
        int count = commonChild.count(str1, str2);
        assertThat(count, is(0));
    }
    @Test
    public void test_2() {
        String str1 = "ABCD";
        String str2 = "ABCE";

        CommonChild commonChild = new CommonChild();
        int count = commonChild.count(str1, str2);
        assertThat(count, is(3));
    }
    @Test
    public void test_3() {
        String str1 = "SHINCHAN";
        String str2 = "NOHARAAA";

        CommonChild commonChild = new CommonChild();
        int count = commonChild.count(str1, str2);
        assertThat(count, is(3));
    }
    @Test
    public void test_4() {
        String str1 = "HARRY";
        String str2 = "SALLY";

        CommonChild commonChild = new CommonChild();
        int count = commonChild.count(str1, str2);
        assertThat(count, is(2));
    }
}
