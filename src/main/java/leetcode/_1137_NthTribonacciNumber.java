package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1137_NthTribonacciNumber {

    private final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        _1137_NthTribonacciNumber obj = new _1137_NthTribonacciNumber();

        int n =25;
        System.out.println(obj.tribonacci(n));
    }

    public int tribonacci(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);

        return calculateTribonacci(n);
    }

    private int calculateTribonacci(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int calc = calculateTribonacci(n-3) + calculateTribonacci(n-2) + calculateTribonacci(n-1);
        map.put(n, calc);

        return calc;
    }
}
