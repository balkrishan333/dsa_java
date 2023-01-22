package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {

    private final List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        _93_RestoreIPAddresses obj = new _93_RestoreIPAddresses();

        String s = "0000";
        System.out.println(obj.restoreIpAddresses(s));
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return answer;
        }
        backTrack(s, 0, 0, "");
        return answer;
    }

    private void backTrack(String s, int index, int dots, String ip) {

        //if there are 4 dots, and we are at end of string, add to answer
        if (dots == 4 && index == s.length()) {
            answer.add(ip.substring(0,ip.length()-1)); //remove trailing .
            return;
        }

        if (dots > 4) {
            return;
        }

        //since of any part can't be more than 3 digits, so look only 3 characters ahead
        for (int i = 1; i <= 3; i++) {
            if (index+i <= s.length()) {
                String substring = s.substring(index, index + i);

                if (substring.trim().length() > 0) {

                    //any part can't start with 0 unless 0 is the only characters in the part
                    if (substring.length() > 1 && substring.charAt(0) == '0') {
                        continue;
                    }

                    //any part can't be greater than 255
                    if (Integer.parseInt(substring) <= 255) {
                        String newIP = ip + substring + "." ;
                        // index+i -->  skip the characters which are added in string
                        backTrack(s, index+i, dots+1, newIP);
                    }
                }
            }
        }
    }
}
