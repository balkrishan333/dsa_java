package leetcode;

public class _1318_MinimumFlipsToMake_A_OR_B_EqualTo_C {

    public static void main(String[] args) {
        _1318_MinimumFlipsToMake_A_OR_B_EqualTo_C obj = new _1318_MinimumFlipsToMake_A_OR_B_EqualTo_C();

        int a = 2, b= 6, c=5;
        System.out.println(obj.minFlips(a,b,c));
    }

    public int minFlips(int a, int b, int c) {
        int d = a|b;
        String dBinary = Integer.toBinaryString(d);
        String cBinary = Integer.toBinaryString(c);

        if (dBinary.equals(cBinary)) {
            return 0;
        }

        int count = 0;
        String aBinary = Integer.toBinaryString(a);
        String bBinary = Integer.toBinaryString(b);

        dBinary = String.format("%32s", dBinary).replace(' ', '0');
        cBinary = String.format("%32s", cBinary).replace(' ', '0');
        aBinary = String.format("%32s", aBinary).replace(' ', '0');
        bBinary = String.format("%32s", bBinary).replace(' ', '0');

        for (int i = 0; i < aBinary.length(); i++) {
            if (dBinary.charAt(i) != cBinary.charAt(i)) {
                count++;
                if (cBinary.charAt(i) == '0' && aBinary.charAt(i) == '1' && bBinary.charAt(i) == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
