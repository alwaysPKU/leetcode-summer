package Solution;

/**
 * Created by zhangwei on 2017/7/22.
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] res = {"aba","ab"};

        System.out.print(longest_common_prefix(res));

    }

    private static String longest_common_prefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        if (strs == null || strs.length == 0) return "";

        int min = minString(strs);
        int index = 0;
        String result = strs[0];

        while (index < min) {
            for (int i = 0; i < strs.length; i++) {
                if (result.charAt(index) != strs[i].charAt(index) || strs[i].length() == index) {
                    return result.substring(0, index);
                }

            }
            index++;
        }
        return  result.substring(0,index);
    }

    private static int minString(String strs[]){
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<strs.length;i++){
            min=Math.min(min,strs[i].length());
        }
        return min;
    }
}
