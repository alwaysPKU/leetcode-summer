package Solution;

/**
 * Created by zhangwei on 2017/11/7.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Write a function to determine if a given target is in the array.

 The array may contain duplicates.
 */
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start<=end){
            int mid = (start+end)/2;

            if (target<nums[mid]){
                if (nums[mid]<nums[end]) end=mid-1;//右边有序，在左边
                else if (nums[mid]==nums[end]) end--;
                else {//左边有序
                    if (target<nums[start]) start=mid+1;
                    else end=mid-1;
                }

            }else if (target>nums[mid]){
                if (nums[start]<nums[mid]) start=mid+1;//左边有序，在右边
                else if (nums[start]==nums[mid]) start++;
                else {//右边有序
                    if (target>nums[end]) end=mid-1;
                    else start=mid+1;
                }
            }else return true;
        }
        return false;
    }

}
