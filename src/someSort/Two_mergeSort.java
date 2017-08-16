package someSort;

/**
 * Created by zhangwei on 2017/7/20.
 */
//归并排序需要额外空间
public class Two_mergeSort {
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        MergeSort(a,0,a.length-1);
        for (int i = 0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void Merge(int[] a ,int low, int mid, int high){
        int[] b= new int[a.length];
        System.out.println("merge " + low + "~" + mid+"~" + high);
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
