package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/7/23.
 */
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        String num="23";
        List<String> result = letterCombinations(num);
        for (int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }

    public static String digit2string(char num){
        String res=null;
        switch (num){
            case '2':res="abc";break;
            case '3':res="def";break;
            case '4':res="ghi";break;
            case '5':res="jkl";break;
            case '6':res="mno";break;
            case '7':res="pqrs";break;
            case '8':res="tuv";break;
            case '9':res="wxyz";break;
            default:res=null;break;
        }
        return res;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result_num2str = new ArrayList<>();
        List<String> result_str = new ArrayList<>();

        for (int i=0;i<digits.length();i++){
            if (digits.charAt(i)!='0'&&digits.charAt(i)!='1'){
               result_num2str.add(digit2string(digits.charAt(i)));
            }
        }
        for (int i =0;i<result_num2str.size();i++){
            result_str = merge_string(result_str,result_num2str.get(i));
        }
        return result_str;


    }

    private static List<String> merge_string(List<String> result,String str){
        if (str==null) return result;
        List<String> merge_res = new ArrayList<>();
        if (result.size()==0){
            for (int i =0;i<str.length();i++){
                merge_res.add(String.valueOf(str.charAt(i)));
               // return merge_res;
            }
        }else {
            for (int j =0;j<str.length();j++){
                for (int k=0;k<result.size();k++){
                    merge_res.add(result.get(k)+str.charAt(j));
                }
            }
            //return merge_res;
        }
        return merge_res;
    }



}
