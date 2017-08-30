package Solution;

/**
 * Created by zhangwei on 2017/8/30.
 * 维护两个局部变量，一个最大，一个最小
 * 维护一个全局变量
 * 动态规划
 * O(n)
 * 类似Maximun_Subarry
 *
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int local_max = nums[0];
        int local_min = nums[0];
        int global = nums[0];
        for (int i =1;i<nums.length;i++){
            int item_max = local_max;
            local_max = Math.max(local_min*nums[i],Math.max(local_max*nums[i],nums[i]));
            local_min = Math.min(Math.min(local_min*nums[i],nums[i]),item_max*nums[i]);
            global = Math.max(local_max,global);

        }
        return global;
    }
}
