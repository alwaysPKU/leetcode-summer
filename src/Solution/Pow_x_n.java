package Solution;

/**
 * Created by zhangwei on 2017/9/4.
 *
 * Implement pow(x, n).
 *
 * 求x的n次方
 *
 * 顾名思义，快速幂就是快速算底数的n次幂。
 * 其时间复杂度为 O(log₂N)， 与朴素的O(N)相比效率有了极大的提高。
 */
public class Pow_x_n {
    public double myPow(double x, int n) {
        return Math.pow(x, (double) n);
    }
}
