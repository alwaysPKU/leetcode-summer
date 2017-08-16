package Solution;

/**
 * Created by zhangwei on 2017/8/1.
 */
public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {

    }
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if (left==right&&target==nums[left]) return left;
        while (left<right){
            if (nums[left]<target){
                left++;
            }
            if (nums[left]==target){
                return left;
            }
            if (nums[left]>target){
                if (nums[right]>target){
                    right--;
                }
                if (nums[right]==target){
                    return right;
                }else if (nums[right]<target){
                    return -1;
                }
            }
        }
        return -1;
    }
}
