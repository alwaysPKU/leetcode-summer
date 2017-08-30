package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/27.
 * 递归
 * 后序遍历二叉树
 */
public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        poster(root,res);
        return res;
    }
    private void poster(TreeNode root,List<Integer> res){
        if (root==null) return;
        if (root.left!=null) poster(root.left,res);
        if (root.right!=null) poster(root.right,res);
        res.add(root.val);
    }
}
