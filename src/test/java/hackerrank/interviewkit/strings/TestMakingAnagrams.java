package hackerrank.interviewkit.strings;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class TestMakingAnagrams {

    @Test
    public void test_1() {
        String str1 = "abc";
        String str2 = "cde";

        MakingAnagrams anagrams = new MakingAnagrams();
        int deletions = anagrams.countDeletions(str1, str2);

        assertThat(deletions, is(4));
    }

    @Test
    public void test_2() {
        String str1 = "bacdc";
        String str2 = "dcbac";

        MakingAnagrams anagrams = new MakingAnagrams();
        int deletions = anagrams.countDeletions(str1, str2);

        assertThat(deletions, is(0));
    }

    @Test
    public void test_3() {
        String str1 = "bacdc";
        String str2 = "dcbad";

        MakingAnagrams anagrams = new MakingAnagrams();
        int deletions = anagrams.countDeletions(str1, str2);

        assertThat(deletions, is(2));
    }

    @Test
    public void test_4() {
        String str1 = "fcrxzwscanmligyxyvym";
        String str2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        MakingAnagrams anagrams = new MakingAnagrams();
        int deletions = anagrams.countDeletions(str1, str2);

        assertThat(deletions, is(30));
    }
}
