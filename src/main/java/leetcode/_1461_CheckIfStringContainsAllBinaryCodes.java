package leetcode;

public class _1461_CheckIfStringContainsAllBinaryCodes {

    public static void main(String[] args) {
        _1461_CheckIfStringContainsAllBinaryCodes obj = new _1461_CheckIfStringContainsAllBinaryCodes();

        String s = "00110";
        int k =2;
        System.out.println(obj.hasAllCodes(s, k));
    }

    public boolean hasAllCodes(String s, int k) {
        int n = s.length();

        // Impossible cases
        if (k > n) return false;

        int totalNeeded = 1 << k;  // 2^k

        // If total substrings < total combinations, impossible
        if (n - k + 1 < totalNeeded) return false;

        boolean[] seen = new boolean[totalNeeded];
        int mask = totalNeeded - 1;  // keeps last k bits. mask is all 1's and is the max value from k bits
        int currentValue = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Shift left and add new bit
            currentValue = ((currentValue << 1) & mask)
                    | (s.charAt(i) - '0');

            // Start counting only after first k-1 chars
            if (i >= k - 1) {
                if (!seen[currentValue]) {
                    seen[currentValue] = true;
                    count++;

                    if (count == totalNeeded) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
