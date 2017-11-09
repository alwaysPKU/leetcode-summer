package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/10/25.
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> arry = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            arry.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        helper(result,item,arry,k,0);
        return result;

    }
    private static void helper(List<List<Integer>> result, List<Integer> item, List<Integer> arry,int k,int start){
        if (item.size()==k){
            result.add(new ArrayList<>(item));
            return;
        }else {
            for (int i = start; i <arry.size() ; i++) {
                item.add(arry.get(i));
                helper(result,item,arry,k,i+1);
                item.remove(item.size()-1);
            }
        }

    }

    public static void main(String[] args) {

        List<List<Integer>> re= combine(4,2);
        for (int i = 0; i <re.size() ; i++) {
            for (int j = 0; j <re.get(i).size() ; j++) {
                System.out.print(re.get(i).get(j)+" ");
            }
            System.out.print("\n");
        }
    }

}
