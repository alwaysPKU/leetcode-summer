package someSearch;


/**
 * Created by zhangwei on 2017/9/24.
 * 二叉树查找算法。
 * 基本思想：二叉查找树是先对待查找的数据进行生成树，
 * 确保树的左分支的值小于右分支的值，
 * 然后在就行和每个节点的父节点比较大小，查找最适合的范围。
 * 这个算法的查找效率很高，但是如果使用这种查找方法要首先创建树。
 *
 * 二叉查找树（BinarySearch Tree，也叫二叉搜索树，或称二叉排序树Binary Sort Tree）或者是一棵空树，
 * 或者是具有下列性质的二叉树：
    1）若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；

 　　2）若任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；

 　　3）任意节点的左、右子树也分别为二叉查找树。
 */
public class BinarySearchTree<T extends Comparable<T>>{
    //注意这里类并没有继承comparable所以不能重写方法，只是泛型继承了comparable
    //构建二叉树
    private BSTreeNode<T> root;//根节点

    //构造一个内部类BSTree节点
    public class BSTreeNode<T extends Comparable<T>>{
        T key;//键值（关键字）
        BSTreeNode<T> left ;
        BSTreeNode<T> right;
        BSTreeNode<T> parent;
        public BSTreeNode(T key, BSTreeNode<T> left, BSTreeNode<T> right, BSTreeNode<T> parent) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }


    //插入操作,本方法允许插入相同节点
    private void insert(BinarySearchTree<T> bst, BSTreeNode<T> z){
        int cmp;
        BSTreeNode<T> y =null;
        BSTreeNode<T> x = bst.root;
        //查找z的插入位置
        while (x!=null){
            y = x;
            cmp = z.key.compareTo(x.key);
            if (cmp<0) x= x.left;
            else x= x.right;
        }
        z.parent = y;
        if (y==null) bst.root=z;
        else {
            cmp=z.key.compareTo(y.key);
            if (cmp<0) y.left=z;
            else y.right=z;
        }
    }
    //查找
    private BSTreeNode<T> search (BinarySearchTree<T> bst, BSTreeNode<T> target){
        BSTreeNode<T> item = bst.root;
        while (item!=null){
            int tmp = target.key.compareTo(item.key);
            if (tmp==0) return item;
            else if (tmp<0) item=item.left;
            else item=item.right;
        }
        return item;
    }
}
