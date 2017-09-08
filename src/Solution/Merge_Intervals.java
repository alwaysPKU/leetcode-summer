package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangwei on 2017/9/7.
 *
 * 合并重复区间
 * 1.排序
 * 2.从前往后合并，并mark被合并的区间，不要重复遍历
 */
public class Merge_Intervals {
    public static void main(String[] args) {
        Interval s1 = new Interval(2,3);
        Interval s2 = new Interval(4,5);
        Interval s3 = new Interval(6,7);
        Interval s4 = new Interval(8,9);
        Interval s5 = new Interval(1,10);
        List<Interval> a = new ArrayList<>();
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        a.add(s5);
        List<Interval> res = merge(a);
    }
    public static List<Interval> merge(List<Interval> intervals) {
        //排个序
        quick_Sort_Interval(intervals,0,intervals.size()-1);
        List<Interval> res = new ArrayList<>();
        Set<Integer> mark = new HashSet<>();
        for (int i = 0;i<intervals.size();i++){
            if (mark.contains(i)) continue;
            if (i==intervals.size()-1){
                res.add(intervals.get(i));
                break;
            }
            for (int j = i+1;j<intervals.size();j++){
                if (isoverlapping(intervals.get(i),intervals.get(j))){
                    mark.add(j);
                    intervals.set(i,mergeTwo(intervals.get(i),intervals.get(j)));
                }else break;
            }
            res.add(intervals.get(i));
        }
        return res;
    }
    private static Interval mergeTwo(Interval i1,Interval i2){
        Interval res = null;
        if (i1.start>i2.start){
            Interval tmp = i1;
            i1=i2;
            i2=tmp;
        }
        if (i1.end>=i2.end) return i1;
        if(i1.end>=i2.start&&i1.end<i2.end){
           return res = new Interval(i1.start,i2.end);
        }
        return res;
    }
    private static boolean isoverlapping(Interval i1,Interval i2){
        if (i1.start>i2.start){
            Interval tmp = i1;
            i1=i2;
            i2=tmp;
        }
        if (i2.start>i1.end) return false;
        else return true;
    }
    public static void quick_Sort_Interval(List<Interval> intervals,int low, int high){
        if (low<high){
            int pivot = partition(intervals,low,high);
            quick_Sort_Interval(intervals,low,pivot-1);
            quick_Sort_Interval(intervals,pivot+1,high);
        }
    }
    private static int partition(List<Interval> intervals,int low,int high){
        Interval pivot = intervals.get(low);
        while (low<high){
            while (low<high&&intervals.get(high).start>=pivot.start) high--;
            intervals.set(low,intervals.get(high));
            while (low<high&&intervals.get(low).start<=pivot.start) low++;
            intervals.set(high,intervals.get(low));
        }
        intervals.set(low,pivot);
        return low;
    }
}
