package Solution;

import java.util.Stack;

/**
 * Created by zhangwei on 2017/7/31.
 */
public class Longest_Valid_Parentheses {
    public static void main(String[] args) {

    }
    private static int longestValidParentheses(String s) {
        if (s==null||s.length()==0) return 0;

        int start = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    start = i+1;
                }else {
                    stack.pop();
                    if (stack.isEmpty()){
                        maxLen=Math.max(i-start+1,maxLen);
                    }else {
                        maxLen=Math.max(i-stack.peek(),maxLen);
                    }
                }
            }

        }
        return maxLen;
    }
}
