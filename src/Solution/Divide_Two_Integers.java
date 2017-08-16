package Solution;

/**
 * Created by zhangwei on 2017/7/26.
 */
public class Divide_Two_Integers {
    public static void main(String[] args) {
        System.out.print(divide(-2147483648,1));
    }
    private static int divide(int dividend, int divisor) {
        if (divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;

        int sign = ((dividend<0)^(divisor<0))?-1:1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;
        while (dvd>=dvs){
            long tmp = dvs;
            long mul = 1;
            while (dvd>=(tmp<<1)){
                tmp = tmp<<1;
                mul<<=1;
            }
            dvd-=tmp;
            result+=mul;
        }
        return result*sign;
    }
}
