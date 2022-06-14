package leetcode;

public class ExcelSheetColumnNumber_171 {

    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 obj = new ExcelSheetColumnNumber_171();

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
