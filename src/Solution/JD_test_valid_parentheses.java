package Solution;


/**
 * Created by zhangwei on 2017/9/8.
 *
 * 京东算法第二题
 * 每次从左边去掉一个左括号，然后去掉一个右括号，有几种方法。
 */
public class JD_test_valid_parentheses {
    public static void main(String[] args) {
        String res = "((())()())";
        int re = valid_Num(res);
        System.out.print(re);
    }
    public static int valid_Num(String  parentheses){
        int num = 1;
        int mark = 0;
        char[] path = parentheses.toCharArray();
        for (int i = 0;i<path.length;i++){
            if (path[i]=='('){
                while (path[i]=='('&&i<path.length){
                    mark++;
                    i++;
                }
                num*=computer(mark);
            }
            mark=0;
        }
        return num;
    }
    public static int computer(int m){
        int res = 1;
        while (m!=1){
            res*=m;
            m--;
        }
        return res;
    }
}
