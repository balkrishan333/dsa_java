package leetcode;

public class _2109_AddingSpacesToAString {

    public static void main(String[] args) {
        _2109_AddingSpacesToAString obj = new _2109_AddingSpacesToAString();

        int[] spaces = {8,13,15};
        String s = "LeetcodeHelpsMeLearn";
        System.out.println(obj.addSpaces(s, spaces));
    }

    public String addSpaces(String s, int[] spaces) {
        if (spaces.length == 0 || s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int spaceIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                builder.append(" ");
                spaceIndex++;
            }
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
