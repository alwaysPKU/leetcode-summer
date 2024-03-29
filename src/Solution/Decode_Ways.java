package Solution;

/**
 * Created by zhangwei on 2018/3/12.
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class Decode_Ways {
    public int numDecodings(String s) {
        if (s.length()==0||s==null||s=="0") return 0;
        int [] dp = new int[s.length()+1];
        dp[0]=1;
        if (isValid(s.substring(0, 1))){
            dp[1]=1;
        }else dp[1]=0;
        for (int i = 2 ; i <= s.length(); i++) {
            if (isValid(s.substring(i-1,i))){
                dp[i]+=dp[i-1];
            }
            if (isValid(s.substring(i-2,i))){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
    public boolean isValid(String s){
        if (s.charAt(0)=='0'){
            return false;
        }
        int code = Integer.parseInt(s);
        return code>=1 && code<=26;
    }
}
