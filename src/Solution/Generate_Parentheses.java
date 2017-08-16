package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/7/24.
 */
public class Generate_Parentheses {
    public static void main(String[] args) {
        int n =6;
        for (int i = 0;i<132;i++){
            System.out.println(generateParenthesis(n).size()-i+"--->"+generateParenthesis(n).get(i)+"  ");
        }
    }
    public static List<String> generateParenthesis(int n) {
        ArrayList<String > res = new ArrayList<>();
        String item = new String();

        if (n<0) return res;

        katelan(res,item,n,n);
        return res;

    }
    public static void katelan(ArrayList<String> res,String item, int left, int right){
        if (left>right) return;//如果剩余的left多，返回。

        if (left==0&&right==0){
            res.add(new String(item));
            return;
        }

        if (left>0){
            katelan(res,item+'(',left-1,right);
        }
        if (right>0){
            katelan(res,item+')',left,right-1);
        }
    }

}
