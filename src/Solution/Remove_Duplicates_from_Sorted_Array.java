package Solution;

/**
 * Created by zhangwei on 2017/11/7.
 *
 * 80. Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.

 */
public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums.length<=2) return nums.length;
        int previous = 1;
        int current = 2;
        while (current<nums.length){
            if (nums[previous-1]==nums[current]&&nums[previous]==nums[current]){
                current++;
            }else {
                previous++;
                nums[previous]=nums[current];
                current++;
            }
        }
        return previous+1;
    }
}
