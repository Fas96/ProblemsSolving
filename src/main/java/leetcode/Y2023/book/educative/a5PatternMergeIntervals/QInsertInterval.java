package leetcode.Y2023.book.educative.a5PatternMergeIntervals;

import java.util.LinkedList;
import java.util.List;

public class QInsertInterval {
    class Interval{
        int start,end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        if(intervals==null||intervals.isEmpty()) return List.of(newInterval);
        if(newInterval==null) return intervals;
        List<Interval> mergedIntervals= new LinkedList<>();


        int i=0;
        while (i<intervals.size()&&intervals.get(i).end<newInterval.start){
            mergedIntervals.add(intervals.get(i++));
        }
        while (i<intervals.size()&&intervals.get(i).start<=newInterval.end){
            newInterval.start=Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end=Math.max(intervals.get(i).end,newInterval.end);
             i++;
        }
        mergedIntervals.add(newInterval);
        //add all the remaining intervals to the output
        while (i<intervals.size()){
            mergedIntervals.add(intervals.get(i++));
        }
        return intervals;
    }
}
