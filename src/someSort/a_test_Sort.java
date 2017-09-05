package someSort;

/**
 * Created by zhangwei on 2017/9/5.
 */
public class a_test_Sort {
    public static void main(String[] args) {
        //快排
        int[] a = {44, 22, 11, 33, 66, 99, 88, 77, 75, 42, 16, 98, 34, 38};
        QuickSort.quick_Sort(a, 0, a.length - 1);
        System.out.println("快排");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //堆排序
        System.out.println("\n"+"堆排序");
        int[] a1 = {834,4,4654,4,6,46,84,7,45,68,22,44,66,78,31};
        int[] result =heapSort.heap_sort(a1);
        for (int i =0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        //二分归并
        System.out.println("\n"+"二分归并");
        int[] a2 = {9,8,7,6,5,4,3,2,1};
        Two_mergeSort.MergeSort(a2,0,a2.length-1);
//        for (int i = 0; i<a2.length;i++) {
//            System.out.print(a2[i] + " ");
//        }
        //选择排序
        System.out.println("\n"+"选择排序");
        int[] a3 = {9,8,7,6,5,4,3,2,1};
        Select_Sort.selectSort(a3);
        for (int i = 0; i<a3.length;i++){
            System.out.print(a3[i]+" ");
        }
        //冒泡
        System.out.println("\n"+"冒泡排序");
        int[] a4 = {9,8,7,6,5,4,3,2,1};
        Bubble_Sort.bubble_Sort(a4);
        for (int i = 0; i<a4.length;i++){
            System.out.print(a4[i]+" ");
        }
        //插入排序
        System.out.println("\n"+"插入排序");
        int[] a5 = {834,4,4654,4,6,46,84,7,45,68,22,44,66,78,31};
        Insert_Sort.insertSort(a5);
        for (int i =0;i<a5.length;i++){
            System.out.print(a5[i]+" ");
        }
        //基数排序
        System.out.println("\n"+"基数排序");
        int[] a6 = {834,4,4654,4,6,46,84,7,45,68,22,44,66,78,31};
        Radix_Sort.radix_Sort(a6,4);
        for (int i =0;i<a6.length;i++){
            System.out.print(a6[i]+" ");
        }
        //希尔排序
        System.out.println("\n"+"希尔排序");
        int[] a7 = {834,4,4654,4,6,46,84,7,45,68,22,44,66,78,31};
        Shell_Sort.shell_Sort(a7);
        for (int i =0;i<a7.length;i++){
            System.out.print(a7[i]+" ");
        }
    }
}
