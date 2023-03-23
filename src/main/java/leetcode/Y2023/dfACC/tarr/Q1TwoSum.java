package leetcode.Y2023.dfACC.tarr;

import java.util.HashMap;

public class Q1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> sm=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(sm.containsKey(target-nums[i])){
                return new int[]{sm.get(target-nums[i]),i};
            }
            sm.put(nums[i],i);
        }
        return new int[]{};

    }
}
