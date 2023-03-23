package leetcode.Y2023.weekly.w336;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q6317CountTheNumberOfBeautifulSubarrays {
    public long beautifulSubarrays(int[] nums) {
         long ans = 0;
        Map<Integer, Integer> t = new HashMap<>();
        t.put(0, 1);

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
            if (t.containsKey(x)) {
                ans += t.get(x);
            }
            t.put(x, t.getOrDefault(x, 0) + 1);
        }


        return ans;
    }





    @Test
    public void beautifulSubarraysTest(){
        assertEquals(2,beautifulSubarrays(new int[]{4,3,1,2,4}));
        assertEquals(0,beautifulSubarrays(new int[]{1,10,4}));
    }
}
