package leetcode.Y2023.daily.deasy;

import java.util.PriorityQueue;

public class Q1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            if(a!=b){
                pq.add(a-b);
            }
        }
        return pq.isEmpty()?0:pq.poll();

    }
}
