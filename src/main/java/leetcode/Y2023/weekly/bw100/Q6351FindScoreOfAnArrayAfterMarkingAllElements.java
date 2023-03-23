package leetcode.Y2023.weekly.bw100;

import java.util.*;

public class Q6351FindScoreOfAnArrayAfterMarkingAllElements {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0; i<n; i++) pq.add(new int[]{nums[i],i});
        int[] v = new int[n];

        long ans = 0;

        while(pq.size()>0){
            int[] p = pq.poll();
            if(v[p[1]]==1) continue;
            ans += p[0];
            v[p[1]]=1;
            if(p[1]>0) v[p[1]-1]=1;
            if(p[1]<n-1) v[p[1]+1]=1;
        }

        return ans;

    }
}
