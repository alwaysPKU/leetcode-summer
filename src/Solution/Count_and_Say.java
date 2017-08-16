package Solution;

/**
 * Created by zhangwei on 2017/8/12.
 */
public class Count_and_Say {
    public static void main(String[] args) {
        System.out.print(countAndSay(2));
    }

    public static String countAndSay(int n) {
        String result = "1";
        int i =1;
        while (i<n){
            result = countandsayForString(result);
            i++;
        }
        return result;

    }
    public static String countandsayForString(String input){
        char tmp = input.charAt(0);
        int num = 1;
        StringBuffer newString = new StringBuffer();
        for (int i = 1;i<input.length();i++){
            if (input.charAt(i)==tmp){
                num++;
                continue;
            }
            newString.append(Integer.toString(num)+tmp);
            tmp = input.charAt(i);
            num=1;
        }
        newString.append(Integer.toString(num)+tmp);
        return newString.toString();

    }
}
