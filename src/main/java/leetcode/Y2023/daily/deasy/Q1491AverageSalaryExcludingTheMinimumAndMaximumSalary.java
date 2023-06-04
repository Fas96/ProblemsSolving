package leetcode.Y2023.daily.deasy;

public class Q1491AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i : salary) {
            min=Math.min(min,i);
            max=Math.max(max,i);
            sum+=i;
        }
        return (sum-min-max)/(double)(salary.length-2);

    }
}
