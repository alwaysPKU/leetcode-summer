package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/26.
 * 递归中序遍历二叉树
 */
public class Binary_Tree_Inorder_Traversal {
    public static void main(String[] args) {

    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;

    }
    public static void inorder(TreeNode root, List<Integer> result){
        if (root==null) return;
        if (root.left!=null) inorder(root.left,result);
        result.add(root.val);
        if (root.right!=null) inorder(root.right,result);
    }
}
