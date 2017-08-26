package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangwei on 2017/8/26.
 *
 * 二叉树非递归求解
 * 借助  栈
 *
 */
public class Binary_Tree_Inorder_Traversal_II {
    public static void main(String[] args) {

    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> tmp = new Stack<>();
        TreeNode item = root;

        while (item!=null||!tmp.isEmpty()){
            while (item!=null){
                tmp.push(item);
                item=item.left;
            }//把左子树全都入栈
            item = tmp.peek();
            result.add(tmp.pop().val);
            item=item.right;
        }
        return result;

    }

}
