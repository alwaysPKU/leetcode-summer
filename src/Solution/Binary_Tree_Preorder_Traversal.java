package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/27.
 * 递归
 * 前序遍历二叉树
 */
public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    private void preorder(TreeNode root,List<Integer> res){
        if (root==null) return;
        res.add(root.val);
        if (root.left!=null)  preorder(root.left,res);
        if (root.right!=null) preorder(root.right,res);
    }

}
