package leetcode.Y2023.weekly.w338;

import com.github.shanepark.Ps;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q6357MinimumOperationsToMakeAllArrayElementsEqual {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> result= new LinkedList<>();
        int n=nums.length;
        for (int num:queries){
            int[] array = new int[n];
            Arrays.fill(array, num);
            result.add(helper(nums, array));
        }
        return result;
    }


    public  long helper(int[] nums1, int[] nums2) {
        long sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        return sum;
    }
    @Test
    public void testMinOperation(){


        assertEquals(List.of(14L,10L),minOperations(new int[]{3,1,6,8}, new int[]{1,5}));
    }
}
