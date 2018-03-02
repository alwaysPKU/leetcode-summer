package Solution;

import java.util.Stack;

/**
 * Created by zhangwei on 2018/3/2.
 */
public class Largest_Rectangle_in_Histogram {
    // time limit
    public int largestRectangleArea_timelimited(int[] heights) {
        int result=0;
        int max;
        int step = 1;
        int len = heights.length;
        if (len == 0) return 0;
        max = heights[0];
        for (int i = 0; i < len; i++) {
            if (max<heights[i]) max = heights[i];
            }
        while (step<=max){
            int tmp = 0;
            for (int i = 0; i < len; i++) {
                if (heights[i]>=step){
                    tmp += step;
                    if(result<tmp) result=tmp;
                }else {
                    if (result<tmp){
                        result = tmp;
                        tmp = 0;
                    }else {
                        tmp = 0;
                    }
                }
            }
            ++step;
        }
        return result;
    }
    //如果高度一致都是递增的就一直压入栈，一旦遇到一个高度减小的，
    // 就计算栈里面能够组成的最大四边形面积（一个个出栈分别计算四边形面积）
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int max = 0;
        int i = 0;
        int tmp = 0;
        int tmpTop = 0;
        while (i<=n){
            tmp =(i==n?0:heights[i]); //最后的右边相当于0
            if (stack.isEmpty()||heights[stack.peek()]<=tmp){
                stack.push(i);
                i++;
            }else {
                tmpTop=heights[stack.pop()];
                max=Math.max(max,tmpTop*(stack.isEmpty()?i:i-1-stack.peek()));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Largest_Rectangle_in_Histogram test = new Largest_Rectangle_in_Histogram();
        int[]eg ={2,1,5,6,2,3};
        int res = test.largestRectangleArea(eg);
        System.out.print(res);
    }
}
