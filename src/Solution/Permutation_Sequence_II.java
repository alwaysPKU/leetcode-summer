package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/9/23.
 * 所以我还是得直接找到第K个序列
 * 是的，上个算法很酷但没用😝
 *
 * 我们可以发现，每一位上1,2,3,4分别都出现了6次，当第一位上的数字确定了，
 * 后面三位上每个数字都出现了2次，当第二位也确定了，后面的数字都只出现了1次，
 * 当第三位确定了，那么第四位上的数字也只能出现一次，那么下面我们来看k = 17这种情况的每位数字如何确定，
 * 由于k = 17是转化为数组下标为16：

 * 最高位可取1,2,3,4中的一个，每个数字出现3！= 6次，所以k = 16的第一位数字的下标为16 / 6 = 2，即3被取出
 * 第二位此时从1,2,4中取一个，k = 16是此时的k' = 16 % (3!) = 4，而剩下的每个数字出现2！= 2次，
 * 所以第二数字的下标为4 / 2 = 2，即4被取出
 * 第三位此时从1,2中去一个，k' = 4是此时的k'' = 4 % (2!) = 0，而剩下的每个数字出现1！= 1次，
 * 所以第三个数字的下标为 0 / 1 = 0，即1被取出
 * 第四位是从2中取一个，k'' = 0是此时的k''' = 0 % (1!) = 0，而剩下的每个数字出现0！= 1次，
 * 所以第四个数字的下标为0 / 1= 0，即2被取出

 那么我们就可以找出规律了
 a1 = k / (n - 1)!
 k1 = k

 a2 = k1 / (n - 2)!
 k2 = k1 % (n - 2)!
 ...

 an-1 = kn-2 / 1!
 kn-1 = kn-2 / 1!

 an = kn-1 / 0!
 kn = kn-1 % 0!
 */
public class Permutation_Sequence_II {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> numList = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (int i =1;i<=n;i++){
            numList.add(i);
        }
        int num_permutation = 1;
        for (int i=2;i<n;i++){
            num_permutation*=i;
        }
        int mark = n-1;
        while (mark>=0){
            int indexInlist = k/num_permutation;
            result.append(numList.get(indexInlist));
            numList.remove(indexInlist);

            k=k%num_permutation;
            if (mark!=0){
                num_permutation=num_permutation/mark;
            }
            --mark;
        }
        return result.toString();

    }
}
