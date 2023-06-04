package leetcode.Y2023.daily.deasy;

import java.util.*;
import java.util.stream.Collectors;

public class Q2215FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> nums2List = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

            List<Integer> nums1NotInNums2 = nums1List.stream().filter(num -> !nums2List.contains(num)).collect(Collectors.toList());
            List<Integer> nums2NotInNums1 = nums2List.stream().filter(num -> !nums1List.contains(num)).collect(Collectors.toList());

            List<List<Integer>> ans = new ArrayList<>();
            ans.add(nums1NotInNums2);
            ans.add(nums2NotInNums1);

            return ans;




    }
}
