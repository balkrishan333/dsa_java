package leetcode;

public class _405_ConvertANumberToHexadecimal {

    public static void main(String[] args) {
        _405_ConvertANumberToHexadecimal obj = new _405_ConvertANumberToHexadecimal();

        int num = 26;
        System.out.println(obj.toHex(num));
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            //we can also use sb.append but in that case we have to reverse the builder at the end
            sb.insert(0, hex[num & 15]); //bitwise AND with 15 (1111) to get the last 4 bits. Bitwise and will return
            // number represented by last 4 bits unchanged.
            num = num >>> 4; //right shift by 4 bits to get the next 4 bits
        }
        return sb.toString();
    }
}
