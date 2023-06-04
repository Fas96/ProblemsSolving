package leetcode.Y2023.daily.dmedium;

import java.util.PriorityQueue;

public class Q2336SmallestNumberInInfiniteSet {

    class SmallestInfiniteSet {
        PriorityQueue<Integer> pq = null;

        public SmallestInfiniteSet() {
            pq=new PriorityQueue<>((a, b) -> a - b);
            for (int i = 0; i < 1_000; i++) {
                pq.offer(i+1);
                
            }
        }

        public int popSmallest() {
            return  pq.poll();
        }

        public void addBack(int num) {
            if(pq.contains(num))
                return;
            pq.add(num);
        }
    }

}
