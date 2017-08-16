package someSort;

/**
 * Created by zhangwei on 2017/7/20.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {44,22,11,33,66,99,88,77,75,42,16,98,34,38};
        quick_Sort(a,0,a.length-1);
        for (int i = 0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void quick_Sort(int[] a,int low, int high){
        if (low<high){
            int pivot = partation(a,low,high);
            quick_Sort(a,low,pivot-1);
            quick_Sort(a,pivot+1,high);
        }
    }
    private static int partation(int[] a,int low,int high){
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
