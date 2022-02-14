package geekforgeeks;

import geekforgeeks.SmallestWindowContainingAllCharacters;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestSmallestWindowContainingAllCharacters {

    @Test
    public void test_1() {
         String str = "this is a test string";
         String pattern = "tist";

         SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
         String result = solution.findSubString(str, pattern);
         assertThat(result, is("t stri"));
    }

    @Test
    public void test_2() {
        String str = "thi";
        String pattern = "tist";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("-1"));
    }

    @Test
    public void test_3() {
        String str = "play match";
        String pattern = "play";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("play"));
    }

    @Test
    public void test_4() {
        String str = "match";
        String pattern = "match";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("match"));
    }

    @Test
    public void test_5() {
        String str = "match";
        String pattern = "play";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("-1"));
    }

    @Test
    public void test_6() {
        String str = "play match";
        String pattern = "match";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("match"));
    }

    @Test
    public void test_7() {
        String str = "mmmmm";
        String pattern = "match";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("-1"));
    }

    @Test
    public void test_8() {
        String str = "geeksforgeeks";
        String pattern = "ork";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("ksfor"));
    }

    @Test
    public void test_9() {
        String str = "timetopractice";
        String pattern = "toc";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("toprac"));
    }@Test
    public void test_10() {
        String str = "zoomlazapzo";
        String pattern = "oza";

        SmallestWindowContainingAllCharacters solution = new SmallestWindowContainingAllCharacters();
        String result = solution.findSubString(str, pattern);
        assertThat(result, is("apzo"));
    }
}
