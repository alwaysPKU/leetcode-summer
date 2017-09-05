package someSort;

/**
 * Created by zhangwei on 2017/9/5.
 * 基数排序（radix sort）属于“分配式排序”（distribution sort），
 * 又称“桶子法”（bucket sort）或bin sort，
 * 顾名思义，它是透过键值的部份资讯，将要排序的元素分配至某些“桶”中，
 * 藉以达到排序的作用，基数排序法是属于稳定性的排序，
 * 其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，
 * 在某些时候，基数排序法的效率高于其它的稳定性排序法。
 *
 * 最高位优先(Most Significant Digit first)法，
 * 简称MSD法：先按k1排序分组，同一组中记录，
 * 关键码k1相等，再对各组按k2排序分成子组，之后，
 * 对后面的关键码继续这样的排序分组，直到按最次位关键码kd对各子组排序后。
 * 再将各组连接起来，便得到一个有序序列。
 *
 * 最低位优先(Least Significant Digit first)法，
 * 简称LSD法：先从kd开始排序，再对kd-1进行排序，
 * 依次重复，直到对k1排序后便得到一个有序序列。
 */
public class Radix_Sort {
    public static void radix_Sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}
