package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/9/25.
 * Given a non-negative integer represented as
 * a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain
 any leading zero, except the number 0 itself.

 The digits are stored such that the most significant
 digit is at the head of the list.
 *
 */
public class Plus_One {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        for (int i =digits.length-1;i>=0;i--){
            res.add(digits[i]);
        }
        int i =0;
        if (res.get(i)<9){
            res.set(i,res.get(i)+1);
        }else if(res.get(i)==9) {
            while (i<=digits.length-1&&res.get(i)==9){//两个判定条件不能反
                res.set(i,0);
                i++;
            }
            if (i>res.size()-1){
                res.add(1);
            }else {
                res.set(i,res.get(i)+1);
            }
        }
        int[] result = new int[res.size()];
        for (int j=res.size()-1;j>=0;j--){
            result[res.size()-1-j]=res.get(j);
        }
        return result;

    }
}
