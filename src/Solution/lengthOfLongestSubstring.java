package Solution;
import java.util.HashMap;

/**
 * Created by zhangwei on 2017/7/15.
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String test = "bbbb";
        int a = lensub(test);
        System.out.print(a);
    }

    public static int lensub(String s){
        char[] ss = s.toCharArray();
        int len = ss.length;
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for (int i = 0;i<len;i++){
            map.put(ss[i],1);
            int n = 1;
            for (int j = i+1;j<len;j++){
                if (map.containsKey(ss[j]))
                    break;
                else {
                    map.put(ss[j],1);
                    n++;
                }

            }
            if (n>count) count = n;
            map.clear();

        }
        return count;
    }



}
