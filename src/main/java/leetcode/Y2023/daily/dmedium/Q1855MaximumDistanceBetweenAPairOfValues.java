package leetcode.Y2023.daily.dmedium;

public class Q1855MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int m = nums1.length, n = nums2.length;
       for (int i = 0; i < m; i++) {
           int j = i;
           while (j < n && nums1[i] <= nums2[j]) j++;
           maxDistance = Math.max(maxDistance, j - i - 1);
         }
        return maxDistance;

    }
}
