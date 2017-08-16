package Solution;

/**
 * Created by zhangwei on 2017/7/26.
 */
public class Implement_strStr {
    public static void main(String[] args) {
        String a = "1";
        String b = "";
        System.out.print(strStr(a, b));

    }
    private static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2==0) return 0;

        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int index = -1;

        for (int i = 0;i<=len1-len2;i++){
            int j =0;
            int count = 0;

            while (hay[i]==need[j]){
                if (j==len2-1) return i-count;
                i++;
                j++;
                count++;
            }
            i = i-count;

        }
        return index;

    }
}
