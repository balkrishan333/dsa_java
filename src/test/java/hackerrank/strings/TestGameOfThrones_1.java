package hackerrank.strings;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestGameOfThrones_1 {

    @Test
    public void test_1_shouldReturnYes() {
        String str = "aabbccdd";
        GameOfThrones_1 game = new GameOfThrones_1();
        String check = game.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }

    @Test
    public void test_2_shouldReturnYes() {
        String str = "aaabbbb";
        GameOfThrones_1 game = new GameOfThrones_1();
        String check = game.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }

    @Test
    public void test_3_shouldReturnNo() {
        String str = "cdefghmnopqrstuvw";
        GameOfThrones_1 game = new GameOfThrones_1();
        String check = game.check(str);
        assertThat(check, CoreMatchers.is("NO"));
    }

    @Test
    public void test_4_shouldReturnYes() {
        String str = "cdcdcdcdeeeef";
        GameOfThrones_1 game = new GameOfThrones_1();
        String check = game.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }
}
