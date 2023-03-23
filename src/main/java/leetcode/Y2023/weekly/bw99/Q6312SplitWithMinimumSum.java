package leetcode.Y2023.weekly.bw99;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q6312SplitWithMinimumSum {

        /*Given a positive integer num, split it into two non-negative integers num1 and num2 such that:

The concatenation of num1 and num2 is a permutation of num.
In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
num1 and num2 can contain leading zeros.
Return the minimum possible sum of num1 and num2.*/


    @Test
    public void test_splitNum(){
       assertEquals(59,splitNum(687));
    }

    private int splitNum(int num) {

        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        int[] counts = new int[10];
        for (int digit : digits) {
            counts[digit]++;
        }

        int num1 = 0, num2 = 0;
        boolean useNum1 = true;
        for (int digit = 0; digit < 10; digit++) {
            while (counts[digit] > 0) {
                if (useNum1) {
                    num1 = num1 * 10 + digit;
                } else {
                    num2 = num2 * 10 + digit;
                }
                counts[digit]--;
                useNum1 = !useNum1;
            }
        }
        return num1 + num2;
    }

}
