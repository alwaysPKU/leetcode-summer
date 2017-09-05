package someSort;

/**
 * Created by zhangwei on 2017/7/20.
 *
 * 不稳定
 * 快速排序
 * 有两个方向，左边的i下标一直往右走，
 * 当a[i] <= a[center_index]，其中center_index是中枢元素的数组下标，
 * 一般取为数组第0个元素。而右边的j下标一直往左走，
 * 当a[j] > a[center_index]。
 * 如果i和j都走不动了，i <= j，交换a[i]和a[j],
 * 重复上面的过程，直到i > j。
 * 交换a[j]和a[center_index]，完成一趟快速排序。
 * 在中枢元素和a[j]交换的时候，很有可能把前面的元素的稳定性打乱，
 * 比如序列为5 3 3 4 3 8 9 10 11，现在中枢元素5和3（
 * 第5个元素，下标从1开始计）交换就会把元素3的稳定性打乱，
 * 所以快速排序是一个不稳定的排序算法，
 * 不稳定发生在中枢元素和a[j] 交换的时刻。
 *
 */
public class QuickSort {
//    public static void main(String[] args) {
//        int[] a = {44,22,11,33,66,99,88,77,75,42,16,98,34,38};
//        quick_Sort(a,0,a.length-1);
//        for (int i = 0; i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }

    public static void quick_Sort(int[] a,int low, int high){
        if (low<high){
            int pivot = partition(a,low,high);
            quick_Sort(a,low,pivot-1);
            quick_Sort(a,pivot+1,high);
        }
    }
    private static int partition(int[] a,int low,int high){
        int pivot = a[low];
        while (low<high){
            while (low<high&&a[high]>=pivot) high--;
            a[low]=a[high];
            while (low<high&&a[low]<=pivot) low++;
            a[high]=a[low];
        }
        a[low]=pivot;
        return low;
    }
}
