package someSearch;

/**
 * Created by zhangwei on 2017/9/24.
 * 说明：元素必须是有序的，如果是无序的则要先进行排序操作。

 　　基本思想：也称为是折半查找，属于有序查找算法。
 用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，
 若相等则查找成功；若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，
 这样递归进行，直到查找到或查找结束发现表中没有这样的结点。

 　　复杂度分析：最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)；

 　　注：折半查找的前提条件是需要有序表顺序存储，
 对于静态查找表，一次排序后不再变化，
 折半查找能得到不错的效率。
 但对于需要频繁执行插入或删除操作的数据集来说，
 维护有序的排序会带来不小的工作量，那就不建议使用。——《大话数据结构》
 */
public class BinarySearch {
    //费递归形式
    public int binary_Search(int[] arry,int target){
        int low = 0;
        int high = arry.length-1;
        while (low<high){
            int pivot = (low+high)/2;
            if (arry[pivot]==target) return pivot;
            else if (arry[pivot]<target) low=pivot+1;
            else high=pivot-1;
        }
        return -1;
    }
    //递归形式
    public int binary_Search_II(int[]arry ,int target, int low, int high){
        if (low>high) return -1;
        int mid = (low+high)/2;
        if (arry[mid]==target) return mid;
        else if (arry[mid]<target) return binary_Search_II(arry,target,mid+1,high);
        else return binary_Search_II(arry,target,low,mid-1);
    }
}
