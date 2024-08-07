package leetcode;

public class _273_IntegerToEnglishWords {

    public static void main(String[] args) {
        _273_IntegerToEnglishWords obj = new _273_IntegerToEnglishWords();

        int num = 1234567;
        System.out.println(obj.numberToWords(num));
    }

    /*
        Process in group of thousands and prefix the batch with appropriate unit like thousand, million etc.
     */
    public String numberToWords(int num) {
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};

        StringBuilder result = new StringBuilder();
        int groupIndex = 0;

        if (num == 0) {
            return "Zero";
        }

        while (num > 0) {
            if (num % 1000 != 0) {
                StringBuilder groupResult = new StringBuilder();
                int group = num % 1000;

                if (group >= 100) {
                    groupResult.append(ones[group/100]).append(" Hundred ");
                    group = group % 100;
                }

                if (group >= 20) {
                    groupResult.append(tens[group/10]).append(" ");
                    group = group % 10;
                }

                if (group > 0) {
                    groupResult.append(ones[group]).append(" ");
                }
                groupResult.append(thousands[groupIndex]).append(" ");
                result.insert(0, groupResult);
            }
            num = num / 1000;
            groupIndex++;
        }
        return result.toString().trim();
    }
}
