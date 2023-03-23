package leetcode.Y2023.weekly.bw100;

import java.util.Arrays;
import java.util.Collections;

public class Q6324MaximizeGreatnessOfAnArray {
    public int maximizeGreatness(int[] nums) {
        int[] freq = new int[100001];
        for (int num : nums) {
            freq[num]++;
        }
        int greater = nums.length;
        int greatness = 0;
        for (int i = 100000; i >= 0; i--) {
            greater -= freq[i];
            if (greater <= 0) {
                break;
            }
            greatness += freq[i];
        }
        return greatness;

    }
}
