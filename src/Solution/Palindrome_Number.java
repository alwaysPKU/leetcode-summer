package Solution;

/**
 * Created by zhangwei on 2017/7/19.
 */
public class Palindrome_Number {
    public static void main(String[] args) {
        int a=7824783;
        isPalindrome(a);
    }
    public static boolean isPalindrome(int x){
        int len = String.valueOf(x).length();
        String xx = String.valueOf(x);
        if (len == 0||len==1) return true;
        for (int i =0;i<=len/2;i++){
            if(xx.charAt(i)==xx.charAt(len-i-1)) continue;
            else return false;
            }
        return true;
    }
}
