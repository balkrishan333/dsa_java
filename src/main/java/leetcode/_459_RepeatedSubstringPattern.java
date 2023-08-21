package leetcode;

public class _459_RepeatedSubstringPattern {

    public static void main(String[] args) {
        _459_RepeatedSubstringPattern obj = new _459_RepeatedSubstringPattern();

        String s = "aba";
        System.out.println(obj.repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        String concatenate = s + s;
        String withoutFirstAndLastChar = concatenate.substring(1, concatenate.length()-1);

        return withoutFirstAndLastChar.contains(s);
    }
}
