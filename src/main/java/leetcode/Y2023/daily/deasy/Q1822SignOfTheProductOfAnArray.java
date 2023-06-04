package leetcode.Y2023.daily.deasy;

import java.math.BigInteger;

public class Q1822SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int countNeg = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            else if (num < 0) countNeg=-countNeg;
        }
          return countNeg;
    }
}
