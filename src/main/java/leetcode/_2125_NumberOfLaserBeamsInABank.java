package leetcode;

public class _2125_NumberOfLaserBeamsInABank {

    public static void main(String[] args) {
        _2125_NumberOfLaserBeamsInABank obj = new _2125_NumberOfLaserBeamsInABank();

        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(obj.numberOfBeams(bank));
    }

    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int answer = 0;

        for (String s : bank) {
            int count = 0;
            char[] floor = s.toCharArray();
            for (char c : floor) {
                if (c == '1') {
                    count++;
                }
            }
            if (count > 0) {
                answer = answer + prev * count;
                prev = count;
            }
        }
        return answer;
    }
}
