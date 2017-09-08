package Solution;

/**
 * Created by zhangwei on 2017/9/7.
 *
 * 区间
 * 定义一个数据结构
 * 供merge_intervals使用
 */
public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
