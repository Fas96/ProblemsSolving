package leetcode.Y2023.personal.prefix;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int res=0;
        Map<Integer, Integer> sumPrefixMap = new HashMap<>();
        sumPrefixMap.put(0, 1);

        for (int i = 1; i <=n; i++) {
            if (sumPrefixMap.containsKey(prefix[i] - k)) {
                res += sumPrefixMap.get(prefix[i] - k);
            }
            sumPrefixMap.merge(prefix[i], 1, Integer::sum);
        }
        return res;
    }
    @Test
    public void testsubarraySum() {
        int[] nums = {1,1,1};
        int k = 2;
        int res = subarraySum(nums, k);
        assertEquals(2, res);
        nums = new int[]{1,2,3};
        k = 3;
        res = subarraySum(nums, k);
        assertEquals(2, res);
    }
}
