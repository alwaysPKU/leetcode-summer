package someSort;

/**
 * Created by zhangwei on 2017/9/5.
 * 不稳定
 * 选择排序是给每个位置选择当前元素最小的，
 * 比如给第一个位置选择最小的，在剩余元素里面给第二个元素选择第二小的，
 * 依次类推，直到第n - 1个元素，第n个元素不用选择了，
 * 因为只剩下它一个最大的元素了。
 * 那么，在一趟选择，如果当前元素比一个元素小，
 * 而该小的元素又出现在一个和当前元素相等的元素后面，
 * 那么交换后稳定性就被破坏了。
 * 比较拗口，举个例子，序列5 8 5 2 9，
 * 我们知道第一遍选择第1个元素5会和2交换，
 * 那么原序列中2个5的相对前后顺序就被破坏了，
 * 所以选择排序不是一个稳定的排序算法。
 */
public class Select_Sort {
    public static void selectSort(int[]a)
    {
        int minIndex=0;
        int temp=0;
        if((a==null)||(a.length==0))
            return;
        for(int i=0;i<a.length-1;i++)
        {
            minIndex=i;//无序区的最小数据数组下标
            for(int j=i+1;j<a.length;j++)
            {
                //在无序区中找到最小数据并保存其数组下标
                if(a[j]<a[minIndex])
                {
                    minIndex=j;
                }
            }
            if(minIndex!=i)
            {
                //如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
                temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }
        }
    }
}
