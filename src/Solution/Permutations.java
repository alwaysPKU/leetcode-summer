package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/25.
 *
 */
public class Permutations {
    public static void main(String[] args) {

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (nums.length==0||nums==null) return result;

        boolean[] mark = new boolean[nums.length];
        permutations_helper(nums,result,item,mark);
        return result;

    }
    public static void permutations_helper(int[] nums,List<List<Integer>> result,List<Integer> item,boolean[] mark){
        if (item.size()==nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if (!mark[i]){
                item.add(nums[i]);
                mark[i]=true;
                permutations_helper(nums,result,item,mark);
                item.remove(item.size()-1);
                mark[i]=false;
            }
        }

    }
}
