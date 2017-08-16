package Solution;

/**
 * Created by zhangwei on 2017/7/27.
 */
public class Next_Permutation {
    public static void main(String[] args) {

    }

    private static void nextPermutation(int[] nums) {
        for (int i = nums.length-2;i>=0;i--){
            if (nums[i]<nums[i+1]){
                for (int j = nums.length-1;j>i;j--){
                    if (nums[j]>nums[i]) {
                        swatch(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums,0,nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start<end){
            swatch(nums,start,end);
            start++;
            end--;
        }
//        int mid = (start + end) / 2;
//        if ((start + end) % 2 != 0) {
//            for (int i = start; i <= mid; i++) {
//                int tmp = nums[i];
//                nums[i] = nums[end - i];
//                nums[end - i] = tmp;
//            }
//        } else {
//            for (int i = start; i < mid; i++) {
//                int tmp = nums[i];
//                nums[i] = nums[end - i];
//                nums[end - i] = tmp;
//            }
//        }
//        return;
    }
    private static void swatch(int[] nums, int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
