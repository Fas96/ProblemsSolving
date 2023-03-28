package leetcode.Y2023.weekly.w338;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q6354KItemsWithTheMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return Math.min(k, numOnes) - Math.max(0, k - numOnes - numZeros);
    }
    @Test
    public void testkItemsWithMaximumSum(){
        assertEquals(2,kItemsWithMaximumSum(3,2,0,2));
        assertEquals(3,kItemsWithMaximumSum(3,2,0,4));
    }
}
