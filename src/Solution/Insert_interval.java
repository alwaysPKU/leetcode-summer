package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhangwei on 2017/9/14.
 */
public class Insert_interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }
    public static class Mycomparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a ,Interval b){
            return a.start-b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals.size() == 0) return ans;

        Collections.sort(intervals, new Mycomparator());

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 0; i < intervals.size(); i++) {
            Interval inter = intervals.get(i);
            if (inter.start > end) {
                ans.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            } else {
                end = Math.max(end, inter.end);
            }
        }
        ans.add(new Interval(start, end));

        return ans;
    }
}
