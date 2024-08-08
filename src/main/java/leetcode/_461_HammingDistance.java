package leetcode;

public class _461_HammingDistance {

    public static void main(String[] args) {
        _461_HammingDistance obj = new _461_HammingDistance();

        int x = 1, y = 4;
        System.out.println(obj.hammingDistance(x,y));
    }

    public int hammingDistance(int x, int y) {
        int xor = x^y;
        char[] chars = Integer.toBinaryString(xor).toCharArray();

        int distance = 0;
        for (char ch : chars) {
            if (ch == '1') {
                distance++;
            }
        }
        return distance;
    }
}
