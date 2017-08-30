package Solution;

import java.util.Arrays;

/**
 * Created by zhangwei on 2017/8/30.
 *
 * 这方法感觉像作弊..........
 *
 */
public class Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
}
