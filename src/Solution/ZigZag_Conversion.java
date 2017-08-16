package Solution;

import java.util.Arrays;

/**
 * Created by zhangwei on 2017/7/19.
 */
public class ZigZag_Conversion {
    public static void main(String[] args) {
        String s = convert("lkjsdkfjdskjfk",3);
        System.out.print(s);
    }
    public static String convert(String s,int numRows){
        int len = s.length();
        if (len==0||numRows<=1) return s;
        String result[] = new String[numRows];
        Arrays.fill(result,"");
        int delta =1;
        int row = 0;
        for (int i = 0;i<len;i++){

            result[row]+=s.charAt(i);
            row+=delta;
            if (row>=numRows){
                row=numRows-2;
                delta=-1;
            }
            if (row<0){
                row=1;
                delta=1;
            }


        }
        String re = "";
        for (int i =0;i<numRows;i++){
            re = re+result[i];
        }
        return re;
    }
}
