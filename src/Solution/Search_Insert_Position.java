package Solution;

/**
 * Created by zhangwei on 2017/8/1.
 */
public class Search_Insert_Position {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5};
        int re = searchInsert(a,4);
        System.out.print(re);
    }
    private static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            if (nums[left]<target) {
                if (left==nums.length-1) return ++left;
                else left++;
            }
            if (nums[left]==target) return left;
            if (nums[left]>target) return left;

            if (nums[right]>target) {
                if (right==0) return right;
                else  right--;
            }
            if (nums[right]==target) return right;
            if (nums[right]<target) return ++right;
        }
        return left;
    }
}
