package Solution;

import java.util.Arrays;

/**
 * Created by zhangwei on 2017/7/21.
 */
public class ThreeSum_Closest {
    public static void main(String[] args) {
        int[] a = {-3, -2, -5, 3, -4};
        int res = threeSumClosest(a, -1);
        System.out.println(res);

    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low =i+1;
            int high = nums.length-1;
            while (low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if (Math.abs(sum-target)<min){
                    min = Math.abs(sum-target);
                    result = sum;
                }
                if (target==result)return result;
                else if (target>sum) low++;
                if (target<sum) high--;
            }
        }
        return result;

    }
}