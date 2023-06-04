package leetcode.Y2023.book.educative.a5PatternMergeIntervals;

import java.util.*;

public class Q2MergeIntervals {
    class Interval{
        int start,end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    List<Interval> merge(List<Interval> intervalsList){
        if(intervalsList.size()<2) return intervalsList;

        Collections.sort(intervalsList,(a,b)->Integer.compare(a.start,b.start));

        List<Interval> mergedIntervals= new LinkedList<>();
        Iterator<Interval> intervalIterator = intervalsList.iterator();
        Interval interval=intervalIterator.next();
        int start= interval.start;
        int end= interval.end;

        while (intervalIterator.hasNext()){
             interval=intervalIterator.next();
             if(interval.start<=end){
                 end=Math.max(interval.end,end);
             }else {
                 mergedIntervals.add(new Interval(start,end));
                 start= interval.start;
                 end= interval.end;
             }
        }
        mergedIntervals.add(new Interval(start,end));

        return mergedIntervals;
    }

}
