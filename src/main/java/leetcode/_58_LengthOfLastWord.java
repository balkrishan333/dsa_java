package leetcode;

public class _58_LengthOfLastWord {

    public static void main(String[] args) {
        _58_LengthOfLastWord obj = new _58_LengthOfLastWord();

        String s = "   fly me   to   the moon  ";
        System.out.println(obj.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length-1].length();
    }
}
