package leetcode;

public class _1323_Maximum_69_Number {

    public static void main(String[] args) {
        _1323_Maximum_69_Number obj = new _1323_Maximum_69_Number();
        int num  = 9669;

        System.out.println(obj.maximum69Number(num));
    }

    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        int index = s.indexOf("6");
        if(index == -1) {
            return num;
        }

        char[] chars = s.toCharArray();
        chars[index] = '9';

        return Integer.parseInt(new String(chars));
    }
}
