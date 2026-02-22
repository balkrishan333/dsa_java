package leetcode;

public class _868_BinaryGap {

    public static void main(String[] args) {
        _868_BinaryGap obj = new _868_BinaryGap();

        int n = 22;
        System.out.println(obj.binaryGap(n));
    }

    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int ans = 0;
        int last = -1;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
        }
        return ans;
    }
}
