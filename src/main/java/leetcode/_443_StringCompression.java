package leetcode;

public class _443_StringCompression {

    public static void main(String[] args) {
        _443_StringCompression obj = new _443_StringCompression();

        char[] chars = {'a','a','b','b','c','c','c'};
//        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(obj.compress(chars));
        System.out.println(chars);
    }

    public int compress(char[] chars) {
        int count = 1;

        int index = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                chars[index++] = chars[i-1];

                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1;
            } else {
                count++;
            }
        }
        chars[index++] = chars[chars.length-1];
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[index++] = c;
            }
        }

        //can't return chars.length, as we are doing in place replacement of elements and actual length of chars will
        //be more than compressed string. So return the index which is used to copy new chars in array.
        return index;
    }
}
