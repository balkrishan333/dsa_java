package leetcode;

public class _1716_CalculateMoneyInLeetcodeBank {

    public static void main(String[] args) {
        _1716_CalculateMoneyInLeetcodeBank obj = new _1716_CalculateMoneyInLeetcodeBank();

        int n = 10;
        System.out.println(obj.totalMoney(n));
    }

    /*
        First week = 28, 2nd week = 35, 3rd week = 42, it forms an arithmetic sequence
        Sum of arithmetic sequence = length_of_seq * (first_elementIn_seq + last_ele_in_seq) /2
     */
    public int totalMoney(int n) {
        int firstWeek = 28; //1+2+3+4+5+6+7
        int noOfWeeks = n/7;
        int lastWeek = firstWeek + 7*(noOfWeeks-1);  //every week increases by 7 to form arithmetic sequence

        int fullWeekMoney = noOfWeeks * (firstWeek + lastWeek)/2; // arithmetic sequence formula

        int noOfDays = n % 7;

        //for rest of the days
        int monday = noOfWeeks +1;
        int partialWeekMoney = 0;
        for (int day = 0; day < noOfDays; day++) {
            partialWeekMoney += monday + day;
        }

        return fullWeekMoney + partialWeekMoney;
    }
}
