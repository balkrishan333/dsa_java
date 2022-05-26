package leetcode;

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        ValidPalindrome_125 obj = new ValidPalindrome_125();
//        String s = "A man, a plan, a canal: Panama";
        String s = " ";

        System.out.println(obj.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return true;
        }

        int i = 0, j = s.length()-1;

        while (i <= j) {
            while (!isAlphaNeumeric(s.charAt(i))) {
                i++;
                if (i >= j) {
                    return true;
                }
            }

            while (!isAlphaNeumeric(s.charAt(j))) {
                j--;
                if (i >= j) {
                    return true;
                }
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isAlphaNeumeric(char ch) {
        if ( (ch >= 65 && ch <=90) ||
                (ch >= 97 && ch <= 122) ||
                (ch >= 48 && ch <= 57)
        ) {
            return true;
        }

        return false;
    }
}
