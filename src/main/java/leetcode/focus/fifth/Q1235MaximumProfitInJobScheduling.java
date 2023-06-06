package leetcode.focus.fifth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q1235MaximumProfitInJobScheduling {
    class Job{
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<Job> jobs=new ArrayList<>();
        for (int i = 0; i < profit.length; i++) jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        Collections.sort(jobs,(a, b)->Integer.compare(a.start,b.start));
        // Arrays.sort(jobs, (a, b) -> a.end == b.end ? b.profit - a.profit : a.end - b.end);


        int maxProfit=0;
        int currentProfit=0;
        PriorityQueue<Job> minHeap= new PriorityQueue<>(jobs.size(),(a, b)->Integer.compare(a.end,b.end));

        for (Job job: jobs) {
            while (!minHeap.isEmpty() && job.start>minHeap.peek().end) currentProfit -= minHeap.peek().profit;
            minHeap.offer(job);
            currentProfit+= job.profit;
            maxProfit=Math.max(maxProfit,currentProfit);
        }
        return maxProfit;

    }
}
