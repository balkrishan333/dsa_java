package leetcode;

public class _1925_CountSquareSumTriples {

    public static void main(String[] args) {
        _1925_CountSquareSumTriples obj =
                new _1925_CountSquareSumTriples();

        int n = 5;
        System.out.println(obj.countTriples(n));
    }

    public int countTriples(int n) {
        int result = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b < n; b++) {
                int c = (int)Math.sqrt(a*a + b*b);
                if (c <= n && c*c == a*a + b*b) {
                    result++;
                }
            }
        }
        return result;
    }
}
