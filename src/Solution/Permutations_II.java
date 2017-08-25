package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/25.
 * 这个题跟Permutations非常类似，唯一的区别就是在这个题目中元素集合可以出现重复。
 * 这给我们带来一个问题就是如果不对重复元素加以区别，那么类似于{1,1,2}这样的例子我们会有重复结果出现。
 * 那么如何避免这种重复呢？方法就是对于重复的元素循环时跳过递归函数的调用，
 * 只对第一个未被使用的进行递归，我们那么这一次结果会出现在第一个的递归函数结果中，
 * 而后面重复的会被略过。如果第一个重复元素前面的元素还没在当前结果中，那么我们不需要进行递归。
 * 想明白了这一点，代码其实很好修改。首先我们要对元素集合排序，从而让重复元素相邻，
 * 接下来就是一行代码对于重复元素和前面元素使用情况的判断即可。
 */
public class Permutations_II {
    public static void main(String[] args) {

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (nums.length==0||nums==null) return result;
        Arrays.sort(nums);//把元素排序

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
            if (i>0&&!mark[i-1]&&nums[i]==nums[i-1]) continue;//跳过重复元素
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
