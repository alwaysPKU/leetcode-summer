package someSort;

/**
 * Created by zhangwei on 2017/7/20.
 * 归并排序是把序列递归地分成短序列，
 * 递归出口是短序列只有1个元素（认为直接有序）或者2个序列（1次比较和交换），
 * 然后把各个有序的段序列合并成一个有序的长序列，
 * 不断合并直到原序列全部排好序。
 * 可以发现，在1个或2个元素时，1个元素不会交换，
 * 2个元素如果大小相等也没有人故意交换，这不会破坏稳定性。
 * 那么，在短的有序序列合并的过程中，稳定是是否受到破坏？
 * 没有，合并过程中我们可以保证如果两个当前元素相等时，
 * 我们把处在前面的序列的元素保存在结果序列的前面，
 * 这样就保证了稳定性。所以，归并排序也是稳定的排序算法。
 */

//归并排序需要额外空间
public class Two_mergeSort {
//    public static void main(String[] args) {
//        int[] a = {9,8,7,6,5,4,3,2,1};
//        MergeSort(a,0,a.length-1);
//        for (int i = 0; i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }
    public static void Merge(int[] a ,int low, int mid, int high){
        int[] b= new int[a.length];
        System.out.println("merge " + low + "~" + mid+"~" + high);
        //把a里的两部分给归并了
        int tag1=low,tag2=mid+1,tag3=low;
        while (tag1<=mid&&tag2<=high){
            if (a[tag1]<a[tag2]) b[tag3++]=a[tag1++];
            else b[tag3++]=a[tag2++];
        }
        while (tag1<=mid) {b[tag3++]=a[tag1++];}
        while (tag2<=high) {b[tag3++]=a[tag2++];}

        for (int i = low; i <= high; i++)
            a[i] = b[i];

        for (int p : a) System.out.print(p + " ");
        System.out.println();

    }
    public static void MergeSort(int[] a ,int low,int high){
        if (low<high){
            int mid = (low+high)/2;
            MergeSort(a,low,mid);
            MergeSort(a,mid+1,high);
            Merge(a,low,mid,high);
        }
    }
}
