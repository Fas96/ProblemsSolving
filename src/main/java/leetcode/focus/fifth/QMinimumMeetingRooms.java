package leetcode.focus.fifth;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class QMinimumMeetingRooms {
    class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int findMinimumMeetingRooms(List<Meeting> meetings){
        if(meetings==null ||meetings.size()==0) return 0;

        Collections.sort(meetings,(m1,m2)->Integer.compare(m1.start,m2.start));

        int minRooms=0;
        PriorityQueue<Meeting> minHeap=new PriorityQueue<>(meetings.size(),(m1,m2)->Integer.compare(m1.end,m2.end));

        for (Meeting meeting : meetings) {
            //remove all meetings that have ended
            while (!meetings.isEmpty() && meeting.start>=minHeap.peek().end) minHeap.poll();

            //add current meeting to the minHeap
            minHeap.offer(meeting);
            minRooms=Math.max(minRooms,minHeap.size());
        }
        return minRooms;

    }
}
