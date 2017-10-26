package Solution;

/**
 * Created by zhangwei on 2017/10/24.
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.


 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.



 ==========================================================================
 Could you come up with an one-pass algorithm using only constant space?
 ==========================================================================
 */
public class Sort_colors {
    public void sortColors(int[] nums) {
        if (nums==null||nums.length==0||nums.length==1) return;
        int low = 0;
        int high = nums.length-1;
        int zero = 0;
        int two = 0;
        while (low<=high){
            if (nums[low]==0) {
                swap(nums,low,zero);
                low++;
                zero++;
                continue;
            }
            if (nums[high]==2){
                swap(nums,high,nums.length-1-two);
                high--;
                two++;
                continue;
            }
            if (nums[high]==0){
                swap(nums,high,low);
                continue;
            }
            if (nums[low]==2){
                swap(nums,low,high);
                continue;
            }
            low++;
            high--;

        }
    }
    public void swap(int[]nums,int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
//        nums[a] = nums[a]^nums[b];
//        nums[b] = nums[a]^nums[b];
//        nums[a] = nums[a]^nums[b];
    }
}
