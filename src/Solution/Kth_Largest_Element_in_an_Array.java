package Solution;

/**
 * Created by zhangwei on 2017/8/26.
 *
 * 直接排序是nlogn
 * 所以不是最好的
 *
 * 可以借鉴quicksort的partition
 * 时间复杂度n
 *
 */
public class Kth_Largest_Element_in_an_Array {


    public int findKthLargest(int[] nums, int k) {
        return findK(nums,nums.length-k,0,nums.length-1);
    }
    private int findK(int[] nums,int k,int i,int j){
        if (i>j) return nums[i];
        int position = partition(nums,i,j);
        if (position==k) return nums[position];
        else if (position<k)return findK(nums,k,position+1,j);
        else return findK(nums,k,i,position-1);

    }
    private int partition(int[] nums,int i,int j){
        int pivot = nums[i];
        while (i<j){
            while (nums[j]>=pivot&&i<j) j--;
            nums[i]=nums[j];
            while (nums[i]<=pivot&&i<j) i++;
            nums[j]=nums[i];
        }
        nums[i]=pivot;
        return i;
    }
    private void swap(int[] nums,int i,int j){
        //很骚的位操作
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
    }
}
