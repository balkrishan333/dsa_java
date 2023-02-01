package leetcode;

public class _1071_GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        _1071_GreatestCommonDivisorOfStrings obj = new _1071_GreatestCommonDivisorOfStrings();

//        String str1 = "LEET";
//        String str2 = "CODE";
        String str1 = "ABCDABC";
        String str2 = "ABC";
//        String str1 = "ABABAB";
//        String str2 = "AB";

        System.out.println(obj.gcdOfStrings(str1, str2));
    }

    /*
       Use Euclidian algorithm to find the gcd and take the substring of size gcd
       https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm#:~:text=The%20Euclidean%20Algorithm%20for%20finding,%3D%20B%E2%8B%85Q%20%2B%20R)
     */
    public String gcdOfStrings(String str1, String str2) {

        //this is required to counter for strings which don't have any common divisor
        //  Strings have this property, s1+s2 = s2+s1. Ex: str1= ABCDABC, str2 = ABC
        if (!(str1+str2).equals(str2+str1)) {
            return "";
        }

        int val = gcd(str1.length(), str2.length());
        return str2.substring(0,val);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }
}
