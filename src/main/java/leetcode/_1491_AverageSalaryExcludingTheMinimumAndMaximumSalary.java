package leetcode;

public class _1491_AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public static void main(String[] args) {
        _1491_AverageSalaryExcludingTheMinimumAndMaximumSalary obj = new _1491_AverageSalaryExcludingTheMinimumAndMaximumSalary();

        int[] salary = {4000,3000,1000,2000};
        System.out.println(obj.average(salary));
    }

    public double average(int[] salary) {
        int count = salary.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        long sum = 0;
        for (int j : salary) {
            sum += j;
            if (j < min) {
                min = j;
            }

            if (j > max) {
                max = j;
            }
        }
        return (double) (sum - min - max)/(count-2);
    }
}
