package Solution;

import java.util.*;

/**
 * Created by zhangwei on 2017/9/14.
 *
 * 和1的不同是，实现Conparator接口
 * 重写comparef方法实现collection的自定义排序功能
 *
 * 用到了静态内部类
 *
 *
 */
public class Merge_Intervals_II {
    public static class Mycomparator implements Comparator<Interval>{
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
