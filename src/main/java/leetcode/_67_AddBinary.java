package leetcode;

public class _67_AddBinary {

    public static void main(String[] args) {
        _67_AddBinary obj = new _67_AddBinary();

        String a = "1";
        String b = "11110";
        System.out.println(obj.addBinary(a,b));
    }

    public String addBinary(String a, String b) {

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;

        for (; i >=0 || j >=0 ; i--, j--) {

            int sum = carry;
            if (i >= 0) {
                sum += Integer.parseInt(a, i, i+1, 10);
            }

            if (j >= 0) {
                sum += Integer.parseInt(b, j, j+1, 10);
            }

            if (sum < 2) {
                sb.append(sum);
                carry =  0;
            } else {
                sb.append(sum % 2);
                carry = 1;
            }
        }

        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /*
        Works. Accepted answer but too long
     */
    public String addBinary_v1(String a, String b) {
        if(a.length() != b.length()) {
            int diff = a.length()-b.length();

            StringBuilder sb = new StringBuilder();
            sb.append("0".repeat(Math.abs(diff)));

            if(diff < 0) {
                sb.append(a);
                a = sb.toString();
            } else {
                sb.append(b);
                b = sb.toString();
            }

        }

        String carry = "0";
        StringBuilder sb = new StringBuilder();
        for(int i = a.length()-1; i >=0; i--) {
            if(a.charAt(i) == '0' && b.charAt(i)== '0') {
                sb.append(carry);
                carry = "0";
            } else if((a.charAt(i) == '0' && b.charAt(i) == '1') ||
                    (a.charAt(i) == '1' && b.charAt(i) == '0') ) {
                if(carry.equals("0")) {
                    sb.append("1");
                } else {
                    carry = "1";
                    sb.append("0");
                }
            } else {
                if(carry.equals("0")) {
                    sb.append("0");
                    carry = "1";
                } else {
                    sb.append("1");
                    carry = "1";
                }
            }
        }
        System.out.println(sb);

        if(carry.equals("1")) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
