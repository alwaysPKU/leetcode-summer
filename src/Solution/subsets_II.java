package Solution;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2018/3/8.
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:
 */
public class subsets_II {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            dfs(nums,0,i,tmp,res);
        }
        res.add(new ArrayList<>());
        return res;
    }
    public static void dfs(int[] nums,int start, int len, List<Integer> item, List<List<Integer>> res){
        if (item.size()==len){
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(nums, i+1,len,item,res);
            item.remove(item.size()-1);
            while (i<nums.length-1&&nums[i]==nums[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1,2,2};
        List<List<Integer>> tes = subsetsWithDup(test);
        System.out.print(tes);
    }
}
