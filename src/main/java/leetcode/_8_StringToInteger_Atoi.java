package leetcode;

public class _8_StringToInteger_Atoi {

    public static void main(String[] args) {
        _8_StringToInteger_Atoi obj = new _8_StringToInteger_Atoi();

//        String s = "   -42";
        String s = "-91283472332";
//        String s = "20000000000000000000";
        System.out.println(obj.myAtoi(s));
    }

    public int myAtoi(String s) {
        s = s.trim();

        if(s.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        int total = 0;
        while (index < s.length()) {
            char ch = s.charAt(index++);
            if (ch < 48 || ch > 57) {
                break;
            }
            //check if total will be overflow after 10 times and add digit
            if (total > Integer.MAX_VALUE/10 || (total == Integer.MAX_VALUE/10 && Integer.MAX_VALUE % 10 < ch-48)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total*10 + ch-48;
        }
        return total * sign;
    }
}
