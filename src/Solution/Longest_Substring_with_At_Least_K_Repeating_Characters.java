package Solution;

/**
 * Created by zhangwei on 2017/8/13.
 */
public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    public static void main(String[] args) {
        String s = "aaabb";
        System.out.print(longestSubstring(s,3));

    }
    public static int longestSubstring(String s, int k) {
        int result = 0,i=0, nums=s.length();
        while (i+k<=nums){
            int[] m = new int[26];
            int mask = 0, index = i;
            for (int j = i;j<nums;j++){
                int t = s.charAt(j)-'a';        //以a为基准0，b代表第2位，26个字母一次类推。
                ++m[t];                  //第t位置代表的字母数+1。
                if (m[t]<k) mask = mask | (1<<t); //把1移到第t位，与mask相与，把对应该位置的标志位改为1，代表不够数，其他位置数字不变。
                else mask = mask & ~(1<<t);//把1移位到第t位，取反与mask相或，把对应为标志改为0，代表够数了，其他位置数字不变。

                if (mask==0){
                    result = Math.max(result,j-i+1);
                    index = j;
                }
            }
            i=index+1;
        }
        return result;
    }
}


