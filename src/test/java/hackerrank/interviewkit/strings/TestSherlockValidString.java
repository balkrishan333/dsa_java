package hackerrank.interviewkit.strings;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestSherlockValidString {

    @Test
    public void test1_shouldReturnYES() {
        String str = "abcc";
        SherlockValidString validString = new SherlockValidString();
        String check = validString.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }

    @Test
    public void test2_shouldReturnYES() {
        String str = "abc";
        SherlockValidString validString = new SherlockValidString();
        String check = validString.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }

    @Test
    public void test3_shouldReturnNO() {
        String str = "abccc";
        SherlockValidString validString = new SherlockValidString();
        String check = validString.check(str);
        assertThat(check, CoreMatchers.is("NO"));
    }

    @Test
    public void test4_shouldReturnYES() {
        String str = "a";
        SherlockValidString validString = new SherlockValidString();
        String check = validString.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }

    @Test
    public void test5_shouldReturnYES() {
        String str = "aaa";
        SherlockValidString validString = new SherlockValidString();
        String check = validString.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }

    @Test
    public void test6_shouldReturnYES() {
        String str = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        SherlockValidString validString = new SherlockValidString();
        String check = validString.check(str);
        assertThat(check, CoreMatchers.is("YES"));
    }
}
