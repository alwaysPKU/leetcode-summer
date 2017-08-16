package Solution;

/**
 * Created by zhangwei on 2017/8/1.
 */
public class Search_fo_a_Range {
    public static void main(String[] args) {
        int[] a = new int[]{2};
        int[] re = searchRange(a,1);
        System.out.print(re[0]);
        System.out.print(re[1]);


    }
    private static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] result =new int[]{-1,-1};

        while (left<=right){
            //int mid = (left+right)/2
            if (nums[left]<target){
                left++;
                if (left>=nums.length) break;
            }
            if (nums[left]==target){
                result[0]=left;
            }
            if (nums[right]>target){
                right--;
                if (right<=-1) break;
            }
            if (nums[right]==target){
                result[1]=right;
            }
            if (result[0]!=-1&&result[1]!=-1){
                return result;
            }

        }
        return new int[]{-1,-1};
    }
}
