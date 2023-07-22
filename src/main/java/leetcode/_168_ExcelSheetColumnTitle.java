package leetcode;

public class _168_ExcelSheetColumnTitle {

    public static void main(String[] args) {
        _168_ExcelSheetColumnTitle obj = new _168_ExcelSheetColumnTitle();

        int columnNumber = 701;
        System.out.println(obj.convertToTitle(columnNumber));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; //because problem is 1 based but letters in ASCII are 0 based

            sb.append((char)(columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
