package leetcode;

import java.util.Arrays;

public class _2678_NumberOfSeniorCitizens {

    public static void main(String[] args) {
        _2678_NumberOfSeniorCitizens obj = new _2678_NumberOfSeniorCitizens();

        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(obj.countSeniors(details));
    }

    public int countSeniors(String[] details) {
        int[] ages = new int[details.length];

        for (int i = 0; i < details.length; i++) {
            ages[i] = Integer.parseInt(details[i].substring(11,13));
        }
        return (int)Arrays.stream(ages).filter(age -> age > 60).count();
    }
}
