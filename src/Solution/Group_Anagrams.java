package Solution;

import java.util.*;

/**
 * Created by zhangwei on 2017/9/4.
 * 按词典排序
 */
public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String iter : strs){
            char[] chars = iter.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(iter);
        }
        for (String key : map.keySet()){
            List<String > list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;

    }
}
