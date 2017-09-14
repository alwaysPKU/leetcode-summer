package Solution;
/**
 * Created by zhangwei on 2017/9/8.
 *
 * 京东笔试题
 *
 * 输入一个字符串s
 * 输出两个s（可有重合部分），长度最短
 */
public class JD_Double_String {
    public static void main(String[] args) {
        String s = "abracadabra";
        String res = double_S(s);
        System.out.print(res);

    }
    public static String double_S(String s){
        StringBuffer res = new StringBuffer(s);
        int mark = 0;
        if (s.length()==1) return String.valueOf(res.append(s));
        for (int i = 1;i<s.length();i++){
            int j = i;
            while (res.charAt(j)==res.charAt(mark)){
                if (j==s.length()-1) break;
                j++;
                mark++;
            }
            if (j==s.length()-1&&res.charAt(j)==res.charAt(mark)) {
                mark++;
                break;
            }
            else mark=0;
        }
        return res.append(res.substring(mark,s.length())).toString();
    }
}
