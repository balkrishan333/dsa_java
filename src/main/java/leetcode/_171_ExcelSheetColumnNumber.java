package leetcode;

public class _171_ExcelSheetColumnNumber {

    public static void main(String[] args) {
        _171_ExcelSheetColumnNumber obj = new _171_ExcelSheetColumnNumber();

        String title = "ZY";
        System.out.println(obj.titleToNumber(title));
    }

    public int titleToNumber(String columnTitle) {
        int[] chars = new int[26];

        for (char i = 0; i < 26; i++) {
            chars[i] = i +1 ;
        }

        int result = 0;
        for (int i = columnTitle.length()-1; i >= 0 ; i--) {
            result += ((int)Math.pow(26,columnTitle.length()- i-1)) * chars[columnTitle.charAt(i) - 'A'];
        }

        return result;
    }
}
