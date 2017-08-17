package Solution;

/**
 * Created by zhangwei on 2017/8/17.
 */
public class Wildcard_Matching_greedy {
    public static void main(String[] args) {
        System.out.print(isMatch("abab","a**b"));

    }
    public static boolean isMatch(String s, String p){
        int str= 0,pattern=0,match=0,starIdx=1;
        while (str<s.length()){
            if (pattern<p.length()&&(p.charAt(pattern)=='?'||s.charAt(str)==p.charAt(pattern))){
                str++;
                pattern++;
            }else if (pattern<p.length()&&p.charAt(pattern)=='*'){
                starIdx=pattern;
                match=str;
                pattern++;
            }else if (starIdx!=-1){
                pattern=starIdx+1;
                match++;
                str=match;
            }
            else return false;
        }
        while (pattern<p.length()&&p.charAt(pattern)=='*') pattern++;
        return pattern==p.length();
    }

}
