package leetcode.Y2023.book.educative.a3TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QQuadrupleSumToTarget {
    public List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                searchPairs(arr, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> list) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            long curSum = arr[first] + arr[second] + arr[left] + arr[right];
            if (curSum == targetSum) {
                list.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (curSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}
