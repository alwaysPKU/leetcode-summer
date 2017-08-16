package Solution;

/**
 * Created by zhangwei on 2017/8/15.
 */
public class Multiply_Strings {
    public static void main(String[] args) {

    }
    public static String multiply(String num1, String num2) {
        if (num1==null||num1.length()==0||num2==null||num2.length()==0) return "";
        if (num1.charAt(0)=='0'||num2.charAt(0)=='0') return "0";

        StringBuilder result = new StringBuilder();
        int num = 0;
        for (int i =num1.length()+num2.length();i>0;i--){
            for (int j = Math.min(i-1,num1.length());j>0;j--){
                if (i-j<=num2.length()){
                    num+=(int)(num1.charAt(j-1)-'0')*(int)(num2.charAt(i-1-j)-'0');
                }
                else break;
            }
            if (i!=1||num>0) result.append(num%10);
            num=num/10;
        }
        return result.reverse().toString();
    }
}
