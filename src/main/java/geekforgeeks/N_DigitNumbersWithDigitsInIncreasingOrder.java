package geekforgeeks;

import java.util.ArrayList;
import java.util.List;

public class N_DigitNumbersWithDigitsInIncreasingOrder {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(increasingNumbers(n));
    }

    private static final ArrayList<Integer> result = new ArrayList<>();
    public static ArrayList<Integer> increasingNumbers(int n) {
        if (n == 1) {
            return new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9));
        }
        List<Integer> digits = new ArrayList<>();
        findNumbers(digits, n);
        return result;
    }

    private static void findNumbers(List<Integer> digits, int n) {
        if (n == 0) {
            int pow = 0;
            int number = 0;
            for (int i = digits.size()-1; i >=0 ; i--,pow++) {
                number += digits.get(i) * (int)Math.pow(10, pow);
            }
            result.add(number);
        }

        for (int i = 1; i <= 9; i++) {
            if (digits.isEmpty() || i > digits.getLast()) {
                digits.add(i);
                findNumbers(digits, n-1);
                digits.remove(digits.getLast());
            }
        }
    }
}
