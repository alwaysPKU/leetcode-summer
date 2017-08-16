package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangwei on 2017/7/26.
 */
public class Substring_with_Concatenation_of_All_Words {
    public static void main(String[] args) {
        String s = "bookfootbraefootbook";
        String[] words = {"book", "foot"};
        List<Integer> re = findSubstring(s, words);
        System.out.print(re);
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s==null||s.length()==0||words==null||words.length==0) return result;

        int wordSize = words[0].length();

        HashMap<String, Integer> wMap = new HashMap<>();
        for (int i = 0;i<words.length;i++){
            if (wMap.containsKey(words[i])){
                wMap.put(words[i], wMap.get(words[i])+1);
            }else {
                wMap.put(words[i], 1);
            }
        }//遍历words放入wMap

        for (int i = 0; i<wordSize;i++){
            HashMap<String, Integer> curMap = new HashMap<>();
            int count = 0;
            int left = i;
            for (int j = i; j<=s.length()-wordSize;j+=wordSize){
                String tmp1 = s.substring(j,j+wordSize);

                if (wMap.containsKey(tmp1)){
                    if (curMap.containsKey(tmp1)){
                        curMap.put(tmp1,curMap.get(tmp1)+1);
                    }else {
                        curMap.put(tmp1,1);
                    }
                    if (curMap.get(tmp1)<=wMap.get(tmp1)){
                        count++;
                    }else {
                        while (curMap.get(tmp1)>wMap.get(tmp1)){
                            String tmp2 = s.substring(left,left+wordSize);
                            if (curMap.containsKey(tmp2)){
                                curMap.put(tmp2,curMap.get(tmp2)-1);
                                if (curMap.get(tmp2)<wMap.get(tmp2)) count--;

                            }
                            left +=wordSize;
                        }
                    }
                    if (count==words.length){
                        result.add(left);
                        String tmp3 = s.substring(left, left+wordSize);
                        if (curMap.containsKey(tmp3)) curMap.put(tmp3,curMap.get(tmp3)-1);
                        count--;
                        left+=wordSize;
                    }

                }else {
                    curMap.clear();
                    count=0;
                    left=j+wordSize;
                }
            }

        }//for i
        return  result;
    }

}