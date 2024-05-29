package leetcode;

public class _1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne {

    public static void main(String[] args) {
        _1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne obj =
                new _1404_NumberOfStepsToReduceANumberInBinaryRepresentationToOne();

        String s = "1101";
        System.out.println(obj.numSteps(s));
    }

    public int numSteps(String s) {

        int carry = 0;
        int stepCount = 0;
        for (int i = s.length()-1; i > 0 ; i--) {
            int value = Character.getNumericValue(s.charAt(i)) + carry;

            if (value % 2 == 0) {
                stepCount++;
            } else {
                stepCount += 2;
                carry = 1;
            }
        }
        return stepCount + carry;
    }
}
