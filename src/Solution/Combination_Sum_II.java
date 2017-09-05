package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/13.
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates,target,0,0,tmp,result);
        return result;
    }
    public static void helper (int[] canditates, int target, int sum, int level, List<Integer>tmp, List<List<Integer>>result){
        if (sum == target){
            if (!result.contains(new ArrayList<>(tmp))) {
                result.add(new ArrayList<>(tmp));
            }
            return ;
        }else if(sum > target){
            return ;
        }else {

            for (int i = level;i<canditates.length;i++){
                tmp.add(canditates[i]);
                helper(canditates,target,sum+canditates[i],i+1,tmp,result);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
