package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangwei on 2017/8/27.
 *
 * 非递归
 * 前序遍历
 *
 */
public class Binary_Tree_Preorder_Traversal_II {
    public List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode item = root;
        while (item!=null||!s.isEmpty()){
            while (item!=null){
                res.add(item.val);
                s.push(item);
                item=item.left;
            }//左子树全都入栈
            item=s.peek();
            s.pop();
            item=item.right;
        }
        return res;
    }
}
