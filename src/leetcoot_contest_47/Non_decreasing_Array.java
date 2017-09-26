package leetcoot_contest_47;

/**
 * Created by zhangwei on 2017/8/27.
 *
 * 只要修改一个数就能升序
 */
public class Non_decreasing_Array {
    public static void main(String[] args) {
        int[] num={4,2,3};
        int[] num1={-1,4,2,3};
        int[] num2={1,2,3,4,5,3,7};
        int[] num3={1,2,3,4,5,3,4,7};
        int[] num4={1,2,3,4,5,4};
        int[] num5={3,2,4,5};
        System.out.print(checkPossibility(num5));
    }
    public static boolean checkPossibility(int[] nums) {
        int mark =0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]<=nums[i+1]) continue;
            else {
                mark++;
                if (mark>=2) return false;
                if (i-1>=0&&nums[i-1]<=nums[i+1]){
                    continue;
                }
                if (i+2<=nums.length-1&&nums[i]<=nums[i+2]) {
                    i++;
                    continue;
                }
                if (i==0) continue;
                if (i==nums.length-2) continue;
                return false;
            }

        }
        return true;
    }


}
