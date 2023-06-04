package leetcode.Y2023.book.educative.a5PatternMergeIntervals;

import java.util.Arrays;

public class QConflictingAppointments {
    class Interval{
        int start,end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public boolean canAttendAllAppointments(Interval[] intervals){
        Arrays.sort(intervals,(a, b)->Integer.compare(a.start,b.start));
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<intervals[i-1].end){
                return false;
            }
        }
        return true;
    }
}
