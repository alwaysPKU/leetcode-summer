package Solution;

/**
 * Created by zhangwei on 2017/8/13.
 */
public class First_Missing_Positive {
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.print(firstMissingPositive(nums));

    }
    public static int firstMissingPositive(int[] nums) {
//        if (nums==null||nums.length==0||(nums.length==1&&nums[0]<=0)) return 1;
//        if (nums.length==1&&nums[0]>0) return nums[0]+1;
        if (nums.length>=1) {
            int i = 0;
            while (i<nums.length){
                if (nums[i] - 1 != i&&nums[i]<nums.length&&nums[i]>0&&nums[i]!=nums[nums[i]-1]) swap(nums, i, nums[i] - 1);
                else i++;
            }
            for (int k = 0; k < nums.length ; k++) {
                if (nums[k] - 1 != k) return k + 1;
            }
            return nums[nums.length-1]+1;
        }
        if (nums.length==0||nums==null) return 1;
        return 1;

    }
    public static void swap(int[] nums,int one ,int two){
        int tmp = nums[one];
        nums[one]=nums[two];
        nums[two]=tmp;
    }
}
