package leetcode;

public class _944_DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
        _944_DeleteColumnsToMakeSorted obj = new _944_DeleteColumnsToMakeSorted();

        String[] strs = {"cba","daf","ghi"};
        System.out.println(obj.minDeletionSize(strs));
    }
    
    public int minDeletionSize(String[] strs) {
        if (strs.length == 0) {
            return 0;
        }

        //1. Concatenate all string to construct a bigger string
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        char[] chars = sb.toString().toCharArray();
        int size = strs[0].length();
        int answer = 0;

        //2. iterate to read from newly constructed string. need to read equal to length of a single original string
        for (int i = 0; i < size; i++) {
            char ch = chars[i]; // read from first string
            int strCount = 1;
            int j = i+size;  // next character should be read from next string, so jump over the size of original string

            while (strCount < strs.length) { // stop when read one character of each string
                if (ch > chars[j]) {
                    answer++;
                    break;
                }
                strCount++;
                ch = chars[j];
                j += size;
            }
        }
        return answer;
    }
}
