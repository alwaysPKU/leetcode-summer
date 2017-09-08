package Solution;

import java.util.Stack;

/**
 * Created by zhangwei on 2017/7/23.
 * 合法的括号匹配
 */
public class Valid_Parentheses {
    public static boolean isValid(String s) {
        if (s.length()==0||s.length()==1) return false;

        Stack<Character> cup = new Stack<>();
        int len = s.length();
        for (int i = 0;i<len;i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') cup.push(s.charAt(i));
            else {
                if (cup.size()==0) return false;
                char top = cup.pop();
                if (s.charAt(i)==')') if (top!='(') return false;
                if (s.charAt(i)==']') if (top!='[') return false;
                if (s.charAt(i)=='}') if (top!='{') return false;
            }
        }
        return cup.size()==0;
    }

}
