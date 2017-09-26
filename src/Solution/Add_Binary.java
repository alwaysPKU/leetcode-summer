package Solution;

/**
 * Created by zhangwei on 2017/9/25.
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Add_Binary {
    public String addBinary(String a, String b) {
        if (a==null||a.length()==0) return b;
        if (b==null||b.length()==0) return a;
        int a_len = a.length();
        int b_len = b.length();
        int item = 0;
        StringBuilder res = new StringBuilder();

        while (a_len>0&&b_len>0){
            int task = a.charAt(a_len-1)-'0'+b.charAt(b_len-1)-'0'+item;
            item=task/2;
            task%=2;
            res.append(task);
            a_len--;
            b_len--;
        }
        while (a_len>0){
            int task = a.charAt(a_len-1)-'0'+item;
            item=task/2;
            task%=2;
            res.append(task);
            a_len--;
        }
        while (b_len>0){
            int task = (int)(b.charAt(b_len-1)-'0'+item);
            item=task/2;
            task%=2;
            res.append(task);
            b_len--;
        }
        if (item>0){
            res.append(item);
        }
        return res.reverse().toString();
    }
}
