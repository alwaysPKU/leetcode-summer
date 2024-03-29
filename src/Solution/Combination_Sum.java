package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/12.
 */
public class Combination_Sum {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates,target,0,0,tmp,result);
        return result;
    }
    public static void helper (int[] canditates, int target, int sum, int level, List<Integer>tmp, List<List<Integer>>result){
        if (sum == target){
            result.add(new ArrayList<>(tmp));
            return ;
        }else if(sum > target){
            return ;
        }else {

            for (int i = level;i<canditates.length;i++){
                tmp.add(canditates[i]);
                helper(canditates,target,sum+canditates[i],i,tmp,result);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
