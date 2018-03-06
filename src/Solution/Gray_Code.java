package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2018/3/6.
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


 */
public class Gray_Code {
    public List<Integer> grayCode(int n) {
        if(n==0){
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        List<Integer> res = grayCode(n-1);
        int addNum = 1 << (n-1);
        int original_size=res.size();
        for (int i = original_size-1; i >=0 ; i--) {
            res.add(addNum+res.get(i));
        }
        return res;
    }
}
