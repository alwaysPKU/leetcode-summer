package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2017/7/23.
 */
public class Four_sum {
    public static void main(String[] args) {
        int[] a= {1,-2,-5,-4,-3,3,3,5};

        for (int i =0;i<fourSum(a,-11).size();i++){
            System.out.print(fourSum(a,-11).get(i));
        }

    }
    public static  List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int key1 =0,key2=1;
        Arrays.sort(nums);

        for (key1=0;key1<nums.length-3;key1++){
            if (key1>0&&nums[key1-1]==nums[key1]) continue;
            for (key2=key1+1;key2<nums.length-2;key2++){
                if (key2>key1+1&&nums[key2-1]==nums[key2]) continue;
                int low=key2+1;
                int high = nums.length-1;

                while (low<high){

                    if (nums[key1]+nums[key2]+nums[low]+nums[high]<target) {
                        while (low++<high && nums[low-1]==nums[low]);
                    }

                    else if (nums[key1]+nums[key2]+nums[low]+nums[high]>target) {
                        while (high-->low&&nums[high]==nums[high+1]);
                    }
                    else {
                        Integer[] tmp = {nums[key1],nums[key2],nums[low],nums[high]};
                        result.add(Arrays.asList(tmp));
                        while (low++<high && nums[low]==nums[low-1]);
                        while (high-->low&&nums[high]==nums[high+1]);

                    }

                }
            }

        }

    return result;
    }
}
