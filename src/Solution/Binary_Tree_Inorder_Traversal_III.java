package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/26.
 * Morris Traversal：
 * 在介绍这种方法之前，我们先来引入一种新型树，叫 Threaded binary tree，
 * A binary tree is threaded by making all right child pointers
 * that would normally be null point to the inorder successor of
 * the node (if it exists), and all left child pointers that would
 * normally be null point to the inorder predecessor of the node.
 * 就是说螺纹二叉树实际上是把所有原本为空的右子节点指向了中序遍历顺序之后的那个节点，
 * 把所有原本为空的左子节点都指向了中序遍历之前的那个节点。
 * 我们需要构建一个螺纹二叉树，我们需要将所有为空的右子节点指向中序遍历的下一个节点，
 * 这样我们中序遍历完左子结点后，就能顺利的回到其根节点继续遍历了。
 *
 * 算法：
 * 1. 初始化指针cur指向root
 * 2. 当cur不为空时

 　 - 如果cur没有左子结点

 　     a) 打印出cur的值

 　　  b) 将cur指针指向其右子节点

 　 - 反之

 　    将pre指针指向cur的左子树中的最右子节点　

 　　　  * 若pre不存在右子节点

 　　　       a) 将其右子节点指回cur

 　　　　    b) cur指向其左子节点

 　　　  * 反之

 　　　　　 a) 将pre的右子节点置空

 　　　　　 b) 打印cur的值

 　　　　　 c) 将cur指针指向其右子节点
 */
public class Binary_Tree_Inorder_Traversal_III {
    public static void main(String[] args) {

    }
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if (root==null) return result;

        TreeNode cur,pre;
        cur=root;

        while (cur!=null){
            if (cur.left==null){
                result.add(cur.val);
                cur=cur.right;
            }//如果cur没有左子节点，打印该节点，cur指向其右节点
            else{//如果cur有左子节点，pre指向cur左子节点
                pre=cur.left;
                while (pre.right!=null&&pre.right!=cur) pre = pre.right;
                if (pre.right==null){
                    pre.right=cur;//右空子节点指向当前节点，即其中序遍历的下一个节点
                    cur=cur.left;
                }else {
                    pre.right=null;//切断连接
                    result.add(cur.val);//打印当前节点
                    cur=cur.right;//遍历右子节点
                }
            }
        }
        return result;
    }
}
