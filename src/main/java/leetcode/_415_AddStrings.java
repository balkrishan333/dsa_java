package leetcode;

public class _415_AddStrings {

    public static void main(String[] args) {
        _415_AddStrings obj = new _415_AddStrings();

        String num1 = "999", num2 = "999";
        System.out.println(obj.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int carry = 0;

        StringBuilder sum = new StringBuilder();

        int i = num1.length()-1, j = num2.length()-1;
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                carry += num2.charAt(j) - '0';
                j--;
            }
            sum.append(carry%10);
            carry = carry / 10;
        }

        return sum.reverse().toString();
    }
}
