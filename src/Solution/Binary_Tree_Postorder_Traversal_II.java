package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangwei on 2017/8/27.
 */
public class Binary_Tree_Postorder_Traversal_II {
    public List<Integer> postorderTraversal(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode item = root;
        Stack<TreeNode> output = new Stack<>();

        while (item!=null||!s.isEmpty()){
            while (item!=null){
                output.push(item);
                s.push(item);
                item=item.right;
            }
            item = s.pop();
            item = item.left;

        }
        while (!output.isEmpty()){
            res.add(output.pop().val);
        }
        return res;
    }
}
