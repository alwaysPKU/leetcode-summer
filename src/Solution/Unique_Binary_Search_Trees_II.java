package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangwei on 2017/8/26.
 *
 * 1. 每一次都在一个范围内随机选取一个结点作为根。
 * 2. 每选取一个结点作为根，就把树切分成左右两个子树，直至该结点左右子树为空。
 *
 * 大致思路如上，可以看出这也是一个可以划分成子问题求解的题目，所以考点是动态规划。
 * 但具体对于本题来说，采取的是自底向上的求解过程。
 * 1. 选出根结点后应该先分别求解该根的左右子树集合，也就是根的左子树有若干种，
 *    它们组成左子树集合，根的右子树有若干种，它们组成右子树集合。
 * 2. 然后将左右子树相互配对，每一个左子树都与所有右子树匹配，
 *    每一个右子树都与所有的左子树匹配。然后将两个子树插在根结点上。
 * 3. 最后，把根结点放入链表中。
 *
 *
 */
public class Unique_Binary_Search_Trees_II {
    public static void main(String[] args) {

    }
    public List<TreeNode> generateTrees(int n) {
        if (n<1){
            return new ArrayList<>();
        }
        return helper(1,n);
    }
    public static List<TreeNode> helper(int start,int end){
        List<TreeNode> result = new ArrayList<>();
        if (start>end){
            result.add(null);
            return result;
        }
        for (int i = start;i<=end;i++){
            List<TreeNode> leftChild = helper(start,i-1);
            List<TreeNode> rightChild = helper(i+1,end);
            for (TreeNode left : leftChild){
                for (TreeNode right : rightChild){
                    TreeNode root = new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                }
            }
        }
        return result;
    }


}
