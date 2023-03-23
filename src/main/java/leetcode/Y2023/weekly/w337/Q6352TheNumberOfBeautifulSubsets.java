package leetcode.Y2023.weekly.w337;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Q6352TheNumberOfBeautifulSubsets {


        int res;
        int k;

        public int beautifulSubsets(int[] nums, int k) {
            this.k = k;
            res = 0;
            dfs(0, nums, new HashMap<>());
            return res - 1;
        }

        private void dfs(int offset, int[] nums, Map<Integer, Integer> path) {
            if (offset == nums.length) {
                ++res;
                return;
            }
            dfs(offset + 1, nums, path);

            if (path.containsKey(nums[offset] + k) || path.containsKey(nums[offset] - k)) return;
            path.put(nums[offset], path.getOrDefault(nums[offset], 0) + 1);

            dfs(offset + 1, nums, path);

            path.put(nums[offset], path.get(nums[offset]) - 1);
            if (path.get(nums[offset]) == 0) path.remove(nums[offset]);
        }

    @Test
    public void test() {
       assertEquals(4, beautifulSubsets(new int[]{2,4,6}, 2));
       assertEquals(1, beautifulSubsets(new int[]{1}, 1));
       assertEquals(23, beautifulSubsets(new int[]{4,2,5,9,10,3}, 1));
    }
}
