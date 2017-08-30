package Solution;

/**
 * Created by zhangwei on 2017/8/30.
 * 维护两个变量
 * 一个局部变量local_max判定局部最大
 * 一个全局变量globle_max判定全局最大
 * 从前往后遍历一遍O(n)
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int local_max = nums[0];
        int globle_max = nums[0];
        for (int i = 1;i<nums.length;i++){
            local_max=Math.max(nums[i],local_max+nums[i]);
            globle_max=Math.max(local_max,globle_max);
        }
        return globle_max;
    }
}
