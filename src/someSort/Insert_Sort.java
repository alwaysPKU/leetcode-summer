package someSort;

/**
 * Created by zhangwei on 2017/9/5.
 * 有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，
 * 但要求插入后此数据序列仍然有序，
 * 这个时候就要用到一种新的排序方法——插入排序法,
 * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
 * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，
 * 时间复杂度为O(n^2)。
 *
 * 是稳定的排序方法。
 */
public class Insert_Sort {
    public static void insertSort(int[]arr){
        if(arr == null || arr.length < 2){
            return ;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }else{
                    break;
                }
            }
        }
    }
}
