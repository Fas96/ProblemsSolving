package leetcode.Y2023.weekly.w339;

import java.util.*;

public class Q6363ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> first = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            first.add(entry.getKey());
            freq.merge(entry.getKey(), -1, Integer::sum);
        }
        result.add(first);
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (freq.get(num) > 0) {
                row.add(num);
                freq.put(num, freq.get(num) - 1);
            }
            if (i == nums.length - 1 || freq.get(num) == 0) {
                result.add(row);
                row = new ArrayList<>();
            }
        }
        //remove emptylist form the result
        result.removeIf(List::isEmpty);
        return result;

    }
}
