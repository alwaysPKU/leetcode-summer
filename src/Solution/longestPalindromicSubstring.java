package Solution;

import java.util.LongSummaryStatistics;

/**
 * Created by zhangwei on 2017/7/4.
 */
public class longestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.print(longestPalindrome("jk"));
    }

    public static String longestPalindrome(String s) {
        int MaxPalinlength = 0;
        String longestpalin = null;
        int length = s.length();

        for (int i =0; i<length;i++){
            for (int j = i;j<length;j++){
                int len = j-i+1;
                String curr = s.substring(i,j+1);
                if (isPalindromic(curr)){
                    if (len > MaxPalinlength){
                        longestpalin = curr;
                        MaxPalinlength = len;
                    }
                }
            }

        }

        return longestpalin;

    }

    public static boolean isPalindromic(String s){
        for (int i = 0; i<s.length();i++){
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

}
