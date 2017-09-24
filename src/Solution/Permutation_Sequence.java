package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/9/23.
 * 可以通过规律直接找第k个序列å
 * 但是本算法通过罗列所有的可能，直到第K个把它输出
 * 所以会Time Limit Exceeded
 */
public class Permutation_Sequence {
    public String getPermutation(int n, int k) {
        int[] array = new int[n];
        for (int i =1;i<=n;i++){
            array[i-1]=i;
        }
        boolean mark[] = new boolean[n];
        //StringBuffer str = new StringBuffer();
        List<StringBuffer> result = new ArrayList<>();
        StringBuffer item = new StringBuffer();
        helper(array,result,item,mark);
        return String.valueOf(result.get(k-1));
    }
    public static void helper(int[] array,List<StringBuffer> result,StringBuffer item,boolean[] mark){
        if (item.length()==array.length){
            result.add(new StringBuffer(item));
            return;
        }
        for (int i =0;i<array.length;i++){
            if (!mark[i]){
                item.append(array[i]);
                mark[i]=true;
                helper(array,result,item,mark);
                mark[i]=false;
                item.delete(item.length()-1,item.length());
            }
        }
    }

}
