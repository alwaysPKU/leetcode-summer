package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/10/26.
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        helper(result,item,nums,0);
        result.add(new ArrayList<>());
        return result;

    }
    private void helper(List<List<Integer>> result ,List<Integer> item ,int[] nums, int start){
        for (int i = start; i <nums.length ; i++) {
            item.add(nums[i]);
            result.add(new ArrayList<>(item));
            helper(result,item,nums,i+1);
            item.remove(item.size()-1);
        }
    }
}
