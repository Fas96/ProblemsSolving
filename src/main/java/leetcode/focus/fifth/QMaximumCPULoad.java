package leetcode.focus.fifth;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class QMaximumCPULoad {
    class Job{
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }
    public int findMaxCPULoad(List<Job> jobs){
        Collections.sort(jobs,(a,b)->Integer.compare(a.start,b.start));
        int maxCPULoad=0;
        int currentCPULoad=0;
        PriorityQueue<Job> minHeap= new PriorityQueue<>(jobs.size(),(a,b)->Integer.compare(a.end,b.end));

        for (Job job: jobs) {
            //remove all jobs that have ended
            while (!minHeap.isEmpty() && job.start>minHeap.peek().end) currentCPULoad -= minHeap.peek().cpuLoad;

            //add current job to the minHeadp
            minHeap.offer(job);
            currentCPULoad+= job.cpuLoad;
            maxCPULoad=Math.max(maxCPULoad,currentCPULoad);
        }
        return maxCPULoad;
     }
}
