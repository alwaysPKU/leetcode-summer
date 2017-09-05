package someSort;

/**
 * Created by zhangwei on 2017/9/5.
 * 希尔排序(Shell Sort)是插入排序的一种。
 * 也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
 * 希尔排序是非稳定排序算法。
 *
 * 由于多次插入排序，我们知道一次插入排序是稳定的，
 * 不会改变相同元素的相对顺序，但在不同的插入排序过程中，
 * 相同的元素可能在各自的插入排序中移动，
 * 最后其稳定性就会被打乱，
 * 所以shell排序是不稳定的。
 *
 * 排序过程：先取一个正整数d1<n，
 * 把所有序号相隔d1的数组元素放一组，
 * 组内进行直接插入排序；
 * 然后取d2<d1，重复上述分组和排序操作；
 * 直至di=1，即所有记录放进一个组中排序为止。
 */
public class Shell_Sort {
    public static void shell_Sort(int[] a){
        //希尔排序
        int d=a.length;
        while(true)
        {
            d=d/2;
            for(int x=0;x<d;x++)
            {
                for(int i=x+d;i<a.length;i=i+d)
                {
                    int temp=a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d)
                    {
                        a[j+d]=a[j];
                    }
                    a[j+d]=temp;
                }
            }
            if(d==1)
            {
                break;
            }
        }
    }
}
