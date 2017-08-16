package Solution;

/**
 * Created by zhangwei on 2017/7/4.
 */
public class longestPalindromeSubstring2 {
    public static void main(String[] args) {
        System.out.print(longestPalindrome("jkdjsfkjdjjjj"));
    }
    public static String longestPalindrome(String s){
        if (s==null||s.length()==1||s.isEmpty()){
            return s;
        }
        String longestPalindromicSub = s.substring(0,1);
        for (int i=0;i<s.length();i++){
            String tmp = helper(s,i,i);

            if (tmp.length()>longestPalindromicSub.length()){
                longestPalindromicSub = tmp;
            }
            tmp = helper(s,i,i+1);
            if (tmp.length()>longestPalindromicSub.length()){
                longestPalindromicSub = tmp;
            }

        }
        return longestPalindromicSub;
    }

    private static String helper(String s, int begin, int end){
        while (begin>=0&&end<=s.length()-1&&s.charAt(begin)==s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin+1,end);
    }

}
